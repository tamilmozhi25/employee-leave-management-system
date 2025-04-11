package com.FirstProject.EmployeeLeaveApplication.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name ="leaverequest")
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeid;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private String leaveType;
	
	@Enumerated(EnumType.STRING)
	private LeaveStatus status;
	
	public enum LeaveStatus {
		PENDING,
		APPROVED,
		REJECTED
	}
	
	public Long getId()
	{
		return id;
	}
	//---------------------------------------------
	public Long getEmployeeid()
	{
		return employeeid;
	}
	public void setEmployeeid(Long employeeid)
	{
		this.employeeid=employeeid; 
	}
	//---------------------------------------------
	public LocalDate getFromDate()
	{
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate)
	{
		this.fromDate=fromDate;
	}
	//---------------------------------------------
	public LocalDate getToDate()
	{
		return toDate;
	}
	public void setToDate(LocalDate toDate)
	{
		this.toDate = toDate;
	}
	//---------------------------------------------
	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	//---------------------------------------------
	public String getLeaveType()
	{
		return leaveType;
	}
	public void setLeaveType(String leaveType)
	{
		this.leaveType=leaveType;
	}
	//---------------------------------------------
	public LeaveStatus getStatus()
	{
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status=status;
	}
}
