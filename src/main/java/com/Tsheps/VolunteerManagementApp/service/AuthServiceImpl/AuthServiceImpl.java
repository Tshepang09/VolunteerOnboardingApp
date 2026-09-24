package com.Tsheps.VolunteerManagementApp.service.AuthServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.auth.*;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UserRepo;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;

    @Override
    public RegisterResponse registerAdmin(UserRequest userRequest) {
        //Build User Entity
        userRepo.save(userRequest);
        //Build UserCredentials Entity

        return UserResponse.builder().;
    }

    @Override
    public UserResponse register(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public LoginResponse loginAdmin(LoginRequest loginRequest) {
        return null;
    }
}
