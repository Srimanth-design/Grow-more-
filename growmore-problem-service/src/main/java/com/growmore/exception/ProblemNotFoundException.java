package com.growmore.exception;

public class ProblemNotFoundException extends RuntimeException{
    public ProblemNotFoundException() {
    }

    public ProblemNotFoundException(String message) {
        super(message);
    }
}
