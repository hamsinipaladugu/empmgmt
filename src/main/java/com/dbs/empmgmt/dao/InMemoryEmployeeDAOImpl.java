package com.dbs.empmgmt.dao;

import com.dbs.empmgmt.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("inMemory")
public class InMemoryEmployeeDAOImpl implements EmployeeDAO {

	private static final List<Employee> empList = new ArrayList<Employee>();

	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		empList.add(employee);
		System.out.println("Saved the employee in the in Memory list " + employee);
		return employee;
	}

	public Employee update(long empId, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmp = empList.stream().filter(emp -> emp.getId() == empId).findFirst();
		optionalEmp.ifPresent(employee1 -> empList.add(empList.indexOf(employee), employee));
		return employee;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empList;
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = empList.stream().filter(employee -> employee.getId() == id).findFirst();
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		return null;
	}

	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub

	}

}