package com.Tsheps.VolunteerManagementApp.service;

import com.Tsheps.VolunteerManagementApp.dto.auth.*;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public RegisterResponse registerAdmin(RegisterRequest registerRequest);
    public LoginResponse loginAdmin(LoginRequest loginRequest);
}
