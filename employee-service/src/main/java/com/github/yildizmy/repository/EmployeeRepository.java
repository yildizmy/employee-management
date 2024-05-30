package com.github.yildizmy.repository;

import com.github.yildizmy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee add(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employees.stream()
                .filter(a -> a.getDepartmentId().equals(id))
                .toList();
    }

    public List<Employee> findByOrganizationId(Long id) {
        return employees.stream()
                .filter(a -> a.getOrganizationId().equals(id))
                .toList();
    }
}
