package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.Appointment;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByDate(LocalDate date);

    Appointment saveAppointment(Appointment appointment);
}
