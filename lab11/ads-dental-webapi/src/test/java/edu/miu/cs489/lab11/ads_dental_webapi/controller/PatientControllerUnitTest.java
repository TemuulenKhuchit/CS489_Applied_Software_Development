package edu.miu.cs489.lab11.ads_dental_webapi.controller;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Patient;
import edu.miu.cs489.lab11.ads_dental_webapi.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
public class PatientControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    void testGetAllPatients_returnsJsonList() throws Exception {
        List<Patient> patients = List.of(
                new Patient(1L, "P100", "Gillian", "White", null, null),
                new Patient(2L, "P105", "Jill", "Bell", null, null)
        );
        when(patientService.getAllPatients()).thenReturn(patients);

        mockMvc.perform(get("/adsweb/api/v1/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].patientNo").value("P105"))
                .andExpect(jsonPath("$[1].patientNo").value("P100"));
    }
}
