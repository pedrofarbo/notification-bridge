package br.com.pedrofarbo.controllers;

import br.com.pedrofarbo.controllers.request.SendNotificationRequest;
import br.com.pedrofarbo.controllers.response.SendNotificationResponse;
import br.com.pedrofarbo.services.NotificationService;
import br.com.pedrofarbo.validators.SendNotificationValidator;
import br.com.pedrofarbo.validators.ValidatorResponse;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/notification-bridge")
public class NotificationBridgeController {
    @Inject
    NotificationService notificationService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response sendNotification(SendNotificationRequest sendNotificationRequest) throws Exception {
        ValidatorResponse validatorResponse = SendNotificationValidator.validate(sendNotificationRequest);

        if(validatorResponse.getCode().equalsIgnoreCase("200")) {
            SendNotificationResponse sendNotificationResponse;

            try {
                sendNotificationResponse = notificationService.sendNotification(sendNotificationRequest);
                return Response.ok(sendNotificationResponse).status(201).build();
            } catch (Exception e) {
                throw new Exception("Erro ao enviar a notificação", e);
            }

        } else {
            return Response.status(400).entity(validatorResponse).build();
        }
    }
}
