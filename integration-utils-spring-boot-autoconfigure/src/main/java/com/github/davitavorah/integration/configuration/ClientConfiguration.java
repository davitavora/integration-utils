package com.github.davitavorah.integration.configuration;

import com.github.davitavorah.client.OAuthClient;
import com.github.davitavorah.integration.IntegrationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {

    private final IntegrationProperties integrationProperties;
    private final ApplicationContext applicationContext;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public OAuthClient buildOAuthClient() {
        return new FeignClientBuilder(applicationContext)
                .forType(OAuthClient.class, "oAuthClient")
                .url(integrationProperties.getOauthUrl()).build();
    }

}
