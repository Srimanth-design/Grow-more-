package com.growmore.exceptions;

public class AnalystNotFoundException extends RuntimeException{
    public AnalystNotFoundException() {
    }

    public AnalystNotFoundException(String message) {
        super(message);
    }
}
