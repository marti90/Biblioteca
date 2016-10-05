package Biblio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtility {
	
	private static final int NUMERO_MILLISECONDI_PER_UN_GIORNO = 86400000;
	
	//Per convertire una Stringa in util.Date
	public Date convertStringtoDate(String dataString) throws ParseException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date= sdf.parse(dataString);
		
		return date;
	}
	
	//Per convertire una util.Date in sql.Date 
    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date){
    	
    	java.sql.Date dSql = new java.sql.Date(date.getTime());
    	
    	return dSql;
		
	}
    
    //Per convertire sql.Date in util.Date
    public java.util.Date convertSqlDateToJavaDate(java.sql.Date date){
    	
    	java.util.Date dUtil = new java.util.Date(date.getTime());
    	
    	return dUtil;
		
	}
    
    //Per convertire Calendar in util.Date
    public Date convertCalendarToDate(Calendar c){
    	
    	return c.getTime();
    }
    
    //Per convertire java.util.Date in Calendar
    public Calendar convertDateToCalendar(java.util.Date d){
    	
    	Calendar cal= Calendar.getInstance();
    	cal.setTimeInMillis(d.getTime());
    	return cal;
    }
    
    //Per comparare due util.Date
    public long getDayDifference(Date date1, Date date2){
    	
    	long diffMillisecondi= date2.getTime()-date1.getTime();
    	long dayDiff=diffMillisecondi/NUMERO_MILLISECONDI_PER_UN_GIORNO;
    	
    	return dayDiff;
    	
    }

}
