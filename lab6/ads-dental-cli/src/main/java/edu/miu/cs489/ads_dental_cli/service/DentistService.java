package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.Dentist;
import java.util.List;

public interface DentistService {
    List<Dentist> getAllDentists();

    Dentist saveDentist(Dentist dentist);
}