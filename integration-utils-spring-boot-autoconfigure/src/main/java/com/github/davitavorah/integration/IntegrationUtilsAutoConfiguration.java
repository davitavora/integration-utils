package com.github.davitavorah.integration;

import com.github.davitavorah.integration.configuration.DefaultFeignConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@RequiredArgsConstructor
@Import({FeignClientsConfiguration.class})
@EnableConfigurationProperties(IntegrationProperties.class)
@EnableFeignClients(defaultConfiguration = DefaultFeignConfiguration.class, basePackages = "com.github.davitavorah.client")
public class IntegrationUtilsAutoConfiguration {}
