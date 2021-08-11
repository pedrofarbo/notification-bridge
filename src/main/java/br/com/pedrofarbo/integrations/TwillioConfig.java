package br.com.pedrofarbo.integrations;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "twillio")
public interface TwillioConfig {

    @WithName("TWILIO_AUTH_TOKEN")
    String TWILIO_AUTH_TOKEN();

    @WithName("TWILIO_ACCOUNT_SID")
    String TWILIO_ACCOUNT_SID();
}