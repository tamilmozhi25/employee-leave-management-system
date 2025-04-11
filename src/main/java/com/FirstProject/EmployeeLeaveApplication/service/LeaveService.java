package com.FirstProject.EmployeeLeaveApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FirstProject.EmployeeLeaveApplication.model.LeaveRequest;
import com.FirstProject.EmployeeLeaveApplication.repository.LeaveRepository;

@Service
public class LeaveService {
	@Autowired
	private LeaveRepository  leaverepository;
	
	
	public LeaveRequest applyLeave(LeaveRequest leave)
	{
		leave.setStatus(LeaveRequest.LeaveStatus.PENDING);
		return leaverepository.save(leave);
	}
	
	public List<LeaveRequest> getLeaveHistory(Long employeeid)
	{
		return leaverepository.findEmployeeById(employeeid);
	}
	
	public List<LeaveRequest> gettAllPendingRequest()
	{
		return leaverepository.findByStatus(LeaveRequest.LeaveStatus.PENDING);
	}
	
	public LeaveRequest updateLeaveStatus(Long leaveid,LeaveRequest.LeaveStatus status)
	{
		LeaveRequest leaveUpdateStatus=leaverepository.findById(leaveid).orElse(null);
		if(leaveUpdateStatus != null)
		{
			leaveUpdateStatus.setStatus(status);
			return leaverepository.save(leaveUpdateStatus);
		}
		return null;
	}

}