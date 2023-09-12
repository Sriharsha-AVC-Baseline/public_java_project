package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import week1.LeaveManagementSystem;

public class AvailLeave implements Serializable{
	
	public List<LeaveDetails> availLeaveForApprovedLeaves(Employee employee) throws IOException
	{
		char choice;
		Iterator<LeaveDetails> leaveDetailsIterator = employee.leaveRecord.iterator();
		List<LeaveDetails> updatedLeaveDetails = new ArrayList<>();
		LeaveDetails tempRecords;
		while(leaveDetailsIterator.hasNext())
		{
			tempRecords = (LeaveDetails)leaveDetailsIterator.next();
			if(tempRecords.leaveStatus.equals(LeaveStatus.APPROVED_BY_LEAD.toString())||tempRecords.leaveStatus.equals(LeaveStatus.APROVED.toString()))
			{
				System.out.println("Want to avail the "+tempRecords.leaveType+" ? (Y/N)");
				choice = week1.LeaveManagementSystem.bff.readLine().charAt(0);
				if(choice=='y'||choice=='Y')
				{
				tempRecords.leaveStatus = LeaveStatus.AVAILED.toString();
				System.out.println(tempRecords.leaveType+" approved of "+tempRecords.numberOfLeaves);
				}
				
			}
			
			updatedLeaveDetails.add(tempRecords);
		}
		
		
		employee.leaveRecord = updatedLeaveDetails;
		
		return employee.leaveRecord;
		
	}

}
