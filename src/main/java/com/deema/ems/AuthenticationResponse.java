package com.deema.ems;

import com.deema.ems.user.Role;

import java.util.Set;

public class AuthenticationResponse {
    private String token;
    private Set<Role> roles;

    public AuthenticationResponse(String token, Set<Role> roles) {
        this.token = token;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
