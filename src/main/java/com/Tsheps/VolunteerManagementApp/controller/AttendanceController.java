package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.AttendanceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/kc-volunteers/admin-portal/")
public class AttendanceController {
    private AttendanceServiceImpl attendanceServiceImpl;

    public AttendanceController(AttendanceServiceImpl attendanceServiceImpl) {
        this.attendanceServiceImpl = attendanceServiceImpl;
    }

    @GetMapping("/attendance")
    public ResponseEntity<List<Volunteer>> getAttendance() {
        return ResponseEntity.ok().body(attendanceServiceImpl.viewAttendance());
    }
}
