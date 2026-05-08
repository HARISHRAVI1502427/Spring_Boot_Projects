package com.example.ExceptionHandling.Exception;

public class UserEmailNotException extends Exception {
    private String msg;
    public UserEmailNotException() {}
    public UserEmailNotException(String message) {
        super(message);
        this.msg=message;
    }
}
