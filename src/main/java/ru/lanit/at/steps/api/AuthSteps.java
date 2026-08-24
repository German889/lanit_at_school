package ru.lanit.at.steps.api;

import io.cucumber.java.ru.Когда;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import ru.lanit.at.utils.ContextHolder;

public class AuthSteps {

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({
            "classpath:config/configuration.properties",
            "system:properties",
            "system:env"
    })
    public interface AuthConfig extends Config {
        @Key("username")
        String username();

        @Key("password")
        String password();
    }

    @Когда("подготовить учетные данные для авторизации")
    public void prepareCredentials() {
        AuthConfig cfg = ConfigFactory.create(AuthConfig.class, System.getProperties(), System.getenv());
        ContextHolder.put("username", cfg.username());
        ContextHolder.put("password", cfg.password());
    }
}