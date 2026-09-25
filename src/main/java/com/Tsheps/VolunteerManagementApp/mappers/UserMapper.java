package com.Tsheps.VolunteerManagementApp.mappers;

import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterResponse;
import com.Tsheps.VolunteerManagementApp.model.User;

public class UserMapper {
    public static RegisterResponse toRegisterResponse(User user){
        return RegisterResponse.builder()
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
}
