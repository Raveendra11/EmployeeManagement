package com.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employeemanagement.model.ErrorResponse;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(EmployeeManagementException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeManagementException(EmployeeManagementException exception){
		ErrorResponse errorResponse = new ErrorResponse(500,exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoDataFoundException(NoDataFoundException exception){
		ErrorResponse errorResponse = new ErrorResponse(404,exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleEmployeeManagementException(Exception exception){
		ErrorResponse errorResponse = new ErrorResponse(500,exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
