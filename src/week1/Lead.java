package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import week1.LeaveManagementSystem;

public class Lead extends Employee implements HigherManagement, Serializable{
	
	Employee myManager;

	@Override
	public void employeeLogin(List<Employee> l) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int choice;
		while(true)
		{
			try {
			System.out.println("1.Approve / Reject Leaves\n2.Revoke Leave\n3.Apply Leave\n4.Cancel Leave\n5.Avail Leave\n6 Check Leave Balance\n7.Check my Leave Records\nLog Out\nEnter Your Choice");
			choice = Integer.parseInt(week1.LeaveManagementSystem.bff.readLine());
			switch(choice)
			{
			case 1:approveRejectLeave(l);break;
			case 2:revokeLeave(l);break;
			case 3:requestLeave();break;
			case 4:cancelLeave();break;
			case 5:availLeave();break;
			case 6:checkMyLeaves();break;
			case 7:checkMyLeaveRecords();break;
			case 8:System.out.println("Logged out");return;
			default:System.out.println("Enter valid Choice\n");break;
			}
		}
			catch(RuntimeException re)
			{
				System.out.println("Enter Valid Expression");
			}
		}
		
	}

	@Override
	public List<Employee> approveRejectLeave(List<Employee> list) throws IOException {
		// TODO Auto-generated method stub
		Iterator<Employee> employeeIteator = list.iterator();
		List<Employee> updatedleaves = new ArrayList<Employee>();
		while(employeeIteator.hasNext())
		{
			Employee tempEmployee = (Employee)employeeIteator.next();
			if(tempEmployee instanceof Executive)
			{
			Executive tempoExecutive = (Executive)tempEmployee;
			if(tempoExecutive.myLead.employeeid.equals(this.employeeid))
			{
				
				tempoExecutive = (Executive) new ApproveRejectLeave().approveRejectLeave(tempoExecutive,this);
				
			}
			}
			updatedleaves.add(tempEmployee);
		}
		return updatedleaves;
	}

	@Override
	public List<Employee> revokeLeave(List<Employee> list) throws IOException {
		
		Iterator<Employee> employeeIteator = list.iterator();
		List<Employee> updatedleaves = new ArrayList<Employee>();
		while(employeeIteator.hasNext())
		{
			Employee tempEmployee = (Employee)employeeIteator.next();
			if(tempEmployee instanceof Executive)
			{
			Executive tempoExecutive = (Executive)tempEmployee;
			if(tempoExecutive.myLead.employeeid.equals(this.employeeid))
			{
				
				tempoExecutive = (Executive) new RevokeLeave().revokeLeave(tempoExecutive,this);
				
			}
			}
			updatedleaves.add(tempEmployee);
		}
		return updatedleaves;
	}


}
