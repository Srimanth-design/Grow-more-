package com.growmore.exception;

public class FarmerNotFoundException extends RuntimeException{
    public FarmerNotFoundException() {
        super();
    }

    public FarmerNotFoundException(String message) {
        super(message);
    }
}
