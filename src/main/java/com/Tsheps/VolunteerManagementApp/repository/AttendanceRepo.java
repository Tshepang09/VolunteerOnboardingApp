package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AttendanceRepo extends JpaRepository<AttendanceRecord, Long> {

    boolean existsByEmailAndServiceDate(String email, LocalDate today);
}
