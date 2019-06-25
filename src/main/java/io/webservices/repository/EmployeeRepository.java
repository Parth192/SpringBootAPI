package io.webservices.repository;

import io.webservices.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Employee> findByEmailId(String email);
}
