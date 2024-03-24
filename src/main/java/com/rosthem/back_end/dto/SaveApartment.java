package com.rosthem.back_end.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class SaveApartment implements Serializable {

    @NotBlank
    private String name;

    @Size(min = 50)
    @NotBlank
    private String description;

    @NotBlank
    private String province;

    @NotBlank
    private String street;

    @NotNull
    @Min(value = 0, message = "El número de calle debe ser mínimo 0")
    private Integer streetNumber;

    private String floorDoor;

    @NotBlank
    private String postalCode;

    @NotNull
    @Min(value = 1, message = "Como mínimo debe tener una habitación.")
    private int numBedrooms;

    @NotNull
    @Min(value = 1, message = "Como mínimo debe tener una cama.")
    private int numBeds;

    @NotNull
    private boolean kitchen;

    @NotNull
    private boolean wifi;

    @NotNull
    private boolean pool;

    @NotNull
    private boolean smokedAllowed;

    @NotNull
    @Min(1)
    private int nightPrice;

    @NotNull
    @Min(value = 1, message = "El campo userId debe ser mayor de 0")
    private Long userId;
}
