package edu.miu.cs489.lab7.ads_dental_webapi.repository;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
