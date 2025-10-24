package edu.miu.cs489.lab7.ads_dental_webapi.service;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Appointment;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByDate(LocalDate date);

    Appointment saveAppointment(Appointment appointment);
}
