package br.com.pedrofarbo.services;

import br.com.pedrofarbo.controllers.request.CallbackRequest;
import br.com.pedrofarbo.controllers.request.SendNotificationRequest;
import br.com.pedrofarbo.controllers.response.SendNotificationResponse;
import br.com.pedrofarbo.models.Notification;
import br.com.pedrofarbo.models.NotificationStatusEnum;
import br.com.pedrofarbo.repository.NotificationRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
@Transactional
public class NotificationService {

    @Inject
    NotificationRepository notificationRepository;

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private Client client;

    public SendNotificationResponse sendNotification(SendNotificationRequest sendNotificationRequest) throws Exception {
        SendNotificationResponse sendNotificationResponse = new SendNotificationResponse();

        try {
            Notification notification = new Notification();
            notification.setType(sendNotificationRequest.getType());
            notification.setStatus(NotificationStatusEnum.ACCEPTED.toString());
            notification.setClientId(1251);
            notification.setFrom(sendNotificationRequest.getFrom());
            notification.setTo(sendNotificationRequest.getTo());
            notification.setMessage(sendNotificationRequest.getMessage());
            notification.setHookEmail(sendNotificationRequest.getEmailHookResponse() != null ? sendNotificationRequest.getEmailHookResponse() : null);
            notification.setHookUrl(sendNotificationRequest.getUrlHookResponse() != null ? sendNotificationRequest.getUrlHookResponse() : null);
            notification.setAcceptedDate(LocalDateTime.now());

            Notification response = notificationRepository.save(notification);

            sendNotificationResponse.setId(response.getId());
            sendNotificationResponse.setStatus(response.getStatus());
        } catch (Exception e) {
            throw new Exception("Erro ao salvar a notificação", e);
        }

        return sendNotificationResponse;
    }

    public void notificationCallback(CallbackRequest callbackRequest) {
        Notification notification = notificationRepository.findByMessageSid(callbackRequest.getMessageSid());

        if(notification != null) {
            switch (callbackRequest.getMessageStatus().toUpperCase()) {
                case "SENDING":
                    notification.setSendingDate(LocalDateTime.now());
                    notification.setStatus(NotificationStatusEnum.SENDING.name());
                    break;
                case "SENT":
                    notification.setSentDate(LocalDateTime.now());
                    notification.setStatus(NotificationStatusEnum.SENT.name());
                    break;
                case "DELIVERED":
                    notification.setDeliveredDate(LocalDateTime.now());
                    notification.setStatus(NotificationStatusEnum.DELIVERED.name());
                    break;
                case "FAILED":
                    notification.setFailedDate(LocalDateTime.now());
                    notification.setStatus(NotificationStatusEnum.FAILED.name());
                    break;
                case "READ":
                    notification.setStatus(NotificationStatusEnum.READ.name());
                    break;
                default:
                    //Do Nothing
            }

            Notification response = notificationRepository.update(notification.getId(), notification);

            if(response.getHookUrl() != null) {
                this.notifyClientHookUrl(response);
            }

            if(response.getHookEmail() != null) {
                this.notifyClientEmail();
            }
        }
    }

    public void notifyClientHookUrl(Notification notification) {
        try {
            client = ClientBuilder.newBuilder()
                    .executorService(executorService)
                    .build();

            client.target(notification.getHookUrl()).request().post(Entity.entity(notification, "application/json"));
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void notifyClientEmail() {
        //TODO
    }
}
