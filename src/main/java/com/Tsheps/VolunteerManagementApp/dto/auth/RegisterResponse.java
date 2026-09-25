package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.Tsheps.VolunteerManagementApp.enums.Gender;
import com.Tsheps.VolunteerManagementApp.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class RegisterResponse {
    private Long userId;
    private String firstname;
    private String lastname;
    private String email;
    private String cellNumber;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
