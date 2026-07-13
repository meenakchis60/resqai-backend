package com.resqai.exception;

public class MedicalProfileAlreadyExistsException extends RuntimeException {

    public MedicalProfileAlreadyExistsException(String message) {
        super(message);
    }

}