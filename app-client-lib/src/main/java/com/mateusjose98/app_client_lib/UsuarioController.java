package com.mateusjose98.app_client_lib;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("me")
    public Principal getUsuario(Principal user) {
        return user;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getUsuarios() {
        return ResponseEntity.ok(em.createQuery("select u from UsuarioEntity u", UsuarioEntity.class).getResultList());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Long> criar(@RequestBody UsuarioEntity usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        em.persist(usuario);
        return ResponseEntity.ok(usuario.getId());
    }

}
