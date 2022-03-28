package com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		super();
		
	}

	public EmployeeNotFoundException(String message) {
		super(message);

	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);

	}

	
}
