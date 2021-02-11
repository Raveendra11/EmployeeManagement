package com.employeemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employeemanagement.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("emp_id"));
		employee.setEmpName(rs.getString("emp_name"));
		employee.setEmpDesignation(rs.getString("emp_designation"));
		employee.setEmpSalary(rs.getDouble("emp_salary"));
		return employee;

	}

}
