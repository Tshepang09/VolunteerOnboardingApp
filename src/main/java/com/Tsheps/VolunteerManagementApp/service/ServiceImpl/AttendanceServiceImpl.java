package com.Tsheps.VolunteerManagementApp.service.ServiceImpl;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.repository.AttendanceRepo;
import com.Tsheps.VolunteerManagementApp.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public List<AttendanceRecord> viewVolunteerAttendance() {
        return attendanceRepo.findAll();
    }

    public void volunteerSignIn(AttendanceRecord volunteerAttendance){
        attendanceRepo.save(volunteerAttendance);
    }
}
