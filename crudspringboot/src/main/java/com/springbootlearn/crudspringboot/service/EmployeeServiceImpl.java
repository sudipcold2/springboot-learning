package com.springbootlearn.crudspringboot.service;

import com.springbootlearn.crudspringboot.dao.EmployeeDao;
import com.springbootlearn.crudspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    @Qualifier("employeeDaoWithJpa")
    EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<Employee> findAllEmployee() {
        List<Employee> allEmployee = employeeDao.findAllEmployee();
        return allEmployee;
    }

    @Override
    @Transactional
    public Employee findEmployee(int employeeId) {
        Employee employee = employeeDao.findEmployee(employeeId);
        return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDao.delete(employeeId);
    }
}
