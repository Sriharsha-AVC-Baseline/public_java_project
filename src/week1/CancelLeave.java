package week1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import week1.LeaveManagementSystem;
public class CancelLeave implements Serializable{
	
	public List<LeaveDetails> cancelLeave(Employee e) throws Exception
	{
		System.out.println("Select the leave Request to cancel");
		Iterator leaveRecordIterator = e.leaveRecord.iterator();
		List<LeaveDetails> updatedList = new ArrayList<>();
		LeaveDetails tempLeaveRecord=null;
		char choice=' ';
		while(leaveRecordIterator.hasNext())
		{
			tempLeaveRecord = (LeaveDetails)leaveRecordIterator.next();
			if(tempLeaveRecord.leaveStatus.equals(LeaveStatus.PENDING.toString()))
			{
				System.out.println("\n"+tempLeaveRecord.leaveType+"\n"+tempLeaveRecord.numberOfLeaves+" days\nFrom :"+tempLeaveRecord.from.toString()+"\nTo:"+tempLeaveRecord.to);
				System.out.println("Cancel this leave ? (Y/N)");
				choice = week1.LeaveManagementSystem.bff.readLine().charAt(0);
				if(choice=='y'||choice=='Y')
				{
					tempLeaveRecord.leaveStatus = LeaveStatus.CANCELLED.toString();
					System.out.println("Leave Cancelled");
				}
				
			}
			updatedList.add(tempLeaveRecord);
		}
		e.leaveRecord = updatedList;
		
		return e.leaveRecord;
		
	}


}
