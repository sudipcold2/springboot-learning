package com.springbootlearn.crudspringboot.service;

import com.springbootlearn.crudspringboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAllEmployee();

    public Employee findEmployee(int employeeId);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int employeeId);
}
