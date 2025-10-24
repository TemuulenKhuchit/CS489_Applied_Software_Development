package edu.miu.cs489.ads_dental_cli.repository;

import edu.miu.cs489.ads_dental_cli.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByPatientNo(String patientNo);
}