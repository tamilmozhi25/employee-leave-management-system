package com.FirstProject.EmployeeLeaveApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.EmployeeLeaveApplication.model.LeaveRequest;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Long>{
	List<LeaveRequest> findEmployeeById(Long employeeid);
	List<LeaveRequest> findByStatus(LeaveRequest.LeaveStatus status);

}
