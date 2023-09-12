package week1;

import java.io.Serializable;

public class GenerateEmployeeID implements Serializable{
	
	public String generateID(String name,String DateOfBirth,String Designation)
	{
		String employeeID = null;
		String[] namePart = name.split("[ ]");
		String[] datePart = DateOfBirth.split("[/]");
		employeeID = namePart[0] + datePart[2] + String.valueOf(Designation.charAt(0));
		
		return employeeID;
	}

}
