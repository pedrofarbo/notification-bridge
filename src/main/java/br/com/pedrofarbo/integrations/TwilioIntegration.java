package br.com.pedrofarbo.integrations;

import br.com.pedrofarbo.models.Notification;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;

@ApplicationScoped
public class TwilioIntegration {

    @Inject
    TwillioConfig twillioConfig;

    @Inject
    CallbackConfig callbackConfig;

    public TwilioIntegration() {
    }

    public Message sendWhatsApp(Notification sendNotificationRequest) {
        Twilio.init(twillioConfig.TWILIO_ACCOUNT_SID(), twillioConfig.TWILIO_AUTH_TOKEN());

        return Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+sendNotificationRequest.getTo()),
                new com.twilio.type.PhoneNumber("whatsapp:"+sendNotificationRequest.getFrom()),
                sendNotificationRequest.getMessage())
                .setStatusCallback(URI.create(callbackConfig.url()))
                .create();
    }

    public Message sendSms(Notification sendNotificationRequest) {
        Twilio.init(twillioConfig.TWILIO_ACCOUNT_SID(), twillioConfig.TWILIO_AUTH_TOKEN());

        return Message.creator(
                new com.twilio.type.PhoneNumber(sendNotificationRequest.getTo()),
                new com.twilio.type.PhoneNumber(sendNotificationRequest.getFrom()),
                sendNotificationRequest.getMessage())
                .setStatusCallback(URI.create(callbackConfig.url()))
                .create();
    }
}
