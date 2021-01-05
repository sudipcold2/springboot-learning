package com.springbootlearn.crudspringboot.dao;

import com.springbootlearn.crudspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoWithJpa implements EmployeeDao {

    EntityManager entityManager;

    @Autowired
    public EmployeeDaoWithJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployee() {
       Query query =  entityManager.createQuery("from Employee");
       List<Employee> employees = query.getResultList();
       return employees;
    }

    @Override
    public Employee findEmployee(int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());

    }

    @Override
    public void delete(int employeeId) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", employeeId);
        query.executeUpdate();

    }
}
