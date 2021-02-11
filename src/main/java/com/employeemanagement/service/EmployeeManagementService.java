package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.dao.EmployeeDao;
import com.employeemanagement.model.Employee;
import com.employeemanagement.model.Response;


@Service
public class EmployeeManagementService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
		
	}
	
	public Employee getEmployeeById(int emp_id) {
		return employeeDao.getEmployeeById(emp_id);
	}
	
	public Response addEmployee(Employee employee) {
		
         int row =  employeeDao.addEmployee(employee);
         if(row ==1) {
 			return new Response("Employee added successfully");
 		}
 		else {
 			return new Response("Employee not added");
 		}
    }

	public Response deleteEmployeeById(int emp_id) {
		
        int row =  employeeDao.deleteEmployeeById(emp_id);
		if(row ==1) {
 			return new Response("Employee deleted successfully");
 		}
 		else {
 			//check whether employee Exist or not 
 			employeeDao.getEmployeeById(emp_id);
 			return new Response("Employee not deleted");
 		}
	}
	public Response updateEmployeeById(Employee employee) {
		
        int row = employeeDao.updateEmployeeById(employee);
        if(row ==1) {
 			return new Response("Employee updated successfully");
 		}
 		else {
 			//check whether employee Exist or not 
 			employeeDao.getEmployeeById(employee.getEmpId());
 			return new Response("Employee not updated");
 		}
	}

}
