package com.example.ExceptionHandling.Exception;

public class NoSuchCustomerExistsException extends Exception {
    private String message;
    public NoSuchCustomerExistsException() {}
    public NoSuchCustomerExistsException(String message) {
        super(message);
        this.message = message;
    }
}
