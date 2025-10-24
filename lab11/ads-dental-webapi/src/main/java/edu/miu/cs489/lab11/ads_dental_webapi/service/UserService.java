package edu.miu.cs489.lab11.ads_dental_webapi.service;

import edu.miu.cs489.lab11.ads_dental_webapi.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);
}
