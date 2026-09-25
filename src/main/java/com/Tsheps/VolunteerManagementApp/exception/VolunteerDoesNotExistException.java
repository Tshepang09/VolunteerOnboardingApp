package com.Tsheps.VolunteerManagementApp.exception;

public class VolunteerDoesNotExistException extends RuntimeException {
    public VolunteerDoesNotExistException(String email) {
        super("Volunteer with email: " + email + " does not exist!");
    }

}
