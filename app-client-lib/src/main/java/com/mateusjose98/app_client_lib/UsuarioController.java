package com.mateusjose98.app_client_lib;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @GetMapping("me")
    public Principal getUsuario(Principal user){
        return user;
    }

}
