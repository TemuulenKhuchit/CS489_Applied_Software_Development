package edu.miu.cs489.lab11.ads_dental_webapi.controller;

import edu.miu.cs489.lab11.ads_dental_webapi.model.Address;
import edu.miu.cs489.lab11.ads_dental_webapi.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // 7️⃣ GET all addresses sorted by city
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> sorted = addressService.getAllAddresses()
                .stream()
                .sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
        return ResponseEntity.ok(sorted);
    }
}
