package br.com.pedrofarbo.controllers;

import br.com.pedrofarbo.controllers.request.CallbackRequest;
import br.com.pedrofarbo.services.NotificationService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/notification-bridge-callback")
public class NotificationBridgeCallbackController {

    @Inject
    NotificationService notificationService;

    @POST
    @Produces(MediaType.TEXT_XML)
    @Transactional
    public String callback(String MessageStatus, String MessageSid) throws Exception {
        try {
            CallbackRequest callbackRequest = new CallbackRequest();
            callbackRequest.setMessageStatus(MessageStatus);
            callbackRequest.setMessageSid(MessageSid);

            System.out.println(callbackRequest);

            notificationService.notificationCallback(callbackRequest);

            return "<Response/>";
        } catch (Exception e) {
            throw new Exception("Erro ao receber o callback de atualização do provider", e);
        }
    }
}
