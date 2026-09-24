package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<AttendanceRecord, Long> {
}
