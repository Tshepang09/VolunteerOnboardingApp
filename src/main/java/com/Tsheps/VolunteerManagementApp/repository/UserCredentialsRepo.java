package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Long> {
}
