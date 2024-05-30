package com.github.yildizmy.client;

import com.github.yildizmy.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/organization/{id}")
    List<Department> findByOrganizationId(@PathVariable("id") Long id);

    @GetMapping("/organization/{id}/employees")
    List<Department> findByOrganizationIdWithEmployees(@PathVariable("id") Long id);
}
