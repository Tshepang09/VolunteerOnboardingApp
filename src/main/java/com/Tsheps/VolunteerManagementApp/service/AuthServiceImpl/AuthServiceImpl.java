package com.Tsheps.VolunteerManagementApp.service.AuthServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.auth.*;
import com.Tsheps.VolunteerManagementApp.exception.InvalidLoginCredentialsException;
import com.Tsheps.VolunteerManagementApp.exception.UnauthorizedCredentialsException;
import com.Tsheps.VolunteerManagementApp.mappers.UserMapper;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.repository.UserCredentialsRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import com.Tsheps.VolunteerManagementApp.repository.UsersRepo;
import com.Tsheps.VolunteerManagementApp.repository.VolunteerRepo;
import com.Tsheps.VolunteerManagementApp.security.JwtService;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final UsersRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;
    private final PasswordEncoder passwordEncoder;
    private final VolunteerRepo volunteerRepo;
    private final JwtService jwtService;

    @Override
    public UserResponse registerAdmin(RegisterRequest registerRequest) {
        //Test if the email and cellnumber exists in the volunteer data

            boolean existsAsVolunteer = volunteerRepo.existsByCellNumberOrEmail(registerRequest.getCellNumber(), registerRequest.getEmail());
           if(existsAsVolunteer){
            log.info("Checking if credentials exist in the volunteer database");
            throw new UnauthorizedCredentialsException();
}


        //Build User Entity
        Users user = UserMapper.toUser(registerRequest);

        userRepo.save(user);
        //Build UserCredentials Entity
        UserCredentials userCred = UserCredentials.builder()
                .user(user)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userCredentialsRepo.save(userCred);

        return UserMapper.toUserResponse(user);
    }

    @Override
    public LoginResponse loginAdmin(LoginRequest loginRequest) {
        //Testing for email match
        Users user = userRepo.findByEmail(loginRequest.getEmail());
//        Users user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new InvalidLoginCredentialsException());

        //Testing for password match
        boolean passwordDoesNotExists = userCredentialsRepo.existsByPassword(loginRequest.getPassword());
        if(passwordDoesNotExists)
            throw new InvalidLoginCredentialsException();

        return LoginResponse.builder()
                .userId(user.getUserId())
                .token(jwtService.generateToken(user))
                .email(user.getEmail())
                .role(user.getRole())
                .build();

    }
}
