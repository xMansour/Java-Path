package com.mansour.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mansour.jpa.model.UserRole;
import com.mansour.jpa.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserRole> getRoles() {
        return Lists.newArrayList(roleRepository.findAll());
    }

    @Override
    public UserRole getRole(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public UserRole createRole(UserRole role) {
        return roleRepository.save(role);
    }

    @Override
    public UserRole updateRole(UserRole role) {
        return roleRepository.save(role);
    }

    @Override
    public UserRole deleteRole(Long id) {
        UserRole userRole = getRole(id);
        roleRepository.deleteById(id);
        return userRole;
    }

}
