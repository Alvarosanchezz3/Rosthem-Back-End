package com.rosthem.back_end.dto.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class UserProfile implements Serializable {

    private Long id;
    private String name;
    private String username;
    private String password;
    private boolean enabled;
    private String role;
    private Collection<?> authorities;
}
