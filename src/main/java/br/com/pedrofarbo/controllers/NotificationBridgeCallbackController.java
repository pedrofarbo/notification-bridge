package br.com.pedrofarbo.controllers;

import br.com.pedrofarbo.controllers.request.CallbackRequest;
import br.com.pedrofarbo.controllers.response.CallbackResponse;
import br.com.pedrofarbo.services.NotificationService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/notification-bridge-callback")
public class NotificationBridgeCallbackController {

    @Inject
    NotificationService notificationService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response callback(CallbackRequest callbackRequest) throws Exception {
        try {
            CallbackResponse response = notificationService.notificationCallback(callbackRequest);
            return Response.ok(response).status(200).build();
        } catch (Exception e) {
            throw new Exception("Erro ao receber o callback de atualização do provider", e);
        }
    }
}
