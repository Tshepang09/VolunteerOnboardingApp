package com.Tsheps.VolunteerManagementApp.repository;

import com.Tsheps.VolunteerManagementApp.model.UserCredentials;
import com.Tsheps.VolunteerManagementApp.model.Users;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials,Long> {

    boolean existsByPassword(String password);

    // User_UserId tells the Spring to go into User entity and access the UserId
    void deleteByUser_UserId(Long userId);

    UserCredentials findByUser_UserId(Long userId);
}
