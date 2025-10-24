package edu.miu.cs489.ads_dental_cli.service;

import edu.miu.cs489.ads_dental_cli.model.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role saveRole(Role role);
}
