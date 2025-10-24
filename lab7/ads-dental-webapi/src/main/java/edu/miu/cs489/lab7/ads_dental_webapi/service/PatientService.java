package edu.miu.cs489.lab7.ads_dental_webapi.service;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient savePatient(Patient patient);

    void deletePatientById(Long id);
}
