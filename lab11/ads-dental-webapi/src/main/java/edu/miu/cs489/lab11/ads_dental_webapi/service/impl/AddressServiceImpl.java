package edu.miu.cs489.lab11.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Address;
import edu.miu.cs489.lab11.ads_dental_webapi.repository.AddressRepository;
import edu.miu.cs489.lab11.ads_dental_webapi.service.AddressService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
}