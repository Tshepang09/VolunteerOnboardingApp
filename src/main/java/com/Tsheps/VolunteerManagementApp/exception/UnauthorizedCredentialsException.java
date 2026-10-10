package com.Tsheps.VolunteerManagementApp.exception;

public class UnauthorizedCredentialsException extends RuntimeException {
    public UnauthorizedCredentialsException() {

        super("Attempted to register admin with Volunteer credentials!");
    }
}
