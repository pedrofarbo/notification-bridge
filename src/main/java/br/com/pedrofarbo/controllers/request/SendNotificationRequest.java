package br.com.pedrofarbo.controllers.request;

import java.io.Serializable;

public class SendNotificationRequest implements Serializable {
    public String type;
    public String from;
    public String to;
    public String message;
    public String urlHookResponse;
    public String emailHookResponse;

    public SendNotificationRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrlHookResponse() {
        return urlHookResponse;
    }

    public void setUrlHookResponse(String urlHookResponse) {
        this.urlHookResponse = urlHookResponse;
    }

    public String getEmailHookResponse() {
        return emailHookResponse;
    }

    public void setEmailHookResponse(String emailHookResponse) {
        this.emailHookResponse = emailHookResponse;
    }

    @Override
    public String toString() {
        return "SendNotificationRequest{" +
                "type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                ", urlHookResponse='" + urlHookResponse + '\'' +
                ", emailHookResponse='" + emailHookResponse + '\'' +
                '}';
    }
}
