package com.rosthem.back_end.controller;

import com.rosthem.back_end.dto.auth.AuthenticationRequest;
import com.rosthem.back_end.dto.auth.AuthenticationResponse;
import com.rosthem.back_end.dto.auth.UserProfile;
import com.rosthem.back_end.persistence.entitiy.User;
import com.rosthem.back_end.service.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @GetMapping("validate-token")
    public ResponseEntity<Boolean> validate (@RequestParam String jwt) {
        boolean isTokenValid = authService.validateToken(jwt);
        return ResponseEntity.ok(isTokenValid);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody @Valid AuthenticationRequest authRequest) {

        AuthenticationResponse authResponse = authService.login(authRequest);

        return ResponseEntity.ok(authResponse);
    }

    @PreAuthorize("hasAuthority('READ_MY_PROFILE')")
    @GetMapping("/profile")
    public ResponseEntity<UserProfile> findMyProfile () {
        User user = authService.findLoggedInUser();

        UserProfile userProfile = new UserProfile();
        userProfile.setId(user.getId());
        userProfile.setName(user.getName());
        userProfile.setUsername(user.getUsername());
        userProfile.setPassword(user.getPassword());
        userProfile.setRole(user.getRole().toString());
        userProfile.setEnabled(user.isEnabled());
        userProfile.setAuthorities(user.getAuthorities());

        return ResponseEntity.ok(userProfile);
    }
}