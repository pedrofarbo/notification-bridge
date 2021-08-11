package br.com.pedrofarbo.repository;

import br.com.pedrofarbo.models.Notification;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class NotificationRepository implements PanacheRepository<Notification> {

    public List<Notification> listAll() {
        return listAll();
    }

    public List<Notification> findAllByStatusAndType(String status, String type){
        return list("status = :status AND type = :type", Parameters.with("status", status).and("type", type));
    }

    @Transactional
    public Notification save(Notification notification) {
        persist(notification);
        return notification;
    }

    @Transactional
    public Notification update(Long id, Notification notification) {
        Notification notificationEntity = findById(id);

        if (notificationEntity == null) {
            throw new WebApplicationException("Notification with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        notificationEntity.setStatus(notification.getStatus());
        notificationEntity.setMessageSid(notification.getMessageSid());
        notificationEntity.setQueuedDate(notification.getQueuedDate() != null ? notification.getQueuedDate() : null);
        notificationEntity.setSendingDate(notification.getSendingDate() != null ? notification.getSendingDate() : null);
        notificationEntity.setSentDate(notification.getSentDate() != null ? notification.getSentDate() : null);
        notificationEntity.setDeliveredDate(notification.getDeliveredDate() != null ? notification.getDeliveredDate() : null);
        notificationEntity.setFailedDate(notification.getFailedDate() != null ? notification.getFailedDate() : null);

        persist(notificationEntity);

        return notificationEntity;
    }

    public Notification findByMessageSid(String messageSid) {
        return find("messageSid", messageSid).firstResult();
    }
}
