package com.Tsheps.VolunteerManagementApp.security;

import io.jsonwebtoken.Jwts;
import org.apache.catalina.User;

public interface JwtService {
    public String generateToken(User user);
    public boolean validateToken(String jwtToken);

}
