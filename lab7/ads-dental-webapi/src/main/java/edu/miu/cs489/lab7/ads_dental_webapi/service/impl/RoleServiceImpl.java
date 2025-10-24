package edu.miu.cs489.lab7.ads_dental_webapi.service.impl;

import edu.miu.cs489.lab7.ads_dental_webapi.model.Role;
import edu.miu.cs489.lab7.ads_dental_webapi.repository.RoleRepository;
import edu.miu.cs489.lab7.ads_dental_webapi.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
