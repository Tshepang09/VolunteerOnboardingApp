package com.Tsheps.VolunteerManagementApp.exception;

public class VolunteerAlreadyExistsException extends RuntimeException {
    public VolunteerAlreadyExistsException(String message) {
        super(message);
    }
}
