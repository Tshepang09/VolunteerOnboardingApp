package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.Tsheps.VolunteerManagementApp.enums.Gender;
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
    private Long volunteerId;
    private String firstName;
    private String LastName;
    private Gender gender;
    private String email;
    private String cellNumber;
    private ClassAllocation_830 classAllocation1;
    private ClassAllocation_830 classAllocation2;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
