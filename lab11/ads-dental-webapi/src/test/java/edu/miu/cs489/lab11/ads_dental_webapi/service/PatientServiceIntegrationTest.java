package edu.miu.cs489.lab11.ads_dental_webapi.service;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceIntegrationTest {

    @Autowired
    private PatientService patientService;

    @Test
    void testFindPatientById_found() {
        Patient p = patientService.findPatientById(1L);
        assertNotNull(p);
        assertEquals("P100", p.getPatientNo());
    }

    @Test
    void testFindPatientById_notFound() {
        assertThrows(RuntimeException.class, () -> patientService.findPatientById(999L));
    }
}
