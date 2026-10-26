package com.example.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.model.EmployeeLeave;

@Service
public class EmployeeLeaveService {

	 private List<EmployeeLeave> leaves = new ArrayList<>();

	    // GET all leaves
	    public List<EmployeeLeave> getAllLeaves() {
	        return leaves;
	    }

	    // GET leave by ID
	    public EmployeeLeave getLeaveById(int id) {
	        for (EmployeeLeave leave : leaves) {
	            if (leave.getEmployeeId() == id) {
	                return leave;
	            }
	        }
	        return null;
	    }

	    // POST
	    public EmployeeLeave addLeave(EmployeeLeave leave) {
	        leaves.add(leave);
	        return leave;
	    }

	    // PUT
	    public EmployeeLeave updateLeave(int id, EmployeeLeave updatedLeave) {
	        EmployeeLeave leave = getLeaveById(id);

	        if (leave != null) {
	            leave.setEmployeeName(updatedLeave.getEmployeeName());
	            leave.setLeaveType(updatedLeave.getLeaveType());
	            leave.setNumberOfDays(updatedLeave.getNumberOfDays());
	            leave.setReason(updatedLeave.getReason());
	        }

	        return leave;
	    }

	    // PATCH
	    public EmployeeLeave patchLeave(int id, EmployeeLeave updatedLeave) {
	        EmployeeLeave leave = getLeaveById(id);

	        if (leave != null) {

	            if (updatedLeave.getEmployeeName() != null) {
	                leave.setEmployeeName(updatedLeave.getEmployeeName());
	            }

	            if (updatedLeave.getLeaveType() != null) {
	                leave.setLeaveType(updatedLeave.getLeaveType());
	            }

	            if (updatedLeave.getNumberOfDays() > 0) {
	                leave.setNumberOfDays(updatedLeave.getNumberOfDays());
	            }

	            if (updatedLeave.getReason() != null) {
	                leave.setReason(updatedLeave.getReason());
	            }
	        }

	        return leave;
	    }

	    // DELETE
	    public boolean deleteLeave(int id) {
	        return leaves.removeIf(
	            leave -> leave.getEmployeeId() == id
	        );
	    }
}
