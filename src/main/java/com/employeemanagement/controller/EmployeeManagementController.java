package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employee;
import com.employeemanagement.model.Response;
import com.employeemanagement.service.EmployeeManagementService;

@RestController
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@RequestMapping(value = "/allemployees", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> employees = employeeManagementService.getAllEmployees();
		return new ResponseEntity(employees, HttpStatus.OK);

	}

	@RequestMapping(value = "/getemployee/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int emp_id) {

		Employee employee = employeeManagementService.getEmployeeById(emp_id);
		return new ResponseEntity(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {

		Response response = employeeManagementService.addEmployee(employee);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Response> deleteEmployeeById(@PathVariable("id") int emp_id) {

		Response response = employeeManagementService.deleteEmployeeById(emp_id);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateemployee", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {

		Response response = employeeManagementService.updateEmployeeById(employee);
		return new ResponseEntity(response, HttpStatus.OK);

	}
}
