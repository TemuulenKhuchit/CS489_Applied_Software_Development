package edu.miu.cs489.lab7.ads_dental_webapi.repository;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    Optional<Dentist> findByDentistName(String dentistName);
}
