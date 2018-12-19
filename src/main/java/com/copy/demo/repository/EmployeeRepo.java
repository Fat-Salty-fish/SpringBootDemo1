package com.copy.demo.repository;

import com.copy.demo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    //查询所有信息
    public List<Employee> findAll();

    //储存
    public Employee save(Employee employee);

    //根据名字进行删除
    public void deleteAllByName(String name);
}
