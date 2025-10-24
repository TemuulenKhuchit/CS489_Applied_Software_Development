package edu.miu.cs489.lab9.ads_dental_webapi.repository;

import edu.miu.cs489.lab9.ads_dental_webapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreet(String street);
}
