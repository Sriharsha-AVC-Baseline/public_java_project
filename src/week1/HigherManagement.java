package week1;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface HigherManagement extends Serializable{
	
	public List<Employee> approveRejectLeave(List<Employee> list) throws IOException;
	public List<Employee> revokeLeave(List<Employee> list)throws IOException;
	
}
