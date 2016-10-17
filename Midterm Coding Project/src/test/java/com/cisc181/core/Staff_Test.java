package com.cisc181.core;


import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	private static ArrayList<Staff> staffList;
	private static Staff a;
	private static Staff b;
	private static DateFormat df;
	@BeforeClass
	public static void setup() {
		try {
			staffList= new ArrayList<Staff>();
			df=new SimpleDateFormat("yyyy-MM-dd");
			staffList.add(new Staff("AAA","BBB","CCC",df.parse("1995-01-01"),"Address0", 
					"(302)-111-2222", "ABC@gmail.com",
					"Monday 8:00-9:00", 1, 1000.0, df.parse("2008-01-03"),
					eTitle.MS));
			staffList.add(new Staff("AAA1","BBB1","CCC1",df.parse("1994-01-04"),"Address1", 
					"(302)-111-1112", "ABC1@gmail.com",
					"Monday 8:00-12:00", 2, 2000.0, df.parse("2007-01-01"),
					eTitle.MR));
			staffList.add(new Staff("AAA2","BBB2","CCC2",df.parse("1993-01-02"),"Address2", 
					"(302)-111-1113", "ABC2@gmail.com",
					"Monday 8:00-11:00", 2, 2000.0, df.parse("2007-01-06"),
					eTitle.MS));
			staffList.add(new Staff("AAA3","BBB3","CCC3",df.parse("1992-01-10"),"Address3", 
					"(302)-111-1114", "ABC3@gmail.com",
					"Monday 8:00-9:00", 2, 2000.0, df.parse("2007-01-30"),
					eTitle.MR));
			staffList.add(new Staff("AAA4","BBB4","CCC4",df.parse("1993-01-30"),"Address4", 
					"(302)-777-2222", "ABC4@gmail.com",
					"Monday 11:00-12:00", 1, 3000.0, df.parse("2007-01-10"),
					eTitle.MR));
			
		} catch (PersonException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void staffTest() {
		double SalaryAve=0;
		for (Staff a:staffList ){
			SalaryAve+=a.getSalary();	
		}
		SalaryAve/=staffList.size();
		assertEquals((int)SalaryAve,2000);
		
	}	
	
	@Test(expected=PersonException.class)
	public void phoneTest() throws PersonException, ParseException{
		df=new SimpleDateFormat("yyyy-MM-dd");
	a = new Staff("AAA","BBB","CCC",df.parse("1995-01-01"),"Address0", 
					"302-1112222", "ABC@udel.edu",
					"8:00-9:00", 1, 2000.0, df.parse("2008-01-03"),
					eTitle.MS);
	}
	
	@Test(expected=PersonException.class)
	public void dateOBTest() throws PersonException, ParseException{
		df=new SimpleDateFormat("yyyy-MM-dd");
		b = new Staff("AAA","BBB","CCC",df.parse("1895-01-01"),"Address6", 
				"(302)-111-2222", "ABC@udel.edu",
				"8:00-9:00", 2, 2000.0, df.parse("2008-01-03"),
				eTitle.MS);
		
}

}
