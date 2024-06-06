package com.github.yildizmy.controller;

import com.github.yildizmy.client.DepartmentClient;
import com.github.yildizmy.client.EmployeeClient;
import com.github.yildizmy.model.Organization;
import com.github.yildizmy.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "OrganizationController")
@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationRepository repository;
    private final EmployeeClient employeeClient;
    private final DepartmentClient departmentClient;

    @PostMapping("/")
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return repository.add(organization);
    }

    @GetMapping("/")
    public List<Organization> findAll() {
        log.info("Organization findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        log.info("Organization findById: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/{id}/departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        log.info("Organization findByIdWithDepartments: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationId(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/departments/employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        log.info("Organization findByIdWithDepartmentsAndEmployees: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationIdWithEmployees(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        log.info("Organization findByIdWithEmployees: id={}", id);
        Organization organization = repository.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }
}
