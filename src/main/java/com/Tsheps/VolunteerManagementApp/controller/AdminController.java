package com.Tsheps.VolunteerManagementApp.controller;

import com.Tsheps.VolunteerManagementApp.dto.auth.LoginRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.LoginResponse;
import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterRequest;
import com.Tsheps.VolunteerManagementApp.dto.auth.RegisterResponse;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.service.AttendanceService;
import com.Tsheps.VolunteerManagementApp.service.AuthService;
import com.Tsheps.VolunteerManagementApp.service.ServiceImpl.AttendanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
@RequestMapping("/api/kc-volunteers/admin-portal")
public class AttendanceController {
    private final AttendanceService attendanceService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.registerAdmin(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginAdmin(loginRequest));
    }


    @GetMapping("/attendance")
    public ResponseEntity<List<AttendanceRecord>> getVolunteerAttendance() {
        return ResponseEntity.ok().body(attendanceService.viewVolunteerAttendance());
    }
}
