package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);
}
