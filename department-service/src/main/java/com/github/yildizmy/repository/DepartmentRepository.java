package com.github.yildizmy.repository;

import com.github.yildizmy.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department add(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganizationId(Long id) {
        return departments.stream()
                .filter(a -> a.getOrganizationId().equals(id))
                .toList();
    }
}
