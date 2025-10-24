package edu.miu.cs489.lab7.ads_dental_webapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointments", indexes = { @Index(columnList = "appointmentDate"),
        @Index(columnList = "appointmentTime") })
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate appointmentDate;
    @Column(nullable = false)
    private LocalTime appointmentTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dentist_id")
    @JsonBackReference(value = "dentist-appointments")
    private Dentist dentist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    @JsonBackReference(value = "patient-appointments")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "surgery_id")
    @JsonBackReference(value = "surgery-appointments")
    private Surgery surgery;
}