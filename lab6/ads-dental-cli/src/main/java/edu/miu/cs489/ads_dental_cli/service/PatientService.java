package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient savePatient(Patient patient);
}
