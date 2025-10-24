package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.Surgery;
import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();

    Surgery saveSurgery(Surgery surgery);
}
