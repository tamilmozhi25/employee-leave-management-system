package com.FirstProject.EmployeeLeaveApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.EmployeeLeaveApplication.model.Employee;
import com.FirstProject.EmployeeLeaveApplication.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeservice;
	@GetMapping
	public ResponseEntity<List<Employee>>  getAllEmployee()
	{
		List<Employee> employees = employeeservice.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		Employee employee=employeeservice.getEmployeeById(id);
		if(employee != null)
		{
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	@PostMapping
	public ResponseEntity<Employee>  addEmployee(@RequestBody Employee emp)
	{
		Employee newEmployee=employeeservice.addEmployee(emp);
		return new ResponseEntity<Employee>(newEmployee,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee NewEmp)
	{
		Employee updateEmployee=employeeservice.updateEmployeeById(id, NewEmp);
		if(updateEmployee!=null)
		{
			return new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id)
	{
		
		employeeservice.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
