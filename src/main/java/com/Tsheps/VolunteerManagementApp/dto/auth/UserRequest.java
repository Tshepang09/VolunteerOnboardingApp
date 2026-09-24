package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRequest {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String cellNumber;
    private Role role;
}
