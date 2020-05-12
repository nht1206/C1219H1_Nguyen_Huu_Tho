package com.codegym.blogrest.exception;

public class BlogNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }



    public BlogNotFoundException(String message) {
        super(message);
    }



    public BlogNotFoundException(Throwable cause) {
        super(cause);
    }
    


    
}