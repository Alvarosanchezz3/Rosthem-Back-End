package com.rosthem.back_end.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisteredUser implements Serializable {

    private Long id;

    private String username;

    private String name;

    private String role;

    private String jwt;
}