package com.axelate.pilotdata.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.axelate.pilotdata.configuration.properties.CorsProperties;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class CorsConfiguration  implements WebMvcConfigurer {
	
    private final CorsProperties properties;

    @Bean
    public CorsFilter corsFilter() {
        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", getCors());
        return new CorsFilter(source);
    }

    private org.springframework.web.cors.CorsConfiguration getCors() {
        final var cors = new org.springframework.web.cors.CorsConfiguration();
        cors.setMaxAge(properties.getMaxAge());
        cors.setAllowCredentials(properties.getAllowCredentials());
        cors.setExposedHeaders(properties.getExposedHeaders());
        cors.setAllowedOrigins(properties.getAllowedOrigins());
        cors.setAllowedMethods(properties.getAllowedMethods());
        cors.setAllowedHeaders(properties.getAllowedHeaders());
        return cors;
    }

}
