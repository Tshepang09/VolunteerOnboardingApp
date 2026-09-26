package com.Tsheps.VolunteerManagementApp.exception;

public class VolunteerAlreadyExistsException extends RuntimeException {
    public VolunteerAlreadyExistsException(String email) {

        super("Volunteer with email: " + email + " already exists!");
    }

}
