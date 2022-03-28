package com.example.demo.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	// Fields
	@Id
	@GeneratedValue
	private int empId;
	
	@NotNull(message="Name shouldn't be empty")
	@Size(min=3, max=50, message="Min 3 characters required")
	private String empName;

	@Size(min=10, max=10, message="Provide 10 digit contact number")
	private String contactNo;

	@DecimalMax(value="100000", message="Salary shouldn't be greater than 100000")
	private  double salary; //0.0
	
	@Past
	//@FutureOrPresent
	//@Future
	private LocalDate dob;
	
	@Email(message="Enter valid email address")
	private String email;
	
	@URL(message="Enter valid url")
	//"url": "https://www.google.com"
	private String url;

	
	

}
