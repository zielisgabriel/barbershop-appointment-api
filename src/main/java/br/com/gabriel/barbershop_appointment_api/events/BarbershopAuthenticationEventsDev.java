package br.com.gabriel.barbershop_appointment_api.events;

import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("dev")
public class BarbershopAuthenticationEventsDev {
    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent success) {
        log.info("User {} logged in successfully", success.getAuthentication().getName());
    }

    @EventListener
    public void onAuthenticationFailure(AbstractAuthenticationFailureEvent failure) {
        log.info("User {} failed to log in, due to: {}",
            failure.getAuthentication().getName(),
            failure.getException().getMessage()
        );
    }
}
