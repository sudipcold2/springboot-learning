package com.springbootlearn.crudspringboot.dao;

import com.springbootlearn.crudspringboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployee() {

        Session session = entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = employeeQuery.getResultList();

        return employees;

    }

    @Override
    public Employee findEmployee(int employeeId) {

        Session session  = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, employeeId);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int employeeId) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId", employeeId);

        query.executeUpdate();

    }
}
