package edu.miu.cs489.lab9.ads_dental_webapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dentistName;

    @OneToMany(mappedBy = "dentist")
    @JsonManagedReference(value = "dentist-appointments")
    private List<Appointment> appointments = new ArrayList<>();
}