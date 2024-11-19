package com.deema.ems.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;
}
