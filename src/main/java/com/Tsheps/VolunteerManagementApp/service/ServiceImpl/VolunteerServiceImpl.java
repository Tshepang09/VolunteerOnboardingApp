package com.Tsheps.VolunteerManagementApp.service.ServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;
import com.Tsheps.VolunteerManagementApp.exception.VolunteerAlreadyExistsException;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.repository.VolunteerRepo;
import com.Tsheps.VolunteerManagementApp.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class VolunteerServiceImpl implements VolunteerService{

    private final VolunteerRepo volunteerRepo;
    private final AttendanceRecord attendanceRecord;

public String createVolunteerProfile(@RequestBody Volunteer volunteer){
    if(volunteerRepo.existsByCellNumber(volunteer.getCellNumber())){
       // return ResponseEntity.status(HttpStatus.CONFLICT).build();
        throw new VolunteerAlreadyExistsException("Volunteer profile already exists");
    }
    return "Successfully registered!";
}


    @Override
    public void createVolunteerProfile(VolunteerRequest VolunteerRequest) {

    }

    @Override
    public VolunteerResponse updateVolunteerProfile(VolunteerRequest volunteerRequest) {

            volunteerRepo.save(volunteerRequest);
        VolunteerResponse volunteerResponse = new VolunteerResponse();
    return VolunteerResponse.builder().;
    }
}
