package com.dbs.empmgmt.service;

import java.util.List;

import com.dbs.empmgmt.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> listAll();

	Employee findById(long empId);

	void deleteEmployee(long empId);

}
