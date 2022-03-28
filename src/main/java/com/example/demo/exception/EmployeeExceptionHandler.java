package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.bean.EmployeeErrorResponse;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exception) {
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		//error.setTimeStamp(System.currentTimeMillis());
		error.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	
//	// Handling validation errors
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {
//		EmployeeErrorResponse error = new EmployeeErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exception.getMessage());
//		//error.setTimeStamp(System.currentTimeMillis());
//		error.setTimeStamp(LocalDateTime.now());
//		
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);  //400 Bad Request
//	}
	
	
	
//	@ExceptionHandler
//	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeFoundException exception) {
//		EmployeeErrorResponse error = new EmployeeErrorResponse();
//		
//		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
//		error.setMessage(exception.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);  //409 Conflict
//	}
	
}