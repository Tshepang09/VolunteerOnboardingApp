package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.dto.auth.LoginRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.LoginResponse;
import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.UserResponse;
import com.Tsheps.VolunteerManagementApp.exception.UnauthorizedCredentialsException;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("api/kc-onboarding")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        log.info("Attempting to register {} {}.", registerRequest.getFirstname(),  registerRequest.getLastname());
        return ResponseEntity.status(HttpStatus.OK).body(authService.registerAdmin(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest){
        if(loginRequest==null)
            throw new UnauthorizedCredentialsException("Please  enter login details.");
        log.info("Attempting to login.");
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginAdmin(loginRequest));
    }
}
