package br.com.pedrofarbo.integrations;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "callback")
public interface CallbackConfig {
    @WithName("url")
    String url();
}
