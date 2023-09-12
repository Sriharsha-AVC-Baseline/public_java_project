package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import week1.LeaveManagementSystem;
public class Login implements Serializable{

	
	public void loginEmployee(List<Employee> list) throws IOException,Exception
	{
		String employeeID,employeePass;
		System.out.println("Enter ID : ");
		employeeID = week1.LeaveManagementSystem.bff.readLine().trim();
		System.out.println("Enter Password : ");
		employeePass = week1.LeaveManagementSystem.bff.readLine().trim();
		Iterator employeeIterator = list.iterator();
		Employee tempEmployee=null;
		while(employeeIterator.hasNext())
		{
			tempEmployee = (Employee)employeeIterator.next();
			if(tempEmployee.employeeid.equalsIgnoreCase(employeeID) && tempEmployee.getEmplpassword().equals(employeePass))
			{
				System.out.println(tempEmployee.employeeName+" logged in as "+tempEmployee.designation);
				tempEmployee.employeeLogin(list);
				return;
			}
		}
		
		System.out.println("Login Failed");
	}
}
