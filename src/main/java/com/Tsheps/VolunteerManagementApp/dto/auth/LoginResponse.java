package com.Tsheps.VolunteerManagementApp.dto.auth;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private Long userId;
private String token;
private String email;
private Role role;
}
