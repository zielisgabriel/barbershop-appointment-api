package br.com.gabriel.barbershop_appointment_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import br.com.gabriel.barbershop_appointment_api.exceptions.BarbershopAuthenticationEntryPointHandler;
import jakarta.servlet.http.HttpServletRequest;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@Profile(value = "prod")
public class SecurityConfigProd {
    @Value("${app.cors.allowed-origins}")
    private String allowedCorsOriginUrl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .cors(cc -> cc.configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(@NonNull HttpServletRequest request) {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.addAllowedOriginPattern(allowedCorsOriginUrl);
                    corsConfiguration.addAllowedMethod("*");
                    corsConfiguration.addAllowedHeader("*");
                    return corsConfiguration;
                }
                
            }))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(smc -> smc
                .sessionFixation(sfc -> sfc
                    .changeSessionId())
                .maximumSessions(1))
            .authorizeHttpRequests(request -> request
                .requestMatchers("/error", "/customer/create")
                    .permitAll()
                .requestMatchers("/customer/list", "/customer/delete", "/customer/update", "/available_time/list", "/appointmentTime/create", "/appointmentTime/list", "/appointmentTime/delete", "/haircut/list")
                    .authenticated()
                .requestMatchers("/available_time", "/available_time/create", "/available_time/delete", "/haircut/create", "/haircut/delete", "/haircut/update")
                    .hasRole("ADMIN"))
            .httpBasic(hbc -> hbc
                .authenticationEntryPoint(new BarbershopAuthenticationEntryPointHandler()))
            .formLogin(withDefaults())
            .redirectToHttps(withDefaults())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
