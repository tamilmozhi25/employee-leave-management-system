package com.FirstProject.EmployeeLeaveApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.EmployeeLeaveApplication.model.LeaveRequest;
import com.FirstProject.EmployeeLeaveApplication.service.LeaveService;

@RestController
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveservice; 
	
	@PostMapping
	public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest leave)
	{
		LeaveRequest newLeave=leaveservice.applyLeave(leave);
		return new ResponseEntity<LeaveRequest>(newLeave,HttpStatus.CREATED);	
	}
	@GetMapping("/{employeeid}")
	public ResponseEntity<List<LeaveRequest>> getLeaveHistory(@PathVariable Long employeeid)
	{
		List<LeaveRequest> leaveHistory=leaveservice.getLeaveHistory(employeeid);
		return new ResponseEntity<List<LeaveRequest>>(leaveHistory, HttpStatus.OK);
	}
	@GetMapping("/pending")
	public ResponseEntity<List<LeaveRequest>> getAllPendingRequest()
	{
		List<LeaveRequest> pendingRequests = leaveservice.gettAllPendingRequest();
		return new ResponseEntity<List<LeaveRequest>>(pendingRequests, HttpStatus.OK);
	}
	@PutMapping("/status/{leaveid}")
	public ResponseEntity<LeaveRequest> updateLeaveStatus(@PathVariable Long leaveid,@RequestParam LeaveRequest.LeaveStatus status)
	{
		LeaveRequest statusUpdate = leaveservice.updateLeaveStatus(leaveid,status);
		if(statusUpdate!=null)
		{
			return new ResponseEntity<LeaveRequest>(statusUpdate, HttpStatus.OK);
		}
		return new ResponseEntity<LeaveRequest>(HttpStatus.NOT_FOUND);
	}
}
