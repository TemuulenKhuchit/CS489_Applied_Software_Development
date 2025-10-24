package edu.miu.cs489.lab11.ads_dental_webapi.repository;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Appointment;
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