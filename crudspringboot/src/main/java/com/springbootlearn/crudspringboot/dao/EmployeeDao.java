package com.springbootlearn.crudspringboot.dao;

import com.springbootlearn.crudspringboot.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAllEmployee();

    public Employee findEmployee(int employeeId);

    public void save(Employee employee);

    public void delete(int employeeId);

}
