package com.springlearn.thymeleafdemo.controller;

import com.springlearn.thymeleafdemo.entity.Employee;
import com.springlearn.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        final List<Employee> allEmployees = employeeService.findAllEmployeeSortedByLastName();

        theModel.addAttribute("employees", allEmployees);

        return "employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAddingEmployee(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showPrepopulateFormForUpdate(@RequestParam("employeeId") int empId, Model theModel){
        Employee employee = employeeService.findEmployee(empId);
        theModel.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employees/list";
    }
}
