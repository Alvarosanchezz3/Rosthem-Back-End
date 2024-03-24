package com.rosthem.back_end.controller;

import com.rosthem.back_end.dto.SaveApartment;
import com.rosthem.back_end.persistence.entitiy.Apartment;
import com.rosthem.back_end.service.ApartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @PreAuthorize("hasAuthority('READ_ALL_APARTMENTS')")
    @GetMapping
    public ResponseEntity<Page<Apartment>> findAll(Pageable pageable) {

        Page<Apartment> ApartmentsPage = apartmentService.findAll(pageable);

        if (ApartmentsPage.hasContent()) {
            return ResponseEntity.ok(ApartmentsPage);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('READ_ONE_APARTMENT')")
    @GetMapping("/{apartmentId}")
    public ResponseEntity<?> findOneById(@PathVariable("apartmentId") Long apartmentId) {
        Optional<Apartment> apartment = apartmentService.findOneById(apartmentId);

        if (apartment.isPresent()) {
            return ResponseEntity.ok(apartment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El apartamento con Id " + apartmentId + " no fue encontrado.");
        }
    }

    @PreAuthorize("hasAuthority('CREATE_ONE_APARTMENT')")
    @PostMapping
    public ResponseEntity<Apartment> createOne(@RequestBody @Valid SaveApartment saveApartment) {
        Apartment apartment = apartmentService.create(saveApartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartment);
    }

    @PreAuthorize("hasAuthority('UPDATE_ONE_APARTMENT')")
    @PutMapping("/{apartmentId}")
    public ResponseEntity<Apartment> updateOneById(@PathVariable Long apartmentId,
                                                  @RequestBody @Valid SaveApartment saveApartment) {

        Apartment apartment = apartmentService.updateOneById(apartmentId, saveApartment);
        return ResponseEntity.ok(apartment);
    }

    @PreAuthorize("hasAuthority('DELETE_ONE_APARTMENT')")
    @DeleteMapping
    public ResponseEntity deleteOneById (@PathVariable Long apartmentId) {

        Optional<Apartment> apartment = apartmentService.findOneById(apartmentId);

        if (apartment.isPresent()) {
            apartmentService.deleteOneById(apartmentId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("El apartamento con Id " + apartmentId + " fue borrado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El apartamento con Id " + apartmentId + " no fue encontrado.");
        }
    }
}