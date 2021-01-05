package com.springbootlearn.crudspringboot.dao;

import com.springbootlearn.crudspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
