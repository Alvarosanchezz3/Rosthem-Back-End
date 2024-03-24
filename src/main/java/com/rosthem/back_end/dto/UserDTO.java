package com.rosthem.back_end.dto;

import com.rosthem.back_end.persistence.util.Role;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String username;

    private int telephoneNumber;

    private String email;

    private Role role;
}