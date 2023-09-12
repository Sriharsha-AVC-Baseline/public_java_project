package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import week1.LeaveManagementSystem;
public class Manager extends Employee implements HigherManagement, Serializable{
	

	@Override
	public void employeeLogin(List<Employee> l) throws Exception {
		// TODO Auto-generated method stub
		int choice;
		System.out.println("Welcome "+this.employeeName);
		while(true)
		{
			try {
		System.out.println("\n1.Approve Leave\n2.Revoke Leave\n3.Generate Employee List\n4.Request Leave\n5.Cancel Leave\n6.Avail Leave\n7.Check my Leave Records\n8.Check Leave Balance\n9.Logout\nEnter Your Choice :");
		choice = Integer.parseInt(week1.LeaveManagementSystem.bff.readLine()); 
		switch(choice)
		{
		case 1:approveRejectLeave(l);break;
		case 2:revokeLeave(l);break;
		case 3:new GenerateEmployeeList().generateEmployeeList(l);break;
		case 4:requestLeave();break;
		case 5:cancelLeave();break;
		case 6:availLeave();break;
		case 7:checkMyLeaveRecords();break;
		case 8:checkMyLeaves();break;
		case 9:System.out.println("Logged out");return;
		default:System.out.println("Invalid Choice");break;
		}
		}
			catch(RuntimeException e)
			{
				System.out.println("Enter Valid Choice");
			}
		}
	}
	

	@Override
	public List<Employee> approveRejectLeave(List<Employee> list) throws IOException {
		// TODO Auto-generated method stub
		Iterator<Employee> employeeIteator = list.iterator();
		List<Employee> updatedLeaveEmployee = new ArrayList<>();
		while(employeeIteator.hasNext())
		{
			Employee typeOfEmployee = employeeIteator.next();
			if(typeOfEmployee instanceof Executive)
			{
			Executive tempoExecutive = (Executive)typeOfEmployee;
			if(tempoExecutive.myManager.employeeid.equals(this.employeeid))
			{
				
				tempoExecutive = (Executive) new ApproveRejectLeave().approveRejectLeave(tempoExecutive,this);
				
			}
				updatedLeaveEmployee.add(tempoExecutive);
			}
			else if(typeOfEmployee instanceof Lead)
			{
				Lead tempoLead = (Lead)typeOfEmployee;
				if(tempoLead.myManager.employeeid.equals(this.employeeid))
				{
					
					tempoLead = (Lead) new ApproveRejectLeave().approveRejectLeave(tempoLead,this);
					
				}
				updatedLeaveEmployee.add(tempoLead);
			}
			
			
		}
		
		return updatedLeaveEmployee;
	}

	@Override
	public List<Employee> revokeLeave(List<Employee> list) throws IOException   {
		// TODO Auto-generated method stub
		
		Iterator<Employee> employeeIteator = list.iterator();
		List<Employee> updatedLeaveEmployee = new ArrayList<>();
		while(employeeIteator.hasNext())
		{
			Employee typeOfEmployee = employeeIteator.next();
			if(typeOfEmployee instanceof Executive)
			{
			Executive tempoExecutive = (Executive)typeOfEmployee;
			if(tempoExecutive.myManager.employeeid.equals(this.employeeid))
			{
				
				tempoExecutive = (Executive) new RevokeLeave().revokeLeave(tempoExecutive,this);
				
			}
				updatedLeaveEmployee.add(tempoExecutive);
			}
			else if(typeOfEmployee instanceof Lead)
			{
				Lead tempoLead = (Lead)typeOfEmployee;
				if(tempoLead.myManager.employeeid.equals(this.employeeid))
				{
					
					tempoLead = (Lead) new RevokeLeave().revokeLeave(tempoLead,this);
					
				}
				updatedLeaveEmployee.add(tempoLead);
			}
			
			
		}
		
		return updatedLeaveEmployee;
		
	}



	
	
	

}


