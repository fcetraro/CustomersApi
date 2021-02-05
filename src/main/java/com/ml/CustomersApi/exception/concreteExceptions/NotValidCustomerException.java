package com.ml.CustomersApi.exception.concreteExceptions;

public class NotValidCustomerException extends RuntimeException {
    public NotValidCustomerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
