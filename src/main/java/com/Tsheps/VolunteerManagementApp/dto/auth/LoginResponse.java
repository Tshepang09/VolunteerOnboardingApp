package com.Tsheps.VolunteerManagementApp.dto.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
private String token;
private String email;
