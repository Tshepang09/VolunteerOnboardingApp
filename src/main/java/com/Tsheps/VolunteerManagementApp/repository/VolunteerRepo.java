package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepo extends JpaRepository<Volunteer,Long> {
    boolean existsByIdNumber(String idNumber);
    boolean existsByCellNumber(String cellNumber);
}
