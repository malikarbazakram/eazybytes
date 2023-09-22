package com.eazybytes.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableMethodSecurity
@Configuration
public class WebConfiguration {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(
                new AntPathRequestMatcher("/notices/**", "GET"),
                new AntPathRequestMatcher("/notices/**", "POST"),
                new AntPathRequestMatcher("/contact/**", "GET"),
                new AntPathRequestMatcher("/contact/**", "POST"),
                new AntPathRequestMatcher("/actuator", "GET"),
                new AntPathRequestMatcher("/actuator/**", "GET")
        );
    }
}