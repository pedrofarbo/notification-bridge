package br.com.pedrofarbo.controllers.request;

import java.io.Serializable;
import java.util.Objects;

public class CallbackRequest implements Serializable {

    public String messageSid;
    public String messageStatus;

    public CallbackRequest() {
    }

    public String getMessageSid() {
        return messageSid;
    }

    public void setMessageSid(String messageSid) {
        this.messageSid = messageSid;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallbackRequest that = (CallbackRequest) o;
        return Objects.equals(messageSid, that.messageSid) && Objects.equals(messageStatus, that.messageStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageSid, messageStatus);
    }

    @Override
    public String toString() {
        return "CallbackRequest{" +
                "messageSid='" + messageSid + '\'' +
                ", messageStatus='" + messageStatus + '\'' +
                '}';
    }
}
