package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.bean.Employee;
import com.example.demo.repository.IEmployeeRepository;

@ExtendWith(SpringExtension.class)
class EmployeeServiceMockitoTest {

	// @InjectMock - Creates instance of a class and injects mocks that are created
	// with @Mock

		@InjectMocks
		EmployeeServiceImpl empService;

		// @MockBean - Creates Mock of a class or interface

		@MockBean
		IEmployeeRepository empRepo;

		// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
	
		
		@Test
		void deleteEmpById() {
			int id = 10;
			Employee emp = new Employee(10, "Raj", "9999911111", 20000.0, LocalDate.parse("1999-10-28"), "raj@gmail.com", "http://www.google.com");
		
			// Return emp
			Mockito.when(empRepo.findById(10)).thenReturn(Optional.of(emp));
			
			// Handling void methods
			Mockito.doNothing().when(empRepo).deleteById(10);
			
			// delete emp
			empService.deleteEmp(id);
		}
		
		
		
}
