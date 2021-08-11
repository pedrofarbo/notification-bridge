package br.com.pedrofarbo.validators;

import br.com.pedrofarbo.controllers.request.SendNotificationRequest;

public class SendNotificationValidator {
    public static ValidatorResponse validate(SendNotificationRequest sendNotificationRequest) {
        ValidatorResponse validatorResponse = new ValidatorResponse();

        if(sendNotificationRequest == null) {
            validatorResponse.setCode("400");
            validatorResponse.setMessage("O objeto da requisição não pode ser nulo.");
        } else {
            if(sendNotificationRequest.getFrom() == null) {
                validatorResponse.setCode("400");
                validatorResponse.setMessage("O campo from do objeto json não pode ser nulo.");
            } else if(sendNotificationRequest.getTo() == null) {
                validatorResponse.setCode("400");
                validatorResponse.setMessage("O campo to do objeto json não pode ser nulo.");
            } else if(sendNotificationRequest.getMessage() == null) {
                validatorResponse.setCode("400");
                validatorResponse.setMessage("O campo message do objeto json não pode ser nulo.");
            } else if(sendNotificationRequest.getType() == null) {
                validatorResponse.setCode("400");
                validatorResponse.setMessage("O campo type do objeto json não pode ser nulo.");
            } else if(!sendNotificationRequest.getType().equals("SMS") && !sendNotificationRequest.getType().equals("WHATSAPP")) {
                validatorResponse.setCode("400");
                validatorResponse.setMessage("O campo type do objeto json possui um tipo não permitido de notificação. Somente SMS e WHATSAPP são tipos permitidos");
            } else {
                validatorResponse.setCode("200");
                validatorResponse.setMessage("Objeto validado.");
            }
        }

        return validatorResponse;
    }
}
