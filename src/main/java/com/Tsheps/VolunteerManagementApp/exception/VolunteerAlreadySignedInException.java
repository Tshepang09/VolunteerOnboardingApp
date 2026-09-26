package com.Tsheps.VolunteerManagementApp.exception;

import java.time.LocalDate;

public class VolunteerAlreadySignedInException extends RuntimeException{
    public VolunteerAlreadySignedInException(LocalDate today){
        super("Volunteer already signed in for today's service(s): " + today);
    }
}
