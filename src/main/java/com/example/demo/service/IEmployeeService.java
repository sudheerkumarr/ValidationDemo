package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Employee;


public interface IEmployeeService {
	// get all employees
	List<Employee> getAllEmployees();
	//get emp based on id
	Employee getEmpById(int id);
	// get emp based on name
	Employee getEmpByName(String name);
	// add emp
	Employee addEmployee(Employee emp);
	// update employee
	Employee updateEmployee(Employee employee);
	// delete employee
	Employee deleteEmpById(int id);
	void deleteEmp(int id);
	// update emp name
	Employee updateEmpByName(int empId, String name);
	// update emp salary
	Employee updateEmpSalary(int id, double salary);

	
}
