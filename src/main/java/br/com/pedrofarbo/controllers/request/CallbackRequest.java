package br.com.pedrofarbo.controllers.request;

import java.io.Serializable;

public class CallbackRequest implements Serializable {
    public String MessageSid;
    public String MessageStatus;

    public CallbackRequest() {
    }

    public String getMessageSid() {
        return MessageSid;
    }

    public String getMessageStatus() {
        return MessageStatus;
    }

    @Override
    public String toString() {
        return "CallbackRequest{" +
                "MessageSid='" + MessageSid + '\'' +
                ", MessageStatus='" + MessageStatus + '\'' +
                '}';
    }
}
