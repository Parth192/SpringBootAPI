package io.webservices.controller;

import io.webservices.entity.Employee;

import io.webservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Employee> findAll(){
        return service.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee findOne(@PathVariable("id") String empid){
        return  service.findOne(empid);
    }


    @RequestMapping(method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee create(@RequestBody Employee employee){

        return service.create(employee);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee update(@PathVariable("id") String empid, @RequestBody Employee employee){
        return service.update(empid, employee);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String empid){
        service.delete(empid);
    }
}
