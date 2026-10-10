package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String cellNumber;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
