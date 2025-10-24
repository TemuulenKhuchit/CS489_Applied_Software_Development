package edu.miu.cs489.lab7.ads_dental_webapi.service;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role saveRole(Role role);
}
