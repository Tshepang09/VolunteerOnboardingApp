package com.Tsheps.VolunteerManagementApp.dto;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_1030;
import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.Tsheps.VolunteerManagementApp.enums.Gender;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@JsonPropertyOrder({"attendanceId", "volunteerId", "firstName", "lastName", "gender",
        "email", "cellNumber","serviceDate", "classAllocation_830", "classAllocation_1030","signedInAt"})
public class AttendanceRecordResponse {
    private Long attendanceId;
    private Long volunteerId;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String email;
    private String cellNumber;
    private LocalDate serviceDate;
    private ClassAllocation_830 classAllocation_830;
    private ClassAllocation_1030 classAllocation_1030;
    private LocalDateTime signedInAt;
}
