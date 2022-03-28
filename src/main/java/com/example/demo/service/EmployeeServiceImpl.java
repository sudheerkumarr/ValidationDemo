package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with given id "+id);
		}
		return opt.get();
	}

	@Override
	public Employee getEmpByName(String name) {
		
		return empRepo.findByEmpName(name);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// Convert Employee to Employee Dto
		Employee emp = empRepo.save(employee);
		// return EmployeeDto
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// Check given emp is there in db or not
				
		Optional<Employee> opt = empRepo.findById(employee.getEmpId());
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with given id "+employee.getEmpId());
		}
		return empRepo.save(employee);
		
	}

	@Override
	public Employee deleteEmpById(int id) {
		// Check given emp is there in db or not
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with given id "+ id);
		}
		// delete emp
		empRepo.deleteById(id);
		return opt.get();
		
	}

	@Override
	public Employee updateEmpByName(int empId, String name) {
		// Check given emp is there in db or not
				
				Optional<Employee> opt = empRepo.findById(empId);
				if(!opt.isPresent()) {
					throw new EmployeeNotFoundException("Employee not found with given id "+ empId);
				}
				opt.get().setEmpName(name);
				empRepo.save(opt.get());
				return opt.get();
		
	}

	@Override
	public Employee updateEmpSalary(int id, double salary) {
		
		return null;
	}

	@Override
	public void deleteEmp(int empId) {
		// TODO Auto-generated method stub
		Optional<Employee> opt = empRepo.findById(empId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with given id "+ empId);
		}
		empRepo.deleteById(empId);
		
	}
	
	
}
