package com.example.demo.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmployeeErrorResponse {

	private int status;
	private String message;
	//private long timeStamp;
	private LocalDateTime timeStamp;

}
