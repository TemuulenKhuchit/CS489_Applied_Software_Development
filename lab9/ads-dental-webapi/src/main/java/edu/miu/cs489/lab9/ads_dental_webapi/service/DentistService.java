package edu.miu.cs489.lab9.ads_dental_webapi.service;

import edu.miu.cs489.lab9.ads_dental_webapi.model.Dentist;
import java.util.List;

public interface DentistService {
    List<Dentist> getAllDentists();

    Dentist saveDentist(Dentist dentist);
}