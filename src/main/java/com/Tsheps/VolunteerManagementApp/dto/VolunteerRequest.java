package com.Tsheps.VolunteerManagementApp.dto;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class VolunteerRequest {

    private String firstName;

    private String LastName;

    private String email;

    private String cellNumber;

    private boolean volunteerInTraining;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 session1Class;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 session2Class;
}
