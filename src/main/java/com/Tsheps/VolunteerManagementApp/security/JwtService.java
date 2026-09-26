package com.Tsheps.VolunteerManagementApp.security;

import com.Tsheps.VolunteerManagementApp.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.catalina.User;

public interface JwtService {
    public String generateToken(User user);

    String generateToken(Users user);

    public boolean validateToken(String jwtToken);
    public Claims parseClaims(String String);
}
