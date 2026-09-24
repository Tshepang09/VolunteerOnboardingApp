package com.Tsheps.VolunteerManagementApp.model;

import com.Tsheps.VolunteerManagementApp.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String firstname;
    private String lastname;
    private String email;

    private String cellNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;


    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;


    @PrePersist
    private void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
