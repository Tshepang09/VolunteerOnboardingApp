package com.Tsheps.VolunteerManagementApp.service.ServiceImpl;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.repository.AttendanceRepo;
import com.Tsheps.VolunteerManagementApp.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public AttendanceServiceImpl(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    public List<Volunteer> viewAttendance() {
        return attendanceRepo.findAll();
    }

    public void volunteerSignIn(AttendanceRecord volunteerAttendance){
        attendanceRepo.save(volunteerAttendance);
    }
}
