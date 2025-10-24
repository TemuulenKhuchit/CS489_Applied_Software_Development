package edu.miu.cs489.lab7.ads_dental_webapi.service;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Surgery;
import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();

    Surgery saveSurgery(Surgery surgery);
}
