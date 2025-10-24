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
@Table(name = "surgeries", uniqueConstraints = @UniqueConstraint(columnNames = "surgeryNo"))
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String surgeryNo; // e.g., S10, S13, S15

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "surgery")
    @JsonManagedReference(value = "surgery-appointments")
    private List<Appointment> appointments = new ArrayList<>();
}