package edu.miu.cs489.lab11.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Appointment;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.AppointmentRepository;
import edu.miu.cs489.lab11.ads_dental_webapi.service.AppointmentService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByAppointmentDate(date);
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
