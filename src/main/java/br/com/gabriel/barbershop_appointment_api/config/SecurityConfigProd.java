package br.com.gabriel.barbershop_appointment_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.gabriel.barbershop_appointment_api.exceptions.BarbershopAuthenticationEntryPointHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile(value = "prod")
public class SecurityConfigProd {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(smc -> smc
                .sessionFixation(sfc -> sfc
                    .changeSessionId()))
            .authorizeHttpRequests(request -> request
                .requestMatchers("/error", "/customer/create").permitAll()
                .requestMatchers("/customer/list", "/customer/delete", "/customer/update", "/available_time/list", "/customer_haircut/create", "/customer_haircut/list", "/customer_haircut/delete", "/haircut/list").authenticated()
                .requestMatchers("/available_time", "/available_time/create", "/available_time/delete", "/haircut/create", "/haircut/delete", "/haircut/update").hasRole("ADMIN"))
            .httpBasic(hbc -> hbc.authenticationEntryPoint(new BarbershopAuthenticationEntryPointHandler()))
            .formLogin(withDefaults())
            .redirectToHttps(withDefaults())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
