package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordResponse;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.repository.AttendanceRepo;
import com.Tsheps.VolunteerManagementApp.service.AttendanceService;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.AttendanceServiceImpl;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.VolunteerServiceImpl;
import com.Tsheps.VolunteerManagementApp.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/kc-volunteers/volunteer-portal")
public class VolunteerController {

    private final VolunteerService volunteerService;
    private final AttendanceRepo attendanceRepo;
    private final AttendanceService attendanceService;

    @PostMapping("/signin")
    public ResponseEntity<AttendanceRecordResponse> volunteerSignIn(@RequestBody AttendanceRecordRequest attendanceRecordRequest) {
        volunteerService.volunteerSignin(attendanceRecordRequest);
        return ResponseEntity.status(HttpStatus.OK).body(volunteerService.volunteerSignin(attendanceRecordRequest));
    }

    @PostMapping("/create-profile")
    public ResponseEntity<VolunteerResponse> createProfile(@RequestBody VolunteerRequest volunteerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(volunteerService.createVolunteerProfile(volunteerRequest));
    }


    @PutMapping("/update-profile")
    public ResponseEntity<VolunteerResponse> updateProfile(@RequestBody VolunteerRequest volunteerRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(volunteerService.updateVolunteerProfile(volunteerRequest));
    }

}
