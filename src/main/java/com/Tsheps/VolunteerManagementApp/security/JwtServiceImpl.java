package com.Tsheps.VolunteerManagementApp.security;

import org.apache.catalina.User;

public class JwtServiceImpl implements JwtService{
    @Override
    public String generateToken(User user) {

        return "";
    }

    @Override
    public boolean validateToken(String jwtToken) {
        return false;
    }
}
