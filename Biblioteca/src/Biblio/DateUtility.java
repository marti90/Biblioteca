package Biblio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtility {
	
	private static final int NUMERO_MILLISECONDI_PER_UN_GIORNO = 86400000;
	
	public Date convertStringtoDate(String dataString) throws ParseException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date= sdf.parse(dataString);
		
		return date;
	}
	
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date){
    	
    	java.sql.Date dSql = new java.sql.Date(date.getTime());
    	
    	return dSql;
		
	}
    
    public java.util.Date convertSqlDateToJavaDate(java.sql.Date date){
    	
    	java.util.Date dUtil = new java.util.Date(date.getTime());
    	
    	return dUtil;
		
	}
    
    public Date convertCalendarToDate(Calendar c){
    	
    	return c.getTime();
    }
    
    //Convertire java.util.Date in Calendar
    public Calendar convertDateToCalendar(java.util.Date d){
    	
    	Calendar cal= Calendar.getInstance();
    	cal.setTimeInMillis(d.getTime());
    	return cal;
    }
    
    public long getDayDifference(Date date1, Date date2){
    	
    	long diffMillisecondi= date2.getTime()-date1.getTime();
    	long dayDiff=diffMillisecondi/NUMERO_MILLISECONDI_PER_UN_GIORNO;
    	
    	return dayDiff;
    	
    }

}
