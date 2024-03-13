package com.mansour.jpa.service;

import java.util.List;

import com.mansour.jpa.model.Department;

public interface DepartmentService {
    List<Department> getDepartments();

    Department getDepartment(Long id);

    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    Department deleteDepartment(Long id);
}
