package edu.miu.cs489.lab7.ads_dental_webapi.controller;

import edu.miu.cs489.lab7.ads_dental_webapi.exception.PatientNotFoundException;
import edu.miu.cs489.lab7.ads_dental_webapi.model.Patient;
import edu.miu.cs489.lab7.ads_dental_webapi.service.PatientService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // 1️⃣ GET all patients sorted by lastName
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> sorted = patientService.getAllPatients()
                .stream()
                .sorted(Comparator.comparing(Patient::getLastName))
                .collect(Collectors.toList());
        return ResponseEntity.ok(sorted);
    }

    // 2️⃣ GET one patient by id
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getAllPatients()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    // 3️⃣ POST create patient
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient saved = patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 4️⃣ PUT update patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,
            @RequestBody Patient updated) {
        Patient patient = patientService.getAllPatients()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PatientNotFoundException(id));

        patient.setFirstName(updated.getFirstName());
        patient.setLastName(updated.getLastName());
        patient.setAddress(updated.getAddress());
        patient.setPatientNo(updated.getPatientNo());
        Patient saved = patientService.savePatient(patient);
        return ResponseEntity.ok(saved);
    }

    // 5️⃣ DELETE patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        Patient patient = patientService.getAllPatients()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PatientNotFoundException(id));
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }

    // 6️⃣ SEARCH
    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Patient>> searchPatient(@PathVariable String searchString) {
        List<Patient> result = patientService.getAllPatients().stream()
                .filter(p -> p.getFirstName().toLowerCase().contains(searchString.toLowerCase())
                        || p.getLastName().toLowerCase().contains(searchString.toLowerCase())
                        || p.getPatientNo().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
