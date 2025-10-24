package edu.miu.cs489.ads_dental_cli.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

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
    private List<Appointment> appointments = new ArrayList<>();
}