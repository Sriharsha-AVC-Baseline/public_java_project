package week1;

import java.io.Serializable;

public class CheckMyLeaves implements Serializable{
	
	public void displayLeavesRecords(Employee e)
	{
		e.leaveDetails.forEach((k,V)->System.out.println(k+" "+V+" days Left"));
	}
	public void displayLeavesLeft(Employee employee)
	{
		employee.leaveRecord.stream().forEach(e->System.out.println("\n"+e.employeeID+"\n"+e.from.toString()+"\n"+e.to.toString()+"\nFor "+e.numberOfLeaves+"days\n"+e.leaveType+"\n"+e.leaveStatus+"\n"));
	}

}
