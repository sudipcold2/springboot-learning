package com.springlearn.thymeleafdemo.service;

import com.springlearn.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public List<Employee> findAllEmployeeSortedByLastName();

    public Employee findEmployee(int employeeId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int employeeId);
}
