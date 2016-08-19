package com.yaesta.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class UtilDate {

	/*
     * Converts java.util.Date to javax.xml.datatype.XMLGregorianCalendar
     */
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
           // Logger.getLogger(StringReplace.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCalendar;
    }
  
    /*
     * Converts XMLGregorianCalendar to java.util.Date in Java
     */
    public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


//Read more: http://javarevisited.blogspot.com/2013/02/convert-xmlgregoriancalendar-to-date-xmlgregoriancalendar-java-example-tutorial.html#ixzz4DmYjB7Ip
    
    public static String formatDateISO(Date date){
		String formatted = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
	            .format(date);
		return formatted;
	}
    
    /** Transform ISO 8601 string to Date. */
    public static Date fromIsoToDate(final String iso8601string) throws ParseException {
        String s = iso8601string.replace("+00:00", "Z");
        try {
        	String s1 = s.substring(0, 19);
        	//String s2 = s.substring(27);
        	//s2=s2.replace(":", "");
            s = s1;  // to get rid of the ":"
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid length", 0);
        }
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(s);
       
        return date;
    }
    
    /** Transform ISO 8601 string to Calendar. */
    public static Calendar fromIsoToCalendar(final String iso8601string) throws ParseException {
        Calendar calendar = GregorianCalendar.getInstance();
        Date date = fromIsoToDate(iso8601string);
        calendar.setTime(date);
        return calendar;
    }
}
