package com.github.yildizmy.client;

import com.github.yildizmy.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/department/{id}")
    List<Employee> findByDepartmentId(@PathVariable("id") Long id);
}
