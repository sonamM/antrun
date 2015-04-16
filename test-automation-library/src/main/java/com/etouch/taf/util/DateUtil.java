/*
 * 
 */
package com.etouch.taf.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.exception.DateException;
import com.etouch.taf.core.exception.ListException;

// TODO: Auto-generated Javadoc
/**
 * This class contains date utility functions.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class DateUtil {
	
	/** The log. */
	private static Log log = LogUtil.getLog(DateUtil.class);
	
	/** The Constant monthMap. */
	private static final Map<String,String> monthMap;
	
	/** The Constant hourFormat. */
	private static final Map<String,String> hourFormat;	
	
	/** The Constant dateFormatList. */
	private static final List<String> dateFormatList;
	
	static{
		monthMap = new HashMap<String, String>();
		monthMap.put("JAN", "01");
		monthMap.put("FEB", "02");
		monthMap.put("MAR", "03");
		monthMap.put("APR", "04");
		monthMap.put("MAY", "05");
		monthMap.put("JUN", "06");
		monthMap.put("JUL", "07");
		monthMap.put("AUG", "08");
		monthMap.put("SEP", "09");
		monthMap.put("OCT", "10");		
		monthMap.put("NOV", "11");		
		monthMap.put("DEC", "12");		
		hourFormat = new HashMap<String, String>();	
		hourFormat.put("01", "13");
		hourFormat.put("02", "14");
		hourFormat.put("03", "15");
		hourFormat.put("04", "16");
		hourFormat.put("05", "17");
		hourFormat.put("06", "18");
		hourFormat.put("07", "19");
		hourFormat.put("08", "20");
		hourFormat.put("09", "21");
		hourFormat.put("10", "22");		
		hourFormat.put("11", "23");		
		dateFormatList = new ArrayList<String>();
		dateFormatList.add("yyyyMMdd");
		dateFormatList.add("yyyy-MM-dd");
		dateFormatList.add("yyyyMMddhhmmss");		
		dateFormatList.add("yyyy-MM-dd hh:mm:ss");
		dateFormatList.add("yyyy/MM/dd hh:mm:ss");		
    }

	/**
	 * Gets the month in digit.
	 *
	 * @param sMon the s mon
	 * @return the month in digit
	 * @throws DateException the date exception
	 */
	public String getMonthInDigit(String sMon) throws DateException{
		if(!CommonUtil.isNull(sMon)){
			if(sMon.length() >= 3){
				sMon = (sMon.length() > 3)?sMon.substring(0,2):sMon;
			}else{
				log.error("Month characters are less that 3 - "+sMon);			
				throw new DateException("Month characters are less that 3");
			}	
		}else{
			log.error("Month is null" + sMon);			
			throw new DateException("Month is null");
		}	
		return monthMap.get(sMon);
	}
	
	/**
	 * Gets the 24 hour format.
	 *
	 * @param hr the hr
	 * @return the 24 hour format
	 * @throws DateException the date exception
	 */
	public String get24HourFormat(String hr) throws DateException{
		if(CommonUtil.isNull(hr) || CommonUtil.isNull(hourFormat.get(hr))){
			log.error("Hour string or format is null - "+hr);
			throw new DateException("Hour string or format is null");
		}
		return hourFormat.get(hr);
	}
	
	/**
	 * Gets the string to date.
	 *
	 * @param sdt the sdt
	 * @param format the format
	 * @return the string to date
	 * @throws DateException the date exception
	 */
	public Date getStringToDate(String sdt, String format) throws DateException{
		if(CommonUtil.isNull(sdt) || CommonUtil.isNull(format)){
			log.error("Date string or format value is null - ("+sdt+","+format+")");
			throw new DateException("Date String or format is null");
		}
		if (!dateFormatList.contains(format)){
			log.error("Date format is invalid - "+format);
			throw new DateException("Date format is invalid");
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(sdt);
		} catch (ParseException pe) {
			throw new DateException("Parsing Error");
		}
		return date;
	}	

	
	/**
	 * Gets the date to string.
	 *
	 * @param dt the dt
	 * @param format the format
	 * @return the date to string
	 * @throws DateException the date exception
	 */
	public String getDateToString(Date dt, String format) throws DateException{
		if(CommonUtil.isNull(dt) || CommonUtil.isNull(format)){
			log.error("Date or format value is null - ("+dt+","+format+")");
			throw new DateException("Date or format value is null");
		}
		if (!dateFormatList.contains(format)){
			log.error("Date format is invalid - "+format);
			throw new DateException("Date format is invalid");
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(dt); 
	}
	
	/**
	 * Gets the date to string.
	 *
	 * @param dt the dt
	 * @return the date to string
	 * @throws DateException the date exception
	 */
	public String getDateToString(Date dt) throws DateException{
		if(CommonUtil.isNull(dt)){
			log.error("Date value is "+ dt);
			throw new DateException("Date value is null");
		}
		Calendar cal = getDateToCalendar(dt);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String sMonth = ((month < 10)? "0" + month: ""+month);
		int date =  cal.get(Calendar.DATE);
		String sDate = ((date < 10)? "0" + date: ""+date);
		int hour =  cal.get(Calendar.HOUR);
		String sHour = ((hour < 10)? "0" + hour: ""+hour);
		int minute =  cal.get(Calendar.MINUTE);
		String sMinute = ((minute < 10)? "0" + minute: ""+minute);
		int second =  cal.get(Calendar.SECOND);
		String sSecond = ((second < 10)? "0" + second: ""+second);
		
		String str =  year + sMonth + sDate + sHour + sMinute + sSecond; 
		return str;
	}
	
	/**
	 * Gets the date string.
	 *
	 * @param sTxt the s txt
	 * @return the date string
	 * @throws DateException the date exception
	 */
	public String getDateString(String sTxt) throws DateException{
		String mon = null;
		String day = null;
		String hour = null;
		String minute = null;

		StringTokenizer stok = new StringTokenizer(sTxt," ,:");
			
		mon = getMonthInDigit(stok.nextToken());
		day = stok.nextToken();
		day = (day.length()==1)?"0"+day:day;
		hour = stok.nextToken();
		hour = (hour.length()==1)?"0"+hour:hour;
		minute = stok.nextToken();
		String ampm = ""+minute.charAt(minute.length()-1);
		minute = minute.substring(0,minute.length()-1);
		minute = (minute.length()==1)?"0"+minute:minute;
		if("p".equals(ampm)){
			hour = get24HourFormat(hour);
		}

		return (mon+day+hour+minute);
	}
	
	/**
	 * Gets the date to calendar.
	 *
	 * @param date the date
	 * @return the date to calendar
	 * @throws DateException the date exception
	 */
	public Calendar getDateToCalendar(Date date)  throws DateException{
		if(CommonUtil.isNull(date)){
			log.error("Date is null - "+ date);
			throw new DateException("Date is null");
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * Gets the list date to string.
	 *
	 * @param dtList the dt list
	 * @return the list date to string
	 * @throws DateException the date exception
	 */
	public List<String> getListDateToString(List<Date> dtList) throws DateException{
		if(CommonUtil.isNull(dtList)){
			log.error("Date List is null - "+ dtList);
			throw new DateException("Date List is null");
		}
		List<String> lstStr = new ArrayList<String>();
		for(Date dt : dtList){
			lstStr.add(getDateToString(dt));
		}
		return lstStr;
	}
	
	/**
	 * Checks if is date in order.
	 *
	 * @param lstDateStr the lst date str
	 * @param isAsc the is asc
	 * @return true, if is date in order
	 * @throws DateException the date exception
	 * @throws ListException the list exception
	 */
	public boolean isDateInOrder(List<String> lstDateStr, boolean isAsc) throws DateException,ListException{
		
		if(CommonUtil.isNull(lstDateStr)){
			log.error("Date string is null - "+ lstDateStr);
			throw new DateException("Date string is null");
		}
		
		if(lstDateStr.size() == 0){
			log.error("List is empty - "+ lstDateStr.size());
			throw new ListException("List is empty");
		}
		
		if(isAsc==true){
			for(int i=0; i < lstDateStr.size()-1; i++){
				
				if(lstDateStr.get(i).compareTo(lstDateStr.get(i+1)) > 0){
					return false;	
				}
			}
		}else if(isAsc==false){
			for(int i=0; i < lstDateStr.size()-1; i++){
				if(lstDateStr.get(i).compareTo(lstDateStr.get(i+1)) < 0){
					return false;	
				}
			}
		}
		return true;
	}
	
	/**
	 * Gets the current date time.
	 *
	 * @param format the format
	 * @return the current date time
	 */
	public static String getCurrentDateTime(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		//get current date time with Date()
	    Date date = new Date();
	    return dateFormat.format(date);	    
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	   System.out.println(DateUtil.getCurrentDateTime("yyyy-MM-dd HH:mm:ss z"));
	}
	
}