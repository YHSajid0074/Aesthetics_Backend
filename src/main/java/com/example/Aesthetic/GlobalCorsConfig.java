package com.example.Aesthetic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("http://localhost:4200"); // Allow your frontend origin
        corsConfiguration.addAllowedMethod("GET"); // Allow specific methods
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedHeader("*"); // Allow all headers
        corsConfiguration.setMaxAge(3600L); // Cache preflight response for 1 hour

        source.registerCorsConfiguration("/**", corsConfiguration); // Apply to all endpoints
        return new CorsFilter(source);
    }
}

