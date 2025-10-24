package edu.miu.cs489.ads_dental_cli.service.impl;

import edu.miu.cs489.ads_dental_cli.model.User;
import edu.miu.cs489.ads_dental_cli.repository.UserRepository;
import edu.miu.cs489.ads_dental_cli.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
