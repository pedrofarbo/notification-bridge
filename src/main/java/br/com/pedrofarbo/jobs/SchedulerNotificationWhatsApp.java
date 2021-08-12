package br.com.pedrofarbo.jobs;

import br.com.pedrofarbo.integrations.TwilioIntegration;
import br.com.pedrofarbo.integrations.TwillioConfig;
import br.com.pedrofarbo.models.Notification;
import br.com.pedrofarbo.models.NotificationStatusEnum;
import br.com.pedrofarbo.models.NotificationTypeEnum;
import br.com.pedrofarbo.repository.NotificationRepository;
import com.twilio.rest.api.v2010.account.Message;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class SchedulerNotificationWhatsApp {

    @Inject
    NotificationRepository notificationRepository;

    @Inject
    TwilioIntegration twilioIntegration;

    @Scheduled(every = "30s")
    public void sendNotification() {
        System.out.println("--------- Iniciando Job Send | Notification WhatsApp --------------");

        List<Notification> notificationList = notificationRepository.findAllByStatusAndType(NotificationStatusEnum.ACCEPTED.name(), NotificationTypeEnum.WHATSAPP.name());

        if (!notificationList.isEmpty()) {
            try {
                notificationList.forEach(notification -> {
                    Message message = twilioIntegration.sendWhatsApp(notification);

                    if (message != null) {
                        notification.setMessageSid(message.getSid());
                        notification.setStatus(NotificationStatusEnum.valueOf(message.getStatus().name()).name());

                        if(message.getStatus().name().equalsIgnoreCase(NotificationStatusEnum.QUEUED.toString())) {
                            notification.setQueuedDate(LocalDateTime.now());
                        }

                        Notification response = notificationRepository.update(notification.getId(), notification);
                    }
                });
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        System.out.println("--------- Encerrando Job Send | Notification WhatsApp --------------");
    }
}
