package com.example.InsurTech.util;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}