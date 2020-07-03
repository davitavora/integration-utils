package com.github.davitavorah.integration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "integration.utils")
public class IntegrationProperties {

    private String oauthUrl = "";

}
