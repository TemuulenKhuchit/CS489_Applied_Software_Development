package edu.miu.cs489.ads_dental_cli.service.impl;

import edu.miu.cs489.ads_dental_cli.model.Patient;
import edu.miu.cs489.ads_dental_cli.repository.PatientRepository;
import edu.miu.cs489.ads_dental_cli.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
