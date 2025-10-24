package edu.miu.cs489.lab11.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab11.ads_dental_webapi.model.*;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.AppointmentRepository;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.DentistRepository;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.PatientRepository;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.SurgeryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DataLoaderImpl implements CommandLineRunner {
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;
    private final SurgeryRepository surgeryRepository;
    private final AppointmentRepository appointmentRepository;

    public DataLoaderImpl(DentistRepository dentistRepository, PatientRepository patientRepository,
            SurgeryRepository surgeryRepository, AppointmentRepository appointmentRepository) {
        this.dentistRepository = dentistRepository;
        this.patientRepository = patientRepository;
        this.surgeryRepository = surgeryRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) {
        Dentist tony = dentistRepository.save(new Dentist(null, "Tony Smith", null));
        Dentist helen = dentistRepository.save(new Dentist(null, "Helen Pearson", null));
        Dentist robin = dentistRepository.save(new Dentist(null, "Robin Plevin", null));

        Surgery s10 = surgeryRepository.save(new Surgery(null, "S10",
                new Address(null, "10 Main St", "Fairfield", "52556"), null));
        Surgery s13 = surgeryRepository.save(new Surgery(null, "S13",
                new Address(null, "13 Oak St", "Fairfield", "52556"), null));
        Surgery s15 = surgeryRepository.save(new Surgery(null, "S15",
                new Address(null, "15 Pine St", "Fairfield", "52556"), null));

        Patient p100 = patientRepository.save(new Patient(null, "P100", "Gillian", "White",
                new Address(null, "1 Pine Rd", "Fairfield", "52556"), null));
        Patient p105 = patientRepository.save(new Patient(null, "P105", "Jill", "Bell",
                new Address(null, "2 Maple Rd", "Fairfield", "52556"), null));
        Patient p108 = patientRepository.save(new Patient(null, "P108", "Ian", "MacKay",
                new Address(null, "3 Elm Rd", "Fairfield", "52556"), null));
        Patient p110 = patientRepository.save(new Patient(null, "P110", "John", "Walker",
                new Address(null, "4 Cedar Rd", "Fairfield", "52556"), null));

        appointmentRepository.saveAll(List.of(
                new Appointment(null, LocalDate.of(2013, 9, 12), LocalTime.of(10, 0), tony, p100, s15),
                new Appointment(null, LocalDate.of(2013, 9, 12), LocalTime.of(12, 0), tony, p105, s15),
                new Appointment(null, LocalDate.of(2013, 9, 13), LocalTime.of(10, 0), helen, p108, s10),
                new Appointment(null, LocalDate.of(2013, 9, 14), LocalTime.of(14, 0), helen, p108, s10),
                new Appointment(null, LocalDate.of(2013, 9, 14), LocalTime.of(16, 30), robin, p105, s15),
                new Appointment(null, LocalDate.of(2013, 9, 15), LocalTime.of(18, 0), robin, p110, s13)));

        System.out.println("✅ Sample data successfully loaded into ADS Dental CLI database!");
    }
}
