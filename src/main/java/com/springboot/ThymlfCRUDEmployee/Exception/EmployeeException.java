package com.springboot.ThymlfCRUDEmployee.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeException {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public String nosuchEmployee() {
		return "Exception";
	}
}
