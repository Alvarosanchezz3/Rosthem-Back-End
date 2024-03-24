package com.rosthem.back_end.dto.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationResponse implements Serializable {

    private String jwt;
}
