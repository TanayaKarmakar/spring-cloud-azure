package com.app.todo.exception;

import com.app.todo.controller.ApiExceptionHandler;

public class ApiException extends RuntimeException{
    private BusinessException businessException;
    private String message;

    public ApiException(BusinessException exception) {
        this.businessException = exception;
    }

    public ApiException(String message) {
        this.message = message;
    }
}
