package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class Signup implements Serializable{
	
	BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));

	Employee readDesig(List<Employee> list) throws IOException, ParseException, NumberFormatException
	{
		 Employee newEmployee = null;
		while(true) {
		System.out.print("Are you\t1.Executive  2.Lead  3.Manager\nEnter your Choice : ");
		int designation = Integer.parseInt(bff.readLine());
		if(designation==1)
		{
			newEmployee = new Executive();
			newEmployee.designation=Designations.EXECUTIVE.toString();
			newEmployee = readDetails(newEmployee);
			Executive newExecutive = (Executive)newEmployee;
			newExecutive.myLead = new AssignLeadsManagers().assignLead(list);
			Lead hisLead = (Lead)newExecutive.myLead;
			newExecutive.myManager = hisLead.myManager;
			return newExecutive;
		}
		else if(designation==2)
		{
			newEmployee = new Lead();
			newEmployee.designation=Designations.LEAD.toString();
			newEmployee = readDetails(newEmployee);
			Lead newLead = (Lead)newEmployee;
			newLead.myManager = new AssignLeadsManagers().assignManager(list);
			return newLead;
		}
		else if(designation==3)
		{
			newEmployee = new Manager();
			newEmployee.designation=Designations.MANAGER.toString();
			newEmployee = readDetails(newEmployee);
			return newEmployee;
		}
		else
		{
			System.out.println("Invalid Choice");
		}
	}
	}
	
	Employee readDetails(Employee newEmployee) throws IOException, ParseException, NumberFormatException
	{
		try {
		System.out.println("Enter your name : ");
		newEmployee.employeeName = bff.readLine();
		System.out.println("Enter your Phone number : ");
		
		newEmployee.employeePhoneNumber = Long.parseLong(bff.readLine());
		
		System.out.println("Enter your Address : ");
		newEmployee.employeeAddress=bff.readLine().trim();
		System.out.println("Enter your Email : ");
		newEmployee.employeeMail=bff.readLine();
		GetDate getDate = new GetDate();
		newEmployee.employeeDateOfBirth = getDate.readDate();
		System.out.println("Enter your Password : ");
		newEmployee.setEmplpassword(bff.readLine().trim());
		newEmployee.employeeid = new GenerateEmployeeID().generateID(newEmployee.employeeName, getDate.returnDate(newEmployee.employeeDateOfBirth), newEmployee.designation);
		System.out.println("Your Employee ID is "+newEmployee.employeeid);
		newEmployee.leaveDetails.put(LeaveTypes.CASUAL_LEAVE.toString(), 10);
		newEmployee.leaveDetails.put(LeaveTypes.EARNED_LEAVE.toString(), 15);
		newEmployee.leaveDetails.put(LeaveTypes.DUTY_LEAVE.toString(), 0);
		newEmployee.leaveDetails.put(LeaveTypes.SICK_LEAVE.toString(), 12);
		newEmployee.leaveDetails.put(LeaveTypes.MATERNITY_LEAVE.toString(), 120);
		newEmployee.leaveDetails.put(LeaveTypes.PARENTAL_LEAVE.toString(), 7);
		newEmployee.leaveDetails.put(LeaveTypes.LEAVE_WITHOUT_PAY.toString(), 180);	
		
		}

		catch(Exception e)
		{
			System.out.println("Invalid Phone number");
			newEmployee = readDetails(newEmployee);
		}
		return newEmployee;
}
}
