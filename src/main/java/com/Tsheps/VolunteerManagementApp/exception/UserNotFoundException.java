package com.Tsheps.VolunteerManagementApp.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super("User  ID: " + userId + " does not exist.");
    }
}
