package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RevokeLeave implements Serializable{
	
public Employee revokeLeave(Employee employee,Employee superEmployee) throws IOException
	
	{
		char choice=' ';
		LeaveStatus Revoke,Approve;
		if(superEmployee instanceof Lead)
		{
			Revoke = LeaveStatus.REVOKED_BY_LEAD;
		}
		else
		{
			Revoke = LeaveStatus.REVOKED;
		}
		
		
		List<LeaveDetails> UpdatedLeaveDetails = new ArrayList<>();
		Iterator<LeaveDetails> LeaveIterator = employee.leaveRecord.iterator();
		LeaveDetails tempLeaveRecords=null;
		while(LeaveIterator.hasNext())
		{
			
			tempLeaveRecords = (LeaveDetails) LeaveIterator.next();
			
			System.out.println("\n"+tempLeaveRecords.employeeID+"\n"+tempLeaveRecords.leaveType+"\n"+tempLeaveRecords.from.toString()+"\n"+tempLeaveRecords.to.toString());
			
			if(tempLeaveRecords.leaveStatus.equals(LeaveStatus.APPROVED_BY_LEAD.toString())||tempLeaveRecords.leaveStatus.equals(LeaveStatus.APROVED.toString()))
			{
				System.out.println("Do you want to revoke this leave (Press Y to Revoke) :");
				choice = week1.LeaveManagementSystem.bff.readLine().charAt(0);
				if(choice=='y'||choice=='Y')
				{
				tempLeaveRecords.leaveStatus = Revoke.toString();
				int addLeave = tempLeaveRecords.numberOfLeaves + employee.leaveDetails.get(tempLeaveRecords.leaveType);
				employee.leaveDetails.replace(tempLeaveRecords.leaveType, addLeave);
			}
				else
				{
					System.out.println("Didn't Revoked\n");
				}
			}
		UpdatedLeaveDetails.add(tempLeaveRecords);	
		}
		
		employee.leaveRecord = UpdatedLeaveDetails;
		return employee;
	}


}
