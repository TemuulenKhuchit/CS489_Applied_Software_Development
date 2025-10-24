package edu.miu.cs489.lab9.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab9.ads_dental_webapi.model.Dentist;
import edu.miu.cs489.lab9.ads_dental_webapi.repository.DentistRepository;
import edu.miu.cs489.lab9.ads_dental_webapi.service.DentistService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    private final DentistRepository dentistRepository;

    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
    
}
