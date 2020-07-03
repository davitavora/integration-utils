package com.github.davitavorah.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@RequiredArgsConstructor
@Import({FeignClientsConfiguration.class})
@EnableConfigurationProperties(IntegrationProperties.class)
public class IntegrationUtilsAutoConfiguration {

}
