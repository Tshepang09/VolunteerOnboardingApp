package com.Tsheps.VolunteerManagementApp.dto;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import jakarta.persistence.Column;

public class AttendanceRecordRequest {
    private Long attendanceId;

    private Long volunteerId;

    private String firstName;

    private String LastName;

    private String email;

    private String cellNumber;

}
