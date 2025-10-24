package edu.miu.cs489.ads_dental_cli.repository;

import edu.miu.cs489.ads_dental_cli.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(LocalDate date);

    List<Appointment> findByDentist_DentistName(String dentistName);

    List<Appointment> findByPatient_PatientNo(String patientNo);
}