package com.Tsheps.VolunteerManagementApp.service.ServiceImpl;

import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordRequest;
import com.Tsheps.VolunteerManagementApp.dto.AttendanceRecordResponse;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerRequest;
import com.Tsheps.VolunteerManagementApp.dto.VolunteerResponse;
import com.Tsheps.VolunteerManagementApp.exception.VolunteerAlreadyExistsException;
import com.Tsheps.VolunteerManagementApp.exception.VolunteerAlreadySignedInException;
import com.Tsheps.VolunteerManagementApp.exception.VolunteerDoesNotExistException;
import com.Tsheps.VolunteerManagementApp.mappers.AttendanceRecordMapper;
import com.Tsheps.VolunteerManagementApp.mappers.VolunteerMapper;
import com.Tsheps.VolunteerManagementApp.model.AttendanceRecord;
import com.Tsheps.VolunteerManagementApp.model.Volunteer;
import com.Tsheps.VolunteerManagementApp.repository.AttendanceRepo;
import com.Tsheps.VolunteerManagementApp.repository.VolunteerRepo;
import com.Tsheps.VolunteerManagementApp.service.VolunteerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Slf4j
public class VolunteerServiceImpl implements VolunteerService{

    private final VolunteerRepo volunteerRepo;
//    private final AttendanceRecord attendanceRecord;
    private final AttendanceRepo attendanceRepo;

//public String createVolunteerProfile(@RequestBody VolunteerRequest volunteerRequest){
//    return "Successfully registered!";

//}
@Override
@Transactional
public VolunteerResponse updateVolunteerProfile(VolunteerRequest volunteerRequest) {
    Volunteer existingVolunteer = volunteerRepo.findByEmail(volunteerRequest.getEmail())
            .orElseThrow(()-> new VolunteerAlreadyExistsException(volunteerRequest.getEmail()));

    log.info("Volunteer profile exists. Now updating profile");

    //Making the Volunteer entity changes
    existingVolunteer.setFirstname(volunteerRequest.getFirstname());
    existingVolunteer.setLastname(volunteerRequest.getLastname());
    existingVolunteer.setEmail(volunteerRequest.getEmail());
    existingVolunteer.setGender(volunteerRequest.getGender());
    existingVolunteer.setCellNumber(volunteerRequest.getCellNumber());
    existingVolunteer.setClassAllocation1(volunteerRequest.getClassAllocation1());
    existingVolunteer.setClassAllocation2(volunteerRequest.getClassAllocation2());

    Volunteer updatedVolunteer= volunteerRepo.save(existingVolunteer);


    log.info("Now returning the Volunteer response.");
    return VolunteerMapper.toResponse(updatedVolunteer);
}


    @Override
    @Transactional
    public VolunteerResponse createVolunteerProfile(VolunteerRequest volunteerRequest) {

        log.info("Checking if Volunteer profile exists");
        if(volunteerRepo.existsByCellNumber(volunteerRequest.getCellNumber())) {
            log.info("Volunteer profile already exists.");
            throw new VolunteerAlreadyExistsException(volunteerRequest.getEmail());
        }

        // return ResponseEntity.status(HttpStatus.CONFLICT).build();

        log.info("It doesn't. Now building the Volunteer entity profile ");
        Volunteer savedVolunteer = VolunteerMapper.toVolunteer(volunteerRequest);

            volunteerRepo.save(savedVolunteer);
            return VolunteerMapper.toResponse(savedVolunteer);
    }

    @Override
    @Transactional
    public AttendanceRecordResponse volunteerSignin(AttendanceRecordRequest attendanceRecordRequest) {


        log.info("Testing if Volunteer profile exists before building the AttendanceRecord.");
        //pull Volunteer entity to pass into the attendance record
        Volunteer existingVolunteer = volunteerRepo.findByEmail(attendanceRecordRequest.getEmail())
                .orElseThrow(() -> new VolunteerDoesNotExistException(attendanceRecordRequest.getEmail()));

        //Test is voolunteer has already signedin
        LocalDate today = LocalDate.now();
        log.info("Checking if Volunteer has already signed the AttendanceRecord.");
        if(attendanceRepo.existsByEmailAndServiceDate(existingVolunteer.getEmail(), today))
            throw new VolunteerAlreadySignedInException(today);

        log.info("It does, now building AttendanceRecord");
        AttendanceRecord attendanceRecord = AttendanceRecordMapper.toAttendanceRecord(attendanceRecordRequest, existingVolunteer);

        log.info("Persisting a new AttendanceRecord into db.");
        AttendanceRecord recordedAttendance = attendanceRepo.save(attendanceRecord);

        log.info("Mapping to AttendanceRecordResponse.");
        return AttendanceRecordMapper.toAttendanceRecordResponse(recordedAttendance, existingVolunteer);
    }
}
