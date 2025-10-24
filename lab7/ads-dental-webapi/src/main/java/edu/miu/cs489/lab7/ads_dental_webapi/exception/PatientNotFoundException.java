package edu.miu.cs489.lab7.ads_dental_webapi.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient with ID " + id + " not found.");
    }
}
