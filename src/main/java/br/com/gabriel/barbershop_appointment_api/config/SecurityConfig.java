package br.com.gabriel.barbershop_appointment_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("default")
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionFixation(sessionFixation -> sessionFixation
                    .changeSessionId()))
            .authorizeHttpRequests(request -> request
                .requestMatchers("/error", "/customer/create").permitAll()
                .anyRequest().authenticated())
            .httpBasic(withDefaults())
            .formLogin(withDefaults())
            .redirectToHttps(rtcc -> rtcc.disable())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
