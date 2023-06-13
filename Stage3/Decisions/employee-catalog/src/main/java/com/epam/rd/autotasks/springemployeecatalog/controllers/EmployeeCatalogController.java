package com.epam.rd.autotasks.springemployeecatalog.controllers;

import com.epam.rd.autotasks.springemployeecatalog.dao.EmployeeCatalogDAO;
import com.epam.rd.autotasks.springemployeecatalog.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeCatalogController {

    @Autowired
    private EmployeeCatalogDAO employeeCatalogDAO;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(@RequestParam("page") Optional<Integer> page
                                ,@RequestParam("size") Optional<Integer> size
                                ,@RequestParam("sort") Optional<String> sortByValue){
        return employeeCatalogDAO.getEmployeesList(page,size,sortByValue);
    }

    @GetMapping("/employees/{employee_id}")
    public Employee getEmployeeById(@PathVariable("employee_id") int id
                                   ,@RequestParam("full_chain") Optional<Boolean> fullChain){
        return employeeCatalogDAO.getEmployeeById(id,fullChain);
    }

    @GetMapping("/employees/by_manager/{managerId}")
    public List<Employee> getAllEmployeeByManagerId(@PathVariable("managerId") int managerId
            , @RequestParam("page") int page,@RequestParam("size") int size
            ,@RequestParam("sort") String sortByValue){
        return employeeCatalogDAO.getEmployeesByManagerId(managerId, page, size, sortByValue);
    }

    @GetMapping("/employees/by_department/{departmentIdOrDepartmentName}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("departmentIdOrDepartmentName") String departmentByValue
            , @RequestParam("page") int page,@RequestParam("size") int size
            ,@RequestParam("sort") String sortByValue){
         return employeeCatalogDAO.getEmployeeByDepartment(departmentByValue, page, size, sortByValue);
    }
}
