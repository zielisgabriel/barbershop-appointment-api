package br.com.gabriel.barbershop_appointment_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import br.com.gabriel.barbershop_appointment_api.exceptions.BarbershopAccessDeniedExceptionHandler;
import br.com.gabriel.barbershop_appointment_api.exceptions.BarbershopAuthenticationEntryPointHandler;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
@Profile("dev")
public class SecurityConfigDev {
    CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .securityContext(sc -> sc.requireExplicitSave(false))
            .cors(cc -> cc.configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(@org.springframework.lang.NonNull HttpServletRequest request) {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.addAllowedOriginPattern("http://localhost:3000");
                    corsConfiguration.addAllowedMethod("*");
                    corsConfiguration.addAllowedHeader("*");
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }
            }))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(smc -> smc
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .sessionFixation(sessionFixation -> sessionFixation
                    .changeSessionId())
                .maximumSessions(3)
                .expiredUrl("/login"))
            .authorizeHttpRequests(request -> request
                .requestMatchers("/error", "/customer/create", "/invalidSession", "/customer/login")
                    .permitAll()
                .requestMatchers("/customer/delete", "/customer/update", "/available_time/list", "/appointmentTime/create", "/appointmentTime/list", "/appointmentTime/delete/{appointmentTimeId}", "/haircut/list", "/haircut/create", "/haircut/delete/{haircutId}", "/customer/validate", "/customer/details", "/available_time/create")
                    .authenticated()
                .requestMatchers("/available_time", "/available_time/delete", "/haircut/update", "/customer/list")
                    .hasRole("admin"))
            .httpBasic(hbc -> hbc.authenticationEntryPoint(new BarbershopAuthenticationEntryPointHandler()))
            .exceptionHandling(ehc -> ehc.accessDeniedHandler(new BarbershopAccessDeniedExceptionHandler()))
            .formLogin(flc -> flc.disable())
            .logout(lc -> lc
                .logoutUrl("/customer/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "XSRF-TOKEN")
                .clearAuthentication(true)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
            .redirectToHttps(rtcc -> rtcc.disable())
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
