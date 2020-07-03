package com.github.davitavorah.client;

import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OAuthClient {

    @GetMapping(path = "usuarios/{id}")
    UserRepresentation findUserById(@PathVariable("id") String id);

}
