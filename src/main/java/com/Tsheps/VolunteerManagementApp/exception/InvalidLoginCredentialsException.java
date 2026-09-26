package com.Tsheps.VolunteerManagementApp.exception;

public class InvalidLoginCredentialsException extends RuntimeException {
    public  InvalidLoginCredentialsException(){
    super("Username or password incorrect!");
    }
}
