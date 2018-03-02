package com.adaweng.shoppingcart.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static DateUtil dateUtil;
	public static final String DATAFORMAT_STR = "yyyy.MM.dd";
	private static DateFormat dateFormat = null;
	static {
		dateFormat = new SimpleDateFormat(DATAFORMAT_STR);
	}
	
	private DateUtil(){}
	
	public static DateUtil getDateUtil(){
		if(null == dateUtil){
			dateUtil = new DateUtil();
		}
		
		return dateUtil;
	}
	
	private DateFormat getDateFormat(String formatStr) {
		if (formatStr.equalsIgnoreCase(DATAFORMAT_STR)) {
			return dateFormat;
		} else {
			return new SimpleDateFormat(formatStr);
		}
	}
	
	public int getDifferDateDay(Date date1, Date date2) {
		long differ = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		try {
			date1 = sdf.parse(sdf.format(date1));
			date2 = sdf.parse(sdf.format(date2));
			long time1 = date1.getTime();
			long time2 = date2.getTime();
			//differ = (time1 < time2) ? time2 - time1 : time1 - time2;
			differ = time1 - time2;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int) (differ / (1000 * 60 * 60 * 24));
	}
}
