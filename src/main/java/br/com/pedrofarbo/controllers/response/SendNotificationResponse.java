package br.com.pedrofarbo.controllers.response;

import java.io.Serializable;

public class SendNotificationResponse implements Serializable {
    public Long id;
    public String status;

    public SendNotificationResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SendNotificationResponse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
