package com.rosthem.back_end.controller;

import com.rosthem.back_end.dto.RegisteredUser;
import com.rosthem.back_end.dto.SaveUser;
import com.rosthem.back_end.dto.UserDTO;
import com.rosthem.back_end.persistence.entitiy.Apartment;
import com.rosthem.back_end.persistence.entitiy.User;
import com.rosthem.back_end.service.UserService;
import com.rosthem.back_end.service.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne (@RequestBody @Valid SaveUser newUser) {
        RegisteredUser registeredUser = authService.registerOneCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PreAuthorize("hasAuthority('READ_ALL_USERS')")
    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<User> usersPage = userService.findAll(pageable);

        if (usersPage.hasContent()) {
            Page<UserDTO> userDTOs = usersPage.map(user -> {
                UserDTO dto = new UserDTO();
                dto.setId(user.getId());
                dto.setName(user.getName());
                dto.setUsername(user.getUsername());
                dto.setEmail(user.getEmail());
                dto.setTelephoneNumber(user.getTelephoneNumber());
                dto.setRole(user.getRole());
                return dto;
            });
            return ResponseEntity.ok(userDTOs);
        }
        return ResponseEntity.notFound().build();
    }
}