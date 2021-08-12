package br.com.pedrofarbo.controllers;

import br.com.pedrofarbo.controllers.request.CallbackRequest;
import br.com.pedrofarbo.services.NotificationService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

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
    public String callback(@MultipartForm CallbackRequest callbackRequest) throws Exception {
        try {
            System.out.println(callbackRequest.toString());

            notificationService.notificationCallback(callbackRequest);

            return "<Response/>";
        } catch (Exception e) {
            throw new Exception("Erro ao receber o callback de atualização do provider", e);
        }
    }
}
