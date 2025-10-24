package edu.miu.cs489.lab7.ads_dental_webapi.repository;

import edu.miu.cs489.lab7.ads_dental_webapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
