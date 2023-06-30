package com.messi.demo.core.exception;

public class BusinesseException extends Exception{

    private String message ;

    public BusinesseException(String message) {
        this.message = message ;
    }

    public String getMessage() {
        return this.message ;
    }
}
