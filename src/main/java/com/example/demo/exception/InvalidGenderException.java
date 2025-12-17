package com.example.demo.exception;

public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException(String message) {
        super(message);
    }
}
