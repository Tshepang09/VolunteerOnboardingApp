package com.Tsheps.VolunteerManagementApp.model;

import com.Tsheps.VolunteerManagementApp.enums.Gender;
import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volunteerId;

    private String firstName;

    private String LastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String email;

    private String cellNumber;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 classAllocation1;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 classAllocation2;

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
