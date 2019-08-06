package com.dbs.empmgmt.dao;

import com.dbs.empmgmt.model.Employee;
import com.mysql.cj.protocol.Resultset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository("h2Dao")
public class H2EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public H2EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee save(Employee employee) {
    	this.jdbcTemplate.execute("insert into employee values ("+employee.getId()+",'"+employee.getName()+"','"+employee.getDateOfBirth()+"','"+employee.getDepartmentName()+"')");    	return employee;
    }

    @Override
    public Employee update(long empId, Employee employee) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        String fetchAllQuery = "select * from employee";
        List<Employee>empList = this.jdbcTemplate.query(fetchAllQuery, (resultSet,num) -> new Employee(resultSet.getString("name"), resultSet.getDate("dateofbirth").toLocalDate(), resultSet.getString("department")));
        return empList;
    }

    @Override
    public Employee findById(long id) {
    	String query = "select * from employee where id = " + id;
        Employee employee = this.jdbcTemplate.queryForObject(query, (resultSet, i) -> new Employee( resultSet.getString("name"), resultSet.getDate("dateofbirth").toLocalDate(), resultSet.getString("department")));
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
    	String query = "delete from employee where id = " + id;
    	int count = this.jdbcTemplate.update(query);
    	System.out.println(count + " row(s) deleted...");
    }
}