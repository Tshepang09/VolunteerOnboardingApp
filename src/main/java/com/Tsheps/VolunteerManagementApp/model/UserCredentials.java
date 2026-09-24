package com.Tsheps.VolunteerManagementApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCredentialId;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

    private String password;

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
