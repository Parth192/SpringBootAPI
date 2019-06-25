package io.webservices.service;

import io.webservices.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findOne(String id);


    Employee create(Employee emp);

    Employee update(String empId, Employee emp);

    void delete(String empId);
}
