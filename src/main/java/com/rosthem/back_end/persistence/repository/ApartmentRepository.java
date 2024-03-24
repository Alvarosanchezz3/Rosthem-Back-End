package com.rosthem.back_end.persistence.repository;

import com.rosthem.back_end.persistence.entitiy.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
