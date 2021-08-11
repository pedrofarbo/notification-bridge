package br.com.pedrofarbo.controllers.response;

import java.io.Serializable;

public class CallbackResponse implements Serializable {
    public Long id;
    public String messageSid;
    public String status;

    public CallbackResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageSid() {
        return messageSid;
    }

    public void setMessageSid(String messageSid) {
        this.messageSid = messageSid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CallbackResponse{" +
                "id='" + id + '\'' +
                ", messageSid='" + messageSid + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
