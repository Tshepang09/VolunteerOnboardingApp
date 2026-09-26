package com.Tsheps.VolunteerManagementApp.mappers;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordResponse;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AttendanceRecordMapper {
    public static AttendanceRecordResponse toAttendanceRecordResponse(AttendanceRecord attendanceRecord, Volunteer volunteer){

        return AttendanceRecordResponse.builder()
                .attendanceId(attendanceRecord.getAttendanceId())
                .volunteerId(volunteer.getVolunteerId())
                .firstname(volunteer.getFirstname())
                .lastname(volunteer.getLastname())
                .email(volunteer.getEmail())
                .gender(volunteer.getGender())
                .cellNumber(volunteer.getCellNumber())
                .serviceDate(LocalDate.now())
                .classAllocation_830(attendanceRecord.getClassAllocation_830())
                .classAllocation_1030(attendanceRecord.getClassAllocation_1030())
                .signedInAt(attendanceRecord.getSignedInAt())
                .build();
    }
    public static AttendanceRecord toAttendanceRecord(AttendanceRecordRequest attendanceRecordRequest, Volunteer existingVolunteer){

        return AttendanceRecord.builder()
                .firstname(existingVolunteer.getFirstname())
                .lastname(existingVolunteer.getLastname())
                .Volunteer(existingVolunteer)
                .gender(existingVolunteer.getGender())
                .email(existingVolunteer.getEmail())
                .cellNumber(existingVolunteer.getCellNumber())
                .serviceDate(LocalDate.now())
                .classAllocation_830(attendanceRecordRequest.getClassAllocation_830())
                .classAllocation_1030(attendanceRecordRequest.getClassAllocation_1030())
                .build();
    }
}
