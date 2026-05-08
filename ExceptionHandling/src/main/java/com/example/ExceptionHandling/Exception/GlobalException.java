package com.example.ExceptionHandling.Exception;

import com.example.ExceptionHandling.Entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(NoSuchCustomerExistsException.class)
    public ResponseEntity<ErrorResponse> noSuchCustomerException(NoSuchCustomerExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Customer Not present here",404));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> userAlreadyException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Customer Already present here",404));
    }
    @ExceptionHandler(UserEmailNotException.class)
    public ResponseEntity<ErrorResponse> userEmailNotException(UserEmailNotException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Customer email not here",404));
    }
    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNameNotFoundException(UserNameNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Customer name not present here",404));
    }
}
