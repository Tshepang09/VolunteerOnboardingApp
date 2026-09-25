package com.Tsheps.VolunteerManagementApp.service;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordResponse;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;

//<------This service is accessed by volunteer-portal------>
public interface VolunteerService {
    public VolunteerResponse createVolunteerProfile(VolunteerRequest VolunteerRequest);
    public VolunteerResponse updateVolunteerProfile(VolunteerRequest VolunteerRequest);
    public AttendanceRecordResponse volunteerSignin(AttendanceRecordRequest attendanceRecordRequest);
}
