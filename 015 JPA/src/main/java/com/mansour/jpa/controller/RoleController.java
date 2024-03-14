package com.mansour.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mansour.jpa.model.UserRole;
import com.mansour.jpa.service.RoleService;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public List<UserRole> getUserRoles(){
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public UserRole getRole(@PathVariable Long id){
        return roleService.getRole(id);
    }

    @PostMapping()
    public UserRole creatRole(@RequestBody UserRole userRole){
        return roleService.createRole(userRole);
    }

    @PutMapping()
    public UserRole updateRole(@RequestBody UserRole userRole){
        return roleService.updateRole(userRole);
    }


    @DeleteMapping("/{id}")
    public UserRole deleteRole(@PathVariable Long id){
        return roleService.deleteRole(id);
    }

}
