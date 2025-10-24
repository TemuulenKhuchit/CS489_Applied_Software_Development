package edu.miu.cs489.ads_dental_cli.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

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
    private Dentist dentist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;
}