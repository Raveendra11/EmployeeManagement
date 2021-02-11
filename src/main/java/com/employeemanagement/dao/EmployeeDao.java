package com.employeemanagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.employeemanagement.exception.EmployeeManagementException;
import com.employeemanagement.exception.NoDataFoundException;
import com.employeemanagement.mapper.EmployeeRowMapper;
import com.employeemanagement.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final String INSERT_SQL = "insert into employees(emp_name,emp_designation,emp_salary) values(:emp_name,:emp_designation,:emp_salary)";
	private final String SELECT_SQL = "select * from employees";
	private final String SELECT_BY_ID_SQL = "select * from employees where emp_id=:emp_id";
	private final String DELETE_BY_ID_SQL = "delete from employees where emp_id=:emp_id";

	private final String UPDATE_BY_ID_SQL = "update employees set emp_name=:emp_name,emp_designation=:emp_designation,emp_salary = :emp_salary where emp_id=:emp_id";
	
	//Retrieve
	public List<Employee> getAllEmployees(){
		try {
		return namedParameterJdbcTemplate.query(SELECT_SQL, new EmployeeRowMapper());
		}
		catch (EmptyResultDataAccessException e) {
			throw new NoDataFoundException("There is no employee data found in the database.");
		}
		catch(DataAccessException exception) {
			throw new EmployeeManagementException("Failed to excute SQL query..Please check database connection or inputs.");
		}
		
	}
	
	//Retrieve by Id
	public Employee getEmployeeById(int emp_id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("emp_id", emp_id);
		try{
			return namedParameterJdbcTemplate.queryForObject(SELECT_BY_ID_SQL,parameters,new EmployeeRowMapper());
		}catch (EmptyResultDataAccessException e) {
			throw new NoDataFoundException("There is no employee found with that employee id ="+emp_id+".");
		}
		catch(DataAccessException exception) {
			exception.printStackTrace();
			throw new EmployeeManagementException("Failed to get the employee..Please check database connection or inputs.");
		}
	}
	
	//create
	
	public int addEmployee(Employee employee) {
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("emp_name", employee.getEmpName())
				.addValue("emp_designation", employee.getEmpDesignation())
				.addValue("emp_salary", employee.getEmpSalary());
	try{
		return	namedParameterJdbcTemplate.update(INSERT_SQL,parameters);
	}catch(DataAccessException exception) {
		exception.printStackTrace();
		throw new EmployeeManagementException("Failed to add employee..Please check database connection or inputs.");
	}
		
	//delete
	
	}
	public int deleteEmployeeById(int emp_id) {
		Map<String, Integer> parameters = new HashMap<String, Integer>();
		parameters.put("emp_id", emp_id);
		try{
			return namedParameterJdbcTemplate.update(DELETE_BY_ID_SQL,parameters);
		}catch(DataAccessException exception) {
			exception.printStackTrace();
			throw new EmployeeManagementException("Failed to delete employee..Please check database connection or inputs.");
		}
	}
	
	//update
public int updateEmployeeById(Employee employee) {
	
	SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("emp_name", employee.getEmpName())
			.addValue("emp_designation", employee.getEmpDesignation())
			.addValue("emp_salary", employee.getEmpSalary())
			.addValue("emp_id", employee.getEmpId());
	try{
		return namedParameterJdbcTemplate.update(UPDATE_BY_ID_SQL,parameters);
	}catch(DataAccessException exception) {
		exception.printStackTrace();
		throw new EmployeeManagementException("Failed to update employee..Please check database connection or inputs.");
	}
		
		

    }
}