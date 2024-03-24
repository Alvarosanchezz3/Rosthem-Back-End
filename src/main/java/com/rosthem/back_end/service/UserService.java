package com.rosthem.back_end.service;

import com.rosthem.back_end.dto.SaveUser;
import com.rosthem.back_end.persistence.entitiy.Apartment;
import com.rosthem.back_end.persistence.entitiy.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User registerOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);
}
