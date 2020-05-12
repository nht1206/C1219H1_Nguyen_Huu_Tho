package com.codegym.blogrest.controller;

import com.codegym.blogrest.exception.BlogNotFoundException;
import com.codegym.blogrest.model.ApiError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BlogNotFoundException.class})
    public final ResponseEntity<ApiError> handleBlogNotFoundException(final BlogNotFoundException ex, final WebRequest request) {
        final ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<ApiError> handleException(final Exception ex, final WebRequest request) {
        final ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}