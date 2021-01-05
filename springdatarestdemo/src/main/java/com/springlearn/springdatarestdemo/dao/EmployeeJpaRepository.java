package com.springlearn.springdatarestdemo.dao;

import com.springlearn.springdatarestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//change the api end point to members from employees
//@RepositoryRestResource(path = "members")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
