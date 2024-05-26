package com.github.yildizmy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department {

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(Long organizationId, String name) {
        this.organizationId = organizationId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", organizationId=" + organizationId + ", name=" + name + "]";
    }
}
