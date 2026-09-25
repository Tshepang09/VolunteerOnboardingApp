package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String cellNumber;
    private String password;
    private Role role;
}
