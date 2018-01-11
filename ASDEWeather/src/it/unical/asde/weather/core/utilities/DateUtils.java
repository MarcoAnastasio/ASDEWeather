package it.unical.asde.weather.core.utilities;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	
	public static boolean chackTwoDateSameDay(Date date1,Date date2){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		return ( cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		         cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)) ;
	}
	
	

	
}
