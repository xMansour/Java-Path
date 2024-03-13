package com.mansour.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mansour.jpa.model.Department;
import com.mansour.jpa.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments() {
        return Lists.newArrayList(departmentRepository.findAll());
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department deleteDepartment(Long id) {
        Department department = getDepartment(id);
        departmentRepository.deleteById(id);
        return department;
    }

}
