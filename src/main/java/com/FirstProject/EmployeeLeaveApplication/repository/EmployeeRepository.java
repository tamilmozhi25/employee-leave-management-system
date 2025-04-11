package com.FirstProject.EmployeeLeaveApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.EmployeeLeaveApplication.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
