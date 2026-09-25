package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerRepo extends JpaRepository<Volunteer,Long> {
    boolean existsByCellNumber(String cellNumber);
    Optional<Volunteer> findByEmail(String email);
}
