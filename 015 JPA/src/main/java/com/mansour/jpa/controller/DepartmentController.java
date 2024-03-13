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

import com.mansour.jpa.model.Department;
import com.mansour.jpa.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping()
    public Department createDepartment(@RequestBody Department Department) {
        return departmentService.createDepartment(Department);
    }

    @DeleteMapping("/{id}")
    public Department deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }

    @PutMapping()
    public Department updateDepartment(@RequestBody Department Department) {
        return departmentService.updateDepartment(Department);
    }
}
