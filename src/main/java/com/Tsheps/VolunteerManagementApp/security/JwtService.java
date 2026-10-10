package com.Tsheps.VolunteerManagementApp.security;

import com.Tsheps.VolunteerManagementApp.model.Users;
import io.jsonwebtoken.Claims;

public interface JwtService {

     String generateToken(Users user);

     boolean validateToken(String jwtToken, String email);
     Claims parseClaims(String jwtToken);
}
