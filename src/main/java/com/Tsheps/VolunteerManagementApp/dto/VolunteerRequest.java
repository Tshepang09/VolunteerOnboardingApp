package com.Tsheps.VolunteerManagementApp.dto;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_1030;
import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.Tsheps.VolunteerManagementApp.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class VolunteerRequest {
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String cellNumber;
    private ClassAllocation_830 classAllocation1;
    private ClassAllocation_1030 classAllocation2;
}
