package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.AttendanceServiceImpl;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.VolunteerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/kc-volunteers/volunteer-portal")
public class VolunteerController {

    private final VolunteerServiceImpl volunteerService;
    private final AttendanceRecord attendanceRecord;
    private final AttendanceServiceImpl attendanceService;

    @GetMapping("/signin")
    public ResponseEntity<String> volunteerSignIn(@RequestBody AttendanceRecordRequest attendanceRecordRequest) {
        volunteerService.indicateAttendance(attendanceRecordRequest);
        return new ResponseEntity<>("Successfully Signed Attendance!", HttpStatus.OK);
    }

    @PostMapping("/create-profile")
    public ResponseEntity<String> createProfile(@RequestBody Volunteer volunteer) {
        return new ResponseEntity<>("Profile successfully created!", HttpStatus.CREATED);
    }


    @PutMapping("/update-profile")
    public ResponseEntity<VolunteerResponse> updateProfile(@RequestBody VolunteerRequest volunteerRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(volunteerService.updateVolunteerProfile(volunteerRequest));
    }

}
