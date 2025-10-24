package edu.miu.cs489.lab9.ads_dental_webapi;

import edu.miu.cs489.lab9.ads_dental_webapi.model.Role;
import edu.miu.cs489.lab9.ads_dental_webapi.model.User;
import edu.miu.cs489.lab9.ads_dental_webapi.repository.RoleRepository;
import edu.miu.cs489.lab9.ads_dental_webapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AdsDentalWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsDentalWebapiApplication.class, args);
    }

    @Bean
    CommandLineRunner initUsers(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            Role adminRole = roleRepo.save(Role.builder().name("ADMIN").build());
            Role userRole = roleRepo.save(Role.builder().name("USER").build());

            User admin = User.builder()
                    .username("admin")
                    .password(encoder.encode("admin123"))
                    .roles(Set.of(adminRole))
                    .build();
            User normal = User.builder()
                    .username("user")
                    .password(encoder.encode("user123"))
                    .roles(Set.of(userRole))
                    .build();

            userRepo.saveAll(List.of(admin, normal));
        };
    }

}
