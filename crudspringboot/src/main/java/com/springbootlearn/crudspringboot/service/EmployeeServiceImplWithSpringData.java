package com.springbootlearn.crudspringboot.service;

import com.springbootlearn.crudspringboot.dao.EmployeeJpaRepository;
import com.springbootlearn.crudspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplWithSpringData implements EmployeeService {
    
    @Autowired
    EmployeeJpaRepository repository;
    
    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployee(int employeeId) {
        Employee theEmployee = null;
        Optional<Employee> result = repository.findById(employeeId);

        if(result.isPresent()){
            theEmployee = result.get();
        }

        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        repository.deleteById(employeeId);
    }
}
