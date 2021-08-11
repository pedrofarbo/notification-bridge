package br.com.pedrofarbo.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Notification extends PanacheEntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="message_sid")
    public String messageSid;

    @Column(name="client_id")
    public Integer clientId;

    @Column
    public String type;

    @Column
    public String status;

    @Column
    public String message;

    @Column(name="phone_from")
    public String from;

    @Column(name="phone_to")
    public String to;

    @Column(name="hook_url")
    public String hookUrl;

    @Column(name="hook_email")
    public String hookEmail;

    @Column(name="accepted_date")
    public LocalDateTime acceptedDate;

    @Column(name="queued_date")
    public LocalDateTime queuedDate;

    @Column(name="sending_date")
    public LocalDateTime sendingDate;

    @Column(name="sent_date")
    public LocalDateTime sentDate;

    @Column(name="delivered_date")
    public LocalDateTime deliveredDate;

    @Column(name="failed_date")
    public LocalDateTime failedDate;

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHookUrl() {
        return hookUrl;
    }

    public void setHookUrl(String hookUrl) {
        this.hookUrl = hookUrl;
    }

    public String getHookEmail() {
        return hookEmail;
    }

    public void setHookEmail(String hookEmail) {
        this.hookEmail = hookEmail;
    }

    public String getMessageSid() {
        return messageSid;
    }

    public void setMessageSid(String messageSid) {
        this.messageSid = messageSid;
    }

    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public LocalDateTime getQueuedDate() {
        return queuedDate;
    }

    public void setQueuedDate(LocalDateTime queuedDate) {
        this.queuedDate = queuedDate;
    }

    public LocalDateTime getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDateTime sendingDate) {
        this.sendingDate = sendingDate;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public LocalDateTime getFailedDate() {
        return failedDate;
    }

    public void setFailedDate(LocalDateTime failedDate) {
        this.failedDate = failedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(messageSid, that.messageSid) && Objects.equals(clientId, that.clientId) && Objects.equals(type, that.type) && Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(hookUrl, that.hookUrl) && Objects.equals(hookEmail, that.hookEmail) && Objects.equals(acceptedDate, that.acceptedDate) && Objects.equals(queuedDate, that.queuedDate) && Objects.equals(sendingDate, that.sendingDate) && Objects.equals(sentDate, that.sentDate) && Objects.equals(deliveredDate, that.deliveredDate) && Objects.equals(failedDate, that.failedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageSid, clientId, type, status, message, from, to, hookUrl, hookEmail, acceptedDate, queuedDate, sendingDate, sentDate, deliveredDate, failedDate);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", messageSid='" + messageSid + '\'' +
                ", clientId=" + clientId +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", hookUrl='" + hookUrl + '\'' +
                ", hookEmail='" + hookEmail + '\'' +
                ", acceptedDate=" + acceptedDate +
                ", queuedDate=" + queuedDate +
                ", sendingDate=" + sendingDate +
                ", sentDate=" + sentDate +
                ", deliveredDate=" + deliveredDate +
                ", failedDate=" + failedDate +
                '}';
    }
}
