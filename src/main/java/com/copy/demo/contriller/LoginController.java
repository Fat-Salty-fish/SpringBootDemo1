package com.copy.demo.contriller;


import com.copy.demo.model.Employee;
import com.copy.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login")
    public void saveAndGet()
    {
        Employee employee = new Employee();
        employee.setName("李忠杰");
        employee.setAddress("hubei");
        employee.setDepartment("hubeifengongsi");
        employeeService.saveEmployee(employee);
        System.out.println(employeeService.findAll());
        System.out.println("即将进行删除");
        employeeService.deleteAllEmployeeByName("lzj");
        return ;
    }

}
