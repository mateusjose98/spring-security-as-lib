package com.mateusjose98.shared_lib.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {

    private String email;
    private String pass;
    private String role;

    public Usuario(String email, String pass, String role) {
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public Usuario() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getUsername() {
        return email;
    }


}
