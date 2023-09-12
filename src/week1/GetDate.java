package week1;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetDate implements Serializable{
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public Date readDate() throws ParseException
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date in dd/MM/yyyy format");
		String dateInString = scan.nextLine();
		try {
		Date date = simpleDateFormat.parse(dateInString);
		return date;
		}
		catch(Exception e)
		{
			System.out.println("Enter Valid Date please");
			Date date = readDate();
			return date;
		}
	}
	public String returnDate(Date date)
	{
		String dateInString;
		dateInString = simpleDateFormat.format(date);
		return dateInString;
	}
	
	public int differenceBetweenDates(Date from, Date to) throws Exception {
		try {
		return new GetDateDifference().differenceBetweenDates(from, to);
		}
		catch(Exception e)
		{
			System.out.println("Two invalid dates\n");
		}
		return 0;
	}
}
