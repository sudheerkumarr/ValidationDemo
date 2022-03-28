package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService empServ;
		
	// get all employees
	@GetMapping("/employees")
	List<Employee> getAllEmployees() {
		return empServ.getAllEmployees();
	}
	
	// get emp based on id
	@GetMapping("/employees/{id}")
	Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmpById(empId);
		
	}
	
	// add emp
	@PostMapping("/employees")
	ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
		Employee newEmp =  empServ.addEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	// delete employee
	@DeleteMapping("/employees/{id}")
	ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
		Employee deletedEmp = empServ.deleteEmpById(id);
		return new ResponseEntity<>(deletedEmp, HttpStatus.OK); // 200 Ok
	}
	
	// update employee
	@PutMapping("/employees")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee updatedEmp = empServ.updateEmployee(emp);
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK); // 200 Ok
	}
	// update emp name
	@PatchMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmpName(@PathVariable("id") int empId, @RequestBody String name) {
		Employee emp = empServ.updateEmpByName(empId, name);
		return new ResponseEntity<>(emp, HttpStatus.OK); // 200 Ok
		
	}
	// update emp salary
	
	// get emp based on name
	@GetMapping("/employees/byName/{name}")
	ResponseEntity<Employee> getEmpByName(@PathVariable("name") String empName) {
		Employee emp = empServ.getEmpByName(empName);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

}
