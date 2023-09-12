package week1;

import java.io.Serializable;
import java.util.List;
import week1.LeaveManagementSystem;
public class Executive extends Employee implements Serializable{
	
	
	public Employee myLead;
	public Employee myManager;
	@Override
	public void employeeLogin(List<Employee> l) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome "+this.employeeName+" You are logged in as Executive\n Your Lead : "+this.myLead.employeeName+" Your Manager is "+this.myManager.employeeName);
	
		while(true)
		{
			try {
		System.out.println("1. Request Leave\n2. Cancel Leave\n3. Avail Leave\n4. Check my Leaves\n5. CheckLeaveRecords\n6. Logout");
		int choice = Integer.parseInt(week1.LeaveManagementSystem.bff.readLine());
		switch(choice)
		{
		case 1:this.requestLeave();break;
		case 2:this.cancelLeave();break;
		case 3:this.availLeave();break;
		case 4:this.checkMyLeaves();break;
		case 5:this.checkMyLeaveRecords();break;
		case 6:System.out.println("Logged out");return;
		default:System.out.println("Invalid Choice");break;
		}
	}
	catch(RuntimeException re)
			{
		System.out.println("Enter valid Choice\n");
			}
	}
	}
}
