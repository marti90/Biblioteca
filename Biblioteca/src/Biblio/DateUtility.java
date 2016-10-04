package Biblio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	public Date convertStringtoDate(String dataString) throws ParseException{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date= sdf.parse(dataString);
		
		return date;
	}
	
    public java.sql.Date convertJavaDateToSqlDate(Date date){
    	
    	java.sql.Date dSql = new java.sql.Date(date.getTime());
    	
    	return dSql;
		
	}

}
