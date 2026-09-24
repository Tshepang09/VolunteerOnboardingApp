package com.Tsheps.VolunteerManagementApp.service;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;

public interface VolunteerService {
    public void createVolunteerProfile(VolunteerRequest VolunteerRequest);
    public VolunteerResponse updateVolunteerProfile(VolunteerRequest VolunteerRequest);
    public String indicateAttendance(AttendanceRecordRequest attendanceRecordRequest);
}
