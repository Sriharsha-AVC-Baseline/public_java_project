package week1;

import java.io.Serializable;
import java.util.Date;

public class LeaveDetails implements Serializable{
	String employeeID;
	String leaveType;
	String leaveStatus;
	Date from;
	Date to;
	int numberOfLeaves;
	public int getNumberOfLeaves() throws Exception
	{
		this.numberOfLeaves =  new GetDate().differenceBetweenDates(this.from, this.to);
		return this.numberOfLeaves;
	}
}
