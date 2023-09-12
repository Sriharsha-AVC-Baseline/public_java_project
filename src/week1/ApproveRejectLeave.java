package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import week1.LeaveManagementSystem;
public class ApproveRejectLeave implements Serializable{
	
	public Employee approveRejectLeave(Employee employee,Employee superEmployee) throws IOException
	
	{
		char choice=' ';
		LeaveStatus Reject,Approve;
		if(superEmployee instanceof Lead)
		{
			Reject = LeaveStatus.REJECTED_BY_LEAD;
			Approve = LeaveStatus.APPROVED_BY_LEAD;
		}
		else
		{
			Reject = LeaveStatus.REJECTED;
			Approve = LeaveStatus.APROVED;
		}
		
		
		List<LeaveDetails> UpdatedLeaveDetails = new ArrayList<>();
		Iterator<LeaveDetails> LeaveIterator = employee.leaveRecord.iterator();
		LeaveDetails tempLeaveRecords=null;
		while(LeaveIterator.hasNext())
		{
			
			tempLeaveRecords = (LeaveDetails) LeaveIterator.next();
			
			System.out.println("\n"+tempLeaveRecords.employeeID+"\n"+tempLeaveRecords.leaveType+"\n"+tempLeaveRecords.from.toString()+"\n"+tempLeaveRecords.to.toString());
			
			if(tempLeaveRecords.leaveStatus.equals(LeaveStatus.PENDING.toString()))
			{
				
				if(tempLeaveRecords.leaveType.equals(LeaveTypes.CASUAL_LEAVE.toString()) && tempLeaveRecords.numberOfLeaves>2)
				{
					System.out.println("Casual leaves cannot be approved for more than two days Sorry!!!!\n");
					tempLeaveRecords.leaveStatus = Reject.toString();
				}
				
				else if(tempLeaveRecords.leaveType.equals(LeaveTypes.DUTY_LEAVE.toString()))
				{
					System.out.println("Duty Leave Approved by Default\n");
					tempLeaveRecords.leaveStatus = Approve.toString();
				}
				else {
					
					if(tempLeaveRecords.numberOfLeaves > employee.leaveDetails.get(tempLeaveRecords.leaveType))
					{
						System.out.println("Requested Leave is more than your balance,Sorry no leave approved");
						tempLeaveRecords.leaveStatus = Reject.toString();
					}
					else {
					System.out.println("Do You want to approve or Reject this Leave y/n\n");
					choice = week1.LeaveManagementSystem.bff.readLine().charAt(0);
					if(choice == 'y' || choice=='Y')
					{
						tempLeaveRecords.leaveStatus = Approve.toString();
						int totalLeaves = employee.leaveDetails.get(tempLeaveRecords.leaveType);
						employee.leaveDetails.replace(tempLeaveRecords.leaveType,(totalLeaves - tempLeaveRecords.numberOfLeaves) );
						System.out.println(tempLeaveRecords.leaveType+" has been approved for "+tempLeaveRecords.numberOfLeaves+" days");
					}
					
					else 
					{
						tempLeaveRecords.leaveStatus = Reject.toString();
						System.out.println(tempLeaveRecords.leaveType+" has been Rejected ");
					}
					}
				}
			}
		UpdatedLeaveDetails.add(tempLeaveRecords);	
		}
		
		employee.leaveRecord = UpdatedLeaveDetails;
		return employee;
	}

}
