package com.github.davitavorah.integration.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.keycloak.admin.client.token.TokenManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Decoder jacksonDecoder(ObjectMapper objectMapper) {
        return new JacksonDecoder();
    }

    @Bean
    public Encoder jacksonEncoder(ObjectMapper objectMapper) {
        return new JacksonEncoder();
    }

    @Bean
    public RequestInterceptor requestInterceptor(TokenManager tokenManager) {
        return request -> request.header(AUTHORIZATION, format("Bearer %s", tokenManager.getAccessTokenString()));
    }

}
