package com.BookStore.App.exception;

public class InventoryException extends RuntimeException {

    private static final long serviceVersionUID = 1L;

    public InventoryException(String message){
        super(message);
    }

    public InventoryException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
