package io.webservices.service;

import io.webservices.entity.Employee;
import io.webservices.exception.BadRequestException;
import io.webservices.exception.EmployeeNotFoundException;
import io.webservices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
       return (List<Employee>) repository.findAll();

    }

    @Override
    public Employee findOne(String id) {
       Optional<Employee> employee =  repository.findById(id);
       if(!employee.isPresent()){
           throw new EmployeeNotFoundException("No Employee with ID "+id+ "NOT FOUND");
       }else{
           return employee.get();
       }
    }
    @Override
    @Transactional
    public Employee create(Employee emp) {
        Optional<Employee> existing_employee = repository.findByEmailId(emp.getEmailId());
        if (existing_employee.isPresent()){
            throw new BadRequestException("Employee with email "+emp.getEmailId()+"  Already Exists");
        }
        return repository.save(emp);

    }

    @Override
    @Transactional
    public Employee update(String empId, Employee emp) {
        Optional<Employee> existing_employee = repository.findById(empId);
        if (!existing_employee.isPresent()){
            throw new EmployeeNotFoundException("No Employee with ID "+empId+ "NOT FOUND");
        }
        return repository.save(emp);
    }

    @Override
    @Transactional
    public void delete(String empId) {
        Optional<Employee> existing_employee = repository.findById(empId);
        if (!existing_employee.isPresent()){
            throw new EmployeeNotFoundException("No Employee with ID "+empId+ "NOT FOUND");
        }
        repository.delete(existing_employee.get());

    }
}
