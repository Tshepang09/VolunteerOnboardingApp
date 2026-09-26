package com.Tsheps.VolunteerManagementApp.service.AuthServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.auth.*;
import com.Tsheps.VolunteerManagementApp.exception.InvalidLoginCredentialsException;
import com.Tsheps.VolunteerManagementApp.mappers.UserMapper;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import com.Tsheps.VolunteerManagementApp.security.JwtService;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public RegisterResponse registerAdmin(RegisterRequest registerRequest) {
        //Build User Entity
        Users user = UserMapper.toUser(registerRequest);

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
        Users user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new InvalidLoginCredentialsException());

        return LoginResponse.builder()
                .userId(user.getUserId())
                .token(jwtService.generateToken(user))
                .email(user.getEmail())
                .role(user.getRole())
                .build();

    }
}
