package com.mansour.jpa.service;

import java.util.List;

import com.mansour.jpa.model.UserRole;

public interface RoleService {
    List<UserRole> getRoles();

    UserRole getRole(Long id);

    UserRole createRole(UserRole role);

    UserRole updateRole(UserRole role);

    UserRole deleteRole(Long id);

}
