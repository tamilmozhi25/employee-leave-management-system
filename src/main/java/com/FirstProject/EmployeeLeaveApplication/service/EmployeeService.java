package com.FirstProject.EmployeeLeaveApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FirstProject.EmployeeLeaveApplication.model.Employee;
import com.FirstProject.EmployeeLeaveApplication.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeerepository;
	
	public List<Employee> getAllEmployee()
	{
		return employeerepository.findAll();
	}
	
	public Employee getEmployeeById(Long id)
	{
		return employeerepository.findById(id).orElse(null);
	}
	
	public Employee addEmployee(Employee emp)
	{
		return employeerepository.save(emp);
	}
	
	public Employee updateEmployeeById(Long id, Employee NewEmp)
	{
		Employee emp1=getEmployeeById(id);
				
		if(emp1!=null)
		{
			emp1.setName(NewEmp.getName());
			emp1.setEmail(NewEmp.getEmail());
			emp1.setDepartment(NewEmp.getDepartment());
			return employeerepository.save(emp1);
		}
		return null;
	}
	
	public void deleteEmployeeById(Long id)
	{
		 employeerepository.deleteById(id);
	}

}
