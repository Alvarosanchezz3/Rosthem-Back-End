package com.rosthem.back_end.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
public class SaveUser implements Serializable {

    @NotBlank
    @Size(min = 4)
    private String name;

    @NotBlank
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;

    @Size(min = 8)
    private String repeatedPassword;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Range(min = 100000000, max = 999999999, message = "El número de teléfono debe tener 9 dígitos")
    private int telephoneNumber;
}
