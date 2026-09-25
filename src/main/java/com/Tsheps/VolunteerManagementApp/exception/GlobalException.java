package com.Tsheps.VolunteerManagementApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException {
//    public GlobalException(String message) {
//        super(message);
//    }
@ExceptionHandler(VolunteerAlreadyExistsException.class)
    public ResponseEntity<String> handleVolunteerAlreadyExistsException(VolunteerAlreadyExistsException vae) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(vae.getMessage());
}

@ExceptionHandler(VolunteerDoesNotExistException.class)
    public ResponseEntity<String> handleVolunteerDoesNotExist(VolunteerDoesNotExistException vdne){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vdne.getMessage());
}
@ExceptionHandler(VolunteerAlreadySignedInException.class)
    public ResponseEntity<String> handleVolunteerAlreadySignedInException(VolunteerAlreadySignedInException vas){
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(vas.getMessage());
}
}
