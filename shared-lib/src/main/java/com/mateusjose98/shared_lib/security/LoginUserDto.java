package com.mateusjose98.shared_lib.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserDto {
    @JsonProperty("username")
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
