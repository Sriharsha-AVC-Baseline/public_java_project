package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public abstract class Employee implements Serializable{
	
	public String employeeName;
	public String employeeAddress;
	public long employeePhoneNumber;
	public String employeeMail;
	public Date employeeDateOfBirth;
	public String employeeid;
	private String emplpassword;
	public String designation;
	public Map<String,Integer> leaveDetails = new LinkedHashMap<String,Integer>();
	public List<LeaveDetails> leaveRecord = new ArrayList<>();
	
	public String getEmplpassword() {
		return emplpassword;
	}

	public void setEmplpassword(String emplpassword) {
		this.emplpassword = emplpassword;
	}
	
	
	
	

	public abstract void employeeLogin(List<Employee> l)throws NumberFormatException, IOException,Exception;
	
	public void requestLeave() throws Exception
	{
		this.leaveRecord = new RequestLeave().requestLeave(this);
	}
	public void cancelLeave() throws Exception
	{
		this.leaveRecord = new CancelLeave().cancelLeave(this);
	}
	public void checkMyLeaves()
	{
		new CheckMyLeaves().displayLeavesRecords(this);
	}
	public void checkMyLeaveRecords()
	{
		new CheckMyLeaves().displayLeavesLeft(this);
	}
	public void availLeave() throws IOException
	{
		this.leaveRecord = new AvailLeave().availLeaveForApprovedLeaves(this);
	}
	
}