package com.github.yildizmy.controller;

import com.github.yildizmy.client.EmployeeClient;
import com.github.yildizmy.model.Department;
import com.github.yildizmy.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "DepartmentController")
@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository repository;
    private final EmployeeClient employeeClient;

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return repository.add(department);
    }

    @GetMapping("/")
    public List<Department> findAll() {
        log.info("Department findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        log.info("Department findById: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/organizations/{id}")
    public List<Department> findByOrganizationId(@PathVariable("id") Long id) {
        log.info("Department findByOrganizationId: organizationId={}", id);
        return repository.findByOrganizationId(id);
    }

    @GetMapping("/organizations/{id}/employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("id") Long id) {
        log.info("Department findByOrganizationWithEmployees: organizationId={}", id);
        List<Department> departments = repository.findByOrganizationId(id);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartmentId(d.getId())));
        return departments;
    }
}
