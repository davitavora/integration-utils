package com.github.davitavorah.integration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.token.TokenManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
@ConditionalOnBean(TokenManager.class)
public class FeignClientInterceptor implements RequestInterceptor {

    private final TokenManager tokenManager;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", format("Bearer %s", tokenManager.getAccessTokenString()));
    }
}