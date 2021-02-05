package com.ml.CustomersApi.exception;

import com.ml.CustomersApi.exception.concreteExceptions.ApiException;
import com.ml.CustomersApi.exception.concreteExceptions.NotValidCustomerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {NotValidCustomerException.class})
    public ResponseEntity<Object> handleApiRequestException(NotValidCustomerException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiException exception = new ApiException(e.getMessage(), e, status, ZonedDateTime.now());
        return new ResponseEntity<>(exception, status);
    }
}
