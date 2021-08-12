package br.com.pedrofarbo.controllers.request;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

public class CallbackRequest implements Serializable {

    @FormParam("SmsSid")
    @PartType(MediaType.TEXT_PLAIN)
    public String smsSid;

    @FormParam("SmsStatus")
    @PartType(MediaType.TEXT_PLAIN)
    public String smsStatus;

    @FormParam("MessageSid")
    @PartType(MediaType.TEXT_PLAIN)
    public String messageSid;

    @FormParam("MessageStatus")
    @PartType(MediaType.TEXT_PLAIN)
    public String messageStatus;

    public CallbackRequest() {
    }

    public String getSmsSid() {
        return smsSid;
    }

    public void setSmsSid(String smsSid) {
        this.smsSid = smsSid;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
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
    public String toString() {
        return "CallbackRequest{" +
                "smsSid='" + smsSid + '\'' +
                ", smsStatus='" + smsStatus + '\'' +
                ", messageSid='" + messageSid + '\'' +
                ", messageStatus='" + messageStatus + '\'' +
                '}';
    }
}
