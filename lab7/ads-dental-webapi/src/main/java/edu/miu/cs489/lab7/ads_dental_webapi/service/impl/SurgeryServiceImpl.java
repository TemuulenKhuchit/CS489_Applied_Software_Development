package edu.miu.cs489.lab7.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Surgery;
import edu.miu.cs489.lab7.ads_dental_webapi.repository.SurgeryRepository;
import edu.miu.cs489.lab7.ads_dental_webapi.service.SurgeryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private final SurgeryRepository surgeryRepository;

    public SurgeryServiceImpl(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery saveSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
