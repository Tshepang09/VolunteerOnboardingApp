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

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @JoinColumn(name = "volunteerId")
    @ManyToOne(fetch  = FetchType.LAZY)
    private Volunteer Volunteer;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastname;

    private String email;

    @Column(name = "", nullable = false)
    private String cellNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_830 classAllocation_830;

    @Enumerated(EnumType.STRING)
    private ClassAllocation_1030 classAllocation_1030;

    private LocalDate serviceDate;

    @Column(name = "signed_in_at", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signedInAt;

//Populate this field before the record is persisted to the db
@PrePersist
public void onCreate() {
    this.signedInAt = LocalDateTime.now();
}

}