package edu.miu.cs489.lab7.ads_dental_webapi.service;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Address;
import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address saveAddress(Address address);
}
