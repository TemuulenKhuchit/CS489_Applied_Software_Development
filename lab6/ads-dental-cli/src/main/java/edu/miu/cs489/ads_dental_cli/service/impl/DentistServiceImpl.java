package edu.miu.cs489.ads_dental_cli.service.impl;

import edu.miu.cs489.ads_dental_cli.model.Dentist;
import edu.miu.cs489.ads_dental_cli.repository.DentistRepository;
import edu.miu.cs489.ads_dental_cli.service.DentistService;
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
