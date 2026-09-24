package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.User;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
