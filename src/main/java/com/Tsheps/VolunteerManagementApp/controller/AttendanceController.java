package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.service.AttendanceService;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.AttendanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/kc-volunteers/admin-portal/")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @GetMapping("/attendance")
    public ResponseEntity<List<AttendanceRecord>> getVolunteerAttendance() {
        return ResponseEntity.ok().body(attendanceService.viewVolunteerAttendance());
    }
}
