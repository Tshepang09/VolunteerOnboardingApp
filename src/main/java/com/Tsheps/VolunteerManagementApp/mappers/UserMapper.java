package com.Tsheps.VolunteerManagementApp.mappers;

import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.UserResponse;
import com.Tsheps.VolunteerManagementApp.model.Users;

public class UserMapper {
    public static UserResponse toUserResponse(Users user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .cellNumber(user.getCellNumber())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
    public static Users toUser(RegisterRequest registerRequest){
        return Users.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .role(registerRequest.getRole())
                .cellNumber(registerRequest.getCellNumber())
                .build();
    }
}
