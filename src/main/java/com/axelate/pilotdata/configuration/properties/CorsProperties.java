package com.axelate.pilotdata.configuration.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cors", ignoreUnknownFields = false)
public class CorsProperties {
	 private List<String> allowedOrigins;
	    private List<String> allowedMethods;
	    private List<String> allowedHeaders;
	    private List<String> exposedHeaders;
	    private Boolean allowCredentials;
	    private Long maxAge;
}
