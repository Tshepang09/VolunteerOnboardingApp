package com.Tsheps.VolunteerManagementApp.dto;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_1030;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerResponse {
    private Long volunteerId;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String email;

    private String cellNumber;

    private ClassAllocation_830 classAllocation1;

    private ClassAllocation_1030 classAllocation2;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
