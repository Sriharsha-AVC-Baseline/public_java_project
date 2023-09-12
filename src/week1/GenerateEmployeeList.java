package week1;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateEmployeeList implements Serializable{
	
		public void generateEmployeeList(List<Employee> l)
		{
			
			List<Employee> exList = l.stream().filter(e->e instanceof Executive).collect(Collectors.toList());
			List<Employee> leadList = l.stream().filter(e->e instanceof Lead).collect(Collectors.toList());
			List<Employee> managerList = l.stream().filter(e->e instanceof Manager).collect(Collectors.toList());
			
			Iterator it = exList.iterator();
			while(it.hasNext()){
				Employee e = (Employee)it.next();
				Executive ex = (Executive)e;
				System.out.println(ex.employeeName+" "+ex.employeeid+" "+ex.employeePhoneNumber+" "+ex.employeeMail+" His Lead = "+ex.myLead.employeeName + " His Manager "+ex.myManager.employeeName);
			}
			Iterator it2 = leadList.iterator();
			while(it2.hasNext()){
				Employee e = (Employee)it2.next();
				Lead ex = (Lead)e;
				System.out.println(ex.employeeName+" "+ex.employeeid+" "+ex.employeePhoneNumber+" "+ex.employeeMail+" His Manager = "+ex.myManager.employeeName);
			}
			Iterator it3 = managerList.iterator();
			while(it3.hasNext()){
				Employee e = (Employee)it3.next();
				Manager ex = (Manager)e;
				System.out.println(ex.employeeName+" "+ex.employeeid+" "+ex.employeePhoneNumber+" "+ex.employeeMail);
			}
			
			
		}
	
	
}
