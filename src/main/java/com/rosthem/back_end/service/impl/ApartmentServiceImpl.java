package com.rosthem.back_end.service.impl;

import com.rosthem.back_end.dto.SaveApartment;
import com.rosthem.back_end.exception.ObjectNotFoundException;
import com.rosthem.back_end.persistence.entitiy.Apartment;
import com.rosthem.back_end.persistence.entitiy.User;
import com.rosthem.back_end.persistence.repository.ApartmentRepository;
import com.rosthem.back_end.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;


    @Override
    public Page<Apartment> findAll(Pageable pageable) {
        return apartmentRepository.findAll(pageable);
    }

    @Override
    public Optional<Apartment> findOneById(Long apartmentId) {
        return apartmentRepository.findById(apartmentId);
    }

    @Override
    public Apartment create(SaveApartment saveApartment) {
        Apartment apartment = new Apartment();
            apartment.setName(saveApartment.getName());
            apartment.setDescription(saveApartment.getDescription());
            apartment.setProvince(saveApartment.getProvince());
            apartment.setStreet(saveApartment.getStreet());
            apartment.setStreetNumber(saveApartment.getStreetNumber());
            apartment.setFloorDoor(saveApartment.getFloorDoor());
            apartment.setPostalCode(saveApartment.getPostalCode());
            apartment.setNumBedrooms(saveApartment.getNumBedrooms());
            apartment.setNumBeds(saveApartment.getNumBeds());
            apartment.setKitchen(saveApartment.isKitchen());
            apartment.setWifi(saveApartment.isWifi());
            apartment.setPool(saveApartment.isPool());
            apartment.setSmokedAllowed(saveApartment.isSmokedAllowed());
            apartment.setNightPrice(saveApartment.getNightPrice());

        User user = new User();
            user.setId(saveApartment.getUserId());
            apartment.setUser(user);

        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment updateOneById(Long apartmentId, SaveApartment saveApartment) {
        Apartment apartmentFromDb = apartmentRepository.findById(apartmentId).orElseThrow(
                () -> new ObjectNotFoundException("Category not found with id " + apartmentId));

        apartmentFromDb.setName(saveApartment.getName());
        apartmentFromDb.setDescription(saveApartment.getDescription());
        apartmentFromDb.setProvince(saveApartment.getProvince());
        apartmentFromDb.setStreet(saveApartment.getStreet());
        apartmentFromDb.setStreetNumber(saveApartment.getStreetNumber());
        apartmentFromDb.setFloorDoor(saveApartment.getFloorDoor());
        apartmentFromDb.setPostalCode(saveApartment.getPostalCode());
        apartmentFromDb.setNumBedrooms(saveApartment.getNumBedrooms());
        apartmentFromDb.setNumBeds(saveApartment.getNumBeds());
        apartmentFromDb.setKitchen(saveApartment.isKitchen());
        apartmentFromDb.setWifi(saveApartment.isWifi());
        apartmentFromDb.setPool(saveApartment.isPool());
        apartmentFromDb.setSmokedAllowed(saveApartment.isSmokedAllowed());
        apartmentFromDb.setNightPrice(saveApartment.getNightPrice());

        return apartmentRepository.save(apartmentFromDb);
    }

    @Override
    public void deleteOneById(Long apartmentId) {
        apartmentRepository.deleteById(apartmentId);
    }
}
