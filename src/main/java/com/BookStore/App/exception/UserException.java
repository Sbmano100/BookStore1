package com.BookStore.App.exception;

public class UserException extends RuntimeException {

    private static final long serviceVersionUID = 1L;

    public UserException(String message){
        super(message);
    }

    public UserException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
