package com.Tsheps.VolunteerManagementApp.service;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;

import java.util.List;

//<------This service is accessed by admin-portal------>

public interface AttendanceService {
    List<AttendanceRecord> viewVolunteerAttendance();
}
