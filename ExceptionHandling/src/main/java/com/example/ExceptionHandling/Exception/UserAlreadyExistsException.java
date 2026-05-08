package com.example.ExceptionHandling.Exception;

public class UserAlreadyExistsException extends Exception {
    private String message;
    public UserAlreadyExistsException() {}
    public UserAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
