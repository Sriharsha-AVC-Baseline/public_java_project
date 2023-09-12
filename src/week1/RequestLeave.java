package week1;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;



import week1.LeaveManagementSystem;
public class RequestLeave implements Serializable{
	
	public List<LeaveDetails> requestLeave(Employee e) throws Exception
	{
		LeaveDetails thisLeave = new LeaveDetails();
		String from,to;
		int ifLeaveAlreadyAvailed = 0;
		System.out.println("\nSelect the type of leave you want to request");
		LeaveTypes leaves[] = LeaveTypes.values();
		for(int i=0;i<leaves.length;i++)
		{
			System.out.println((i+1)+". "+leaves[i].toString());
		}
		int leaveChoice = Integer.parseInt(week1.LeaveManagementSystem.bff.readLine());
		if(e.leaveDetails.get(leaves[leaveChoice-1].toString()) < 1 && !(leaves[leaveChoice-1].toString()).equals(LeaveTypes.DUTY_LEAVE.toString()))
				{
				System.out.println("Sorry No Leaves left");
				return e.leaveRecord;
				}
		else
		{
			while(true)
			{
			try {
		thisLeave.employeeID = e.employeeid;
		System.out.println("From");
		thisLeave.leaveType = leaves[leaveChoice-1].toString();
		thisLeave.from = new GetDate().readDate();
		System.out.println("To");
		thisLeave.to = new GetDate().readDate();
		Iterator<LeaveDetails> leaveDetailsIterator = e.leaveRecord.iterator();
		while(leaveDetailsIterator.hasNext())
		{
			LeaveDetails tempLeaveDetails = (LeaveDetails) leaveDetailsIterator.next();
			if(tempLeaveDetails.from.equals(thisLeave.from) && tempLeaveDetails.to.equals(thisLeave.to) && tempLeaveDetails.leaveStatus.equals(LeaveStatus.AVAILED.toString()))
			{
				System.out.println("Leave already availed on this date");
				ifLeaveAlreadyAvailed=1;
				break;
			}
		}
		if(ifLeaveAlreadyAvailed==1)
		{
			ifLeaveAlreadyAvailed=0;
			continue;
		}
		
		thisLeave.numberOfLeaves = new GetDateDifference().differenceBetweenDates(thisLeave.from, thisLeave.to);
		thisLeave.leaveStatus = LeaveStatus.PENDING.toString();
		e.leaveRecord.add(thisLeave);
		return e.leaveRecord;
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
		}
		}
		
		
	}

}
