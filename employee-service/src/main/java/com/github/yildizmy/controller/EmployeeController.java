package com.github.yildizmy.controller;

import com.github.yildizmy.model.Employee;
import com.github.yildizmy.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "EmployeeController")
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        log.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        log.info("Employee findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        log.info("Employee findById: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/departments/{id}")
    public List<Employee> findByDepartmentId(@PathVariable("id") Long id) {
        log.info("Employee findByDepartmentId: departmentId={}", id);
        return repository.findByDepartmentId(id);
    }

    @GetMapping("/organizations/{id}")
    public List<Employee> findByOrganizationId(@PathVariable("id") Long id) {
        log.info("Employee findByOrganizationId: organizationId={}", id);
        return repository.findByOrganizationId(id);
    }
}
