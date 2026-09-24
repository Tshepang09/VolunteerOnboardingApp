package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
