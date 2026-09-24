package com.Tsheps.VolunteerManagementApp.model;

import com.Tsheps.VolunteerManagementApp.enums.Gender;
import com.Tsheps.VolunteerManagementApp.enums.ClassAllocation_830;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @JoinColumn(name = "volunteerId")
    @OneToOne(fetch  = FetchType.LAZY)
    private Volunteer volunteer;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String LastName;

    private String email;

    @Column(name = "", nullable = false)
    private String cellNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 session1Class;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 session2Class;

    @Column(name = "signed_in_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signedInAt;

//Populate this field before the record is persisted to the db
@PrePersist
public void onCreate() {
    this.signedInAt = LocalDateTime.now();
}

}