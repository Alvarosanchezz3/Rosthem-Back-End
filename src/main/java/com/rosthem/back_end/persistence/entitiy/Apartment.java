package com.rosthem.back_end.persistence.entitiy;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "creation_date")
    private Date creationDate;

    private String province;

    private String street;

    @Column(name = "street_number")
    private int streetNumber;

    @Column(name = "floor_door")
    private String floorDoor;

    @Column(name = "postal_code")
    private String postalCode;

    private int numBedrooms;

    private int numBeds;

    private boolean kitchen;

    private boolean wifi;

    private boolean pool;

    @Column(name = "smoked_allowed")
    private boolean smokedAllowed;

    @Column(name = "night_Price")
    private int nightPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }
}