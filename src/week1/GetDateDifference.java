package week1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateDifference implements Serializable{
	
	public int differenceBetweenDates(Date from, Date to) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String a = simpleDateFormat.format(from);
		 String b = simpleDateFormat.format(to);
		int fday, fmon, fyear;
		int sday, smon, syear;
		int dif;
		String[] arr1 = a.split("/");
		String[] arr2 = b.split("/");
		fday = Integer.parseInt(arr1[0]);
		fmon = Integer.parseInt(arr1[1]);
		fyear = Integer.parseInt(arr1[2]);

		System.out.println(fday + " " + fmon + " " + fyear);

		sday = Integer.parseInt(arr2[0]);
		smon = Integer.parseInt(arr2[1]);
		syear = Integer.parseInt(arr2[2]);

		System.out.println(sday + " " + smon + " " + syear);

		dif = (365 * (syear - fyear)) + (30 * (smon - fmon)) + (sday - fday);
		if (dif == 0) {
			throw new Exception("Same date exception");
		}
		if(dif < 0)
		{
			throw new Exception("FROM date is after TO date");
		}
		return dif;
	}

}
