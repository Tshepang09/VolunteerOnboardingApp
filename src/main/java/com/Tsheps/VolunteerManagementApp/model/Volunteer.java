package com.Tsheps.VolunteerManagementApp.model;

import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_1030;
import com.Tsheps.VolunteerManagementApp.enums.Gender;
import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Table(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volunteerId;

    private String firstname;

    private String lastname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String cellNumber;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 classAllocation1;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_1030 classAllocation2;

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
