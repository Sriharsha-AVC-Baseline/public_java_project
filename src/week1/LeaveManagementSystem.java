package week1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class LeaveManagementSystem implements Serializable
{
public static List<Employee> employee = new ArrayList<Employee>();
public static Scanner scan = new Scanner(System.in);
public static BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
static String objectFileLocation = "C:\\Users\\sriharsha.s.bhat\\eclipse-workspace\\Leave_Management_System_v1.0\\src\\Employee Records.ser";

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException,Exception {
		// TODO Auto-generated method stub
	FileReader file = new FileReader("C:\\Users\\sriharsha.s.bhat\\eclipse-workspace\\Leave_Management_System_v1.0\\src\\admin_credentials.properties");
		Properties prop = new Properties();
		prop.load(file);
		file.close();
		
		
		
		try {
		FileInputStream fileStream = new FileInputStream(objectFileLocation);
		ObjectInputStream objReader = new ObjectInputStream(fileStream);
		if(objReader!=null)
		{
			employee = (List<Employee>)objReader.readObject();
			objReader.close();
			fileStream.close();
		}
		}
		catch(IOException ioex)
		{
			System.out.println("Welcome new User");
		}
		
		
		
		System.out.print("Enter the Admin Username : ");
		String adminUserName = bff.readLine();
		System.out.print("Enter the Admin Password : ");
		String adminPassword=bff.readLine();
		System.out.println(prop.getProperty("name")+" "+prop.getProperty("password"));
		if(adminUserName.equals(prop.getProperty("name")) && adminPassword.equals(prop.getProperty("password")))
		{
		System.out.println("-----------WELCOME TO LEAVE MANAGEMENT SYSTEM-----------");
			Start(0);
		}
		else
		{
			System.out.println("Incorrect username and password");
		}
	}
	
	public static void serialize(List<Employee> employe) throws IOException
	{
		try {
		FileOutputStream fileOutStream = new FileOutputStream(objectFileLocation);
		ObjectOutputStream objWriter = new ObjectOutputStream(fileOutStream);
		objWriter.writeObject(employe);
		objWriter.close();
		fileOutStream.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
		public static void Start(int makeChoice) throws Exception
		{
			System.out.println("1.Signup\n2.Login\n3.Exit\nEnter your choice");
			
			try {
				makeChoice = Integer.parseInt(bff.readLine());
				switch(makeChoice) {
				case 1:
					Signup signup = new Signup();
					employee.add(signup.readDesig(employee));
					break;
				case 2:
					Login login = new Login();
					login.loginEmployee(employee);break;
				
				case 3:
					System.out.println("Thank You");
					serialize(employee);
					System.exit(0);
				
				default:
					System.out.println("Enter Valid Choice");
				}
				
				}
				catch(Exception re)
				{
					System.out.println("Enter valid Choice");
					Start(0);
				}
			Start(0);
			
			}
		

}
