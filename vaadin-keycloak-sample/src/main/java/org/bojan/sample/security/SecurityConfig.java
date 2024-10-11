package org.bojan.sample.security;

import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity {

    @Autowired
    private CustomOidcUserService customOidcUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz ->{
                    authz
                            .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
                            .anyRequest()
                            .fullyAuthenticated();
                })
                .oauth2Login(oauth2 ->
                    oauth2.loginPage("/oauth2/authorization/keycloak")
                            .defaultSuccessUrl("/", true)
                            .userInfoEndpoint(userInfoEndpointConfig ->
                                    userInfoEndpointConfig.oidcUserService(customOidcUserService)
                            )
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(Customizer.withDefaults()))
                .oidcLogout(oauth2 -> oauth2.backChannel(Customizer.withDefaults()));

    }
}
