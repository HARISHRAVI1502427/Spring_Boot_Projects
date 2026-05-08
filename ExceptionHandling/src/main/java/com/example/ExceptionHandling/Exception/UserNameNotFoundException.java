package com.example.ExceptionHandling.Exception;

public class UserNameNotFoundException extends Exception {
    private String msg;
    public UserNameNotFoundException() {}
    public UserNameNotFoundException(String message) {
        super(message);
        this.msg=message;
    }
}
