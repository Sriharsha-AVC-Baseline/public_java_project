package week1;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AssignLeadsManagers implements Serializable{
	
	public Employee assignLead(List<Employee> list)
	{
		System.out.println("Lead : ");
		List<Employee> leadList = list.stream().filter(e->e instanceof Lead).collect(Collectors.toList());
	//	leadList.stream().forEach(e->System.out.println(e.employeeName));
		Lead myLead = (Lead)leadList.get((int)(Math.random()*(leadList.size()-1)));
		return myLead;
	}
	public Employee assignManager(List<Employee> list)
	{
		System.out.println("Managers : ");
		List<Employee> managerList = list.stream().filter(e->e instanceof Manager).collect(Collectors.toList());
	//	managerList.stream().forEach(e->System.out.println(e.employeeName));
		Manager myManager = (Manager)managerList.get((int)(Math.random()*(managerList.size()-1)));
		return myManager;
	}

}
