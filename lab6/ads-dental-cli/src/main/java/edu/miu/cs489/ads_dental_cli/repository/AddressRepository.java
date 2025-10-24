package edu.miu.cs489.ads_dental_cli.repository;

import edu.miu.cs489.ads_dental_cli.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreet(String street);
}
