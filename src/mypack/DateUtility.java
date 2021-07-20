package mypack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility 
{
	
	
	public static Date stringToDate(String dateAsString)
	{
		try
		{
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		return sf.parse(dateAsString);
		}catch(ParseException pe)
		{
			pe.getMessage();
			return null;
		}
	}
	
	public static String dateToString(Date date)
	{
		
		    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		    return sf.format(date);
		
	}

}
