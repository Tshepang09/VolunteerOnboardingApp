package com.Tsheps.VolunteerManagementApp.service;

import com.Tsheps.VolunteerManagementApp.dto.auth.UserResponse;

import java.util.List;

public interface UserService {

     void deleteUser(Long userId);

     List<UserResponse> getAllUsers();
}
