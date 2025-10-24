package edu.miu.cs489.ads_dental_cli.service.impl;

import edu.miu.cs489.ads_dental_cli.model.Address;
import edu.miu.cs489.ads_dental_cli.repository.AddressRepository;
import edu.miu.cs489.ads_dental_cli.service.AddressService;
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