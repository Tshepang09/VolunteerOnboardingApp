package com.Tsheps.VolunteerManagementApp.mappers;

import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VolunteerMapper {
    public static VolunteerResponse toResponse(Volunteer vol){

        return VolunteerResponse.builder()
                .volunteerId(vol.getVolunteerId())
                .firstName(vol.getFirstname())
                .lastName(vol.getLastname())
                .email(vol.getEmail())
                .gender(vol.getGender())
                .cellNumber(vol.getCellNumber())
                .classAllocation1(vol.getClassAllocation1())
                .classAllocation2(vol.getClassAllocation2())
                .createdAt(vol.getCreatedAt())
                .updatedAt(vol.getUpdatedAt())
                .build();
    }

    public static
    Volunteer toVolunteer(VolunteerRequest volunteerRequest){

        return Volunteer.builder()
                .firstname(volunteerRequest.getFirstname())
                .lastname(volunteerRequest.getLastname())
                .email(volunteerRequest.getEmail())
                .gender(volunteerRequest.getGender())
                .cellNumber(volunteerRequest.getCellNumber())
                .classAllocation1(volunteerRequest.getClassAllocation1())
                .classAllocation2(volunteerRequest.getClassAllocation2())
                .build();
    }
}
