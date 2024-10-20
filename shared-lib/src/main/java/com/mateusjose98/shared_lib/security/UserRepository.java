package com.mateusjose98.shared_lib.security;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository {

    public Optional<Usuario> findByEmail(String email) {
        return Optional.of(new Usuario("mateus", "$2a$12$7u16wpAuK/Sgv5jESeuceuYJ2hB1ZxuUteRM/ZSG1vJXGzgCNm5jm", "ROLE_ADMIN"));
    }
}
