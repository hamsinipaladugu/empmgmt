package com.dbs.empmgmt.client;

import com.dbs.empmgmt.controller.EmployeeController;
import com.dbs.empmgmt.model.BankAccount;
import com.dbs.empmgmt.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.time.LocalDate;

public class EmpManagementClient {

	private static EmployeeController employeeController;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		employeeController = applicationContext.getBean(EmployeeController.class);
		saveEmployees();
		//listAllEmployees();
		//fetchEmployeeDetailsById(12);
	}

	private static void listAllEmployees() {
		employeeController.listAll().forEach(System.out::println);
	}
	
	private static void fetchEmployeeDetailsById(int i) {
        System.out.println("Employee with id "+i +" is " +employeeController.findById(i));
    }

	private static void saveEmployees() {
		Employee employee = new Employee("Harish", LocalDate.of(1985, 5, 25), "MOT");
		BankAccount account1 = new BankAccount();
	    account1.setPan("AOY45GG88M");
	    account1.setAccountBalance(5_000);
	    BankAccount account2 = new BankAccount();
	    account2.setPan("AOY45GG88N");
	    account2.setAccountBalance(15_000);

	    employee.addBankAccount(account1);
	    employee.addBankAccount(account2);
		employeeController.saveEmployee(employee);
		
		
	}
}

    

