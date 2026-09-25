package com.Tsheps.VolunteerManagementApp.service.AuthServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.auth.*;
import com.Tsheps.VolunteerManagementApp.mappers.UserMapper;
import com.Tsheps.VolunteerManagementApp.model.User;
import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UserRepo;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registerAdmin(RegisterRequest registerRequest) {
        //Build User Entity
        User user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .role(registerRequest.getRole())
                .cellNumber(registerRequest.getCellNumber())
                .build();

        userRepo.save(user);
        //Build UserCredentials Entity
        UserCredentials userCred = UserCredentials.builder()
                .User(user)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userCredentialsRepo.save(userCred);

        return UserMapper.toRegisterResponse(user);
    }

    @Override
    public LoginResponse loginAdmin(LoginRequest loginRequest) {
        return null;
    }
}
