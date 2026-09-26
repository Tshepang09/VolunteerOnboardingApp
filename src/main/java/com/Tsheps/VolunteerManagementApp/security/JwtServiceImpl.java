package com.Tsheps.VolunteerManagementApp.security;

import com.Tsheps.VolunteerManagementApp.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtServiceImpl implements JwtService{
        @Value(value = "${jwt.secret}")
        private String secret;

        @Value("${jwt.expiration-ms}")
        private Long expirationMs;

        private SecretKey signinKey(){
            return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        }


    @Override
    public String generateToken(Users user) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("userId", user.getUserId())
                .claim("fullname", user.getFirstname() + " " + user.getLastname())
                .claim("cellnumber", user.getCellNumber())
                .claim("role", user.getRole())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(signinKey())
                .compact();
    }

    @Override
    public boolean validateToken(String jwtToken, String email) {
            Claims claims = parseClaims(jwtToken);
            try{
                //Test if usernameMatches
                boolean usernameMatches = claims.getSubject().equals(email);
                boolean notExpired = claims.getExpiration().after(new Date());

                return usernameMatches && notExpired;
            } catch (ExpiredJwtException expJwt) {
                return false;
            }
    }

    @Override
    public Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(signinKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
