package edu.miu.cs489.ads_dental_cli.repository;

import edu.miu.cs489.ads_dental_cli.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
    Optional<Surgery> findBySurgeryNo(String surgeryNo);
}
