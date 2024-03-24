package com.rosthem.back_end.service;

import com.rosthem.back_end.dto.SaveApartment;
import com.rosthem.back_end.persistence.entitiy.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ApartmentService {

    Page<Apartment> findAll(Pageable pageable);

    Optional<Apartment> findOneById(Long apartmentId);

    Apartment create(SaveApartment saveApartment);

    Apartment updateOneById(Long apartmentId, SaveApartment saveApartment);

    void deleteOneById(Long apartmentId);
}