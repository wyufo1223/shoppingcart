package com.adaweng.shoppingcart.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
	
	private Date date1;
	
	private Date date2;
	
	private Date date3;
	
	
	@Before
	public void setUp() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		date1 = dateFormat.parse("2018.01.01");
		date2 = dateFormat.parse("2018.01.01");
		date3 = dateFormat.parse("2018.01.05");
		
	}

	@Test
	public void testGetDifferDateDay() {
		Assert.assertEquals(DateUtil.getDateUtil().getDifferDateDay(date1, date2), 0);
		Assert.assertEquals(DateUtil.getDateUtil().getDifferDateDay(date1, date3), -4);
		Assert.assertEquals(DateUtil.getDateUtil().getDifferDateDay(date3, date2), 4);
	}

}
