package com.copy.demo.service;

import com.copy.demo.model.Employee;
import com.copy.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Transactional
    public List<Employee> findAll()
    {
        return employeeRepo.findAll();
    }

    @Transactional
    public Employee saveEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    @Transactional
    public void deleteAllEmployeeByName(String name)
    {
        employeeRepo.deleteAllByName(name);
    }
}
