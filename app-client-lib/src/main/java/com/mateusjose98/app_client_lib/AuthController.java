package com.mateusjose98.app_client_lib;


import com.mateusjose98.shared_lib.security.AuthenticationService;
import com.mateusjose98.shared_lib.security.JwtService;
import com.mateusjose98.shared_lib.security.LoginUserDto;
import com.mateusjose98.shared_lib.security.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtService;

    @PostMapping
    public Map<String, Object> getToken(@RequestBody LoginUserDto loginDto){
        Usuario authenticatedUser = authenticationService.authenticate(loginDto);
        String token = jwtService.generateToken(authenticatedUser);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", authenticatedUser);
        return response;
    }
}
