package edu.miu.cs489.lab11.ads_dental_webapi.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Patient with ID " + id + " not found.");
    }
}
