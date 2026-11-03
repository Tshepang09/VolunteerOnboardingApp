package com.Tsheps.VolunteerManagementApp.exception;

import com.Tsheps.VolunteerManagementApp.dto.ExceptionHandlerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalException extends RuntimeException {
    ExceptionHandlerResponse exceptionHandlerResponse;
//    public GlobalException(String ErrorMessage) {
//        super(ErrorMessage);
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
@ExceptionHandler(InvalidLoginCredentialsException.class)
    ResponseEntity<String> handleInvalidLoginCredentialsException(InvalidLoginCredentialsException ilce){
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ilce.getMessage());
}

@ExceptionHandler(UnauthorizedCredentialsException.class)
    ExceptionHandlerResponse handleUnauthorisedCredentialsException(UnauthorizedCredentialsException uce){
    HttpStatusCode statusCode = HttpStatus.UNAUTHORIZED;
    return (exceptionHandlerResponse.builder()
            .statusCode(statusCode.value())
            .statusMessage(HttpStatus.UNAUTHORIZED.name())
            .ErrorMessage(uce.getMessage())
            .build());
}
@ExceptionHandler(UserNotFoundException.class)
     ExceptionHandlerResponse handleUserNotFoundException(UserNotFoundException unfe){
    HttpStatusCode statusCode = HttpStatus.NOT_FOUND;
    return exceptionHandlerResponse.builder()
            .statusCode(statusCode.value())
            .statusMessage(HttpStatus.NOT_FOUND.name())
            .ErrorMessage(unfe.getMessage())
            .build();
}
}
