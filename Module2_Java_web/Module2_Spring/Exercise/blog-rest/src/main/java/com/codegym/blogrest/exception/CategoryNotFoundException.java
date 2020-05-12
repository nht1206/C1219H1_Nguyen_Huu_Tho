package com.codegym.blogrest.exception;

public class CategoryNotFoundException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -1350155401342002625L;

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CategoryNotFoundException(String message) {
        super(message);
    }
    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }
}