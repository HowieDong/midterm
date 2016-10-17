package com.cisc181.core;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	private static ArrayList<Student> studentList;
	private static DateFormat df;
	private static ArrayList<Course> courseList;
	private static ArrayList<Semester> semesterList;
	private static ArrayList<Section> sectionList;
	private static ArrayList<Enrollment> enrollmentList;

	@BeforeClass
	public static void setup() throws PersonException, ParseException {
	studentList = new ArrayList<Student>();
	courseList= new ArrayList<Course>();
	semesterList = new ArrayList<Semester>();
	sectionList=new  ArrayList<Section>();
	enrollmentList =new ArrayList<Enrollment>();
	df=new SimpleDateFormat("yyyy-MM-dd");
	
	courseList.add(new Course("PHYSICS", 100, eMajor.PHYSICS));
	courseList.add(new Course("Chemistry", 100, eMajor.CHEM));
	courseList.add(new Course("Nursing", 100, eMajor.NURSING));
	
	// fall semester
	semesterList.add(new Semester(df.parse("2012-06-30"),df.parse("2012-12-30") ));
	// spring semester
	semesterList.add(new Semester(df.parse("2013-01-10"),df.parse("2013-06-10") ));
	
	sectionList.add(new Section(courseList.get(0).getCourseID(),semesterList.get(0).getSemesterID(),1001));
	sectionList.add(new Section(courseList.get(0).getCourseID(),semesterList.get(1).getSemesterID(),1002));
	sectionList.add(new Section(courseList.get(1).getCourseID(),semesterList.get(0).getSemesterID(),1003));
	sectionList.add(new Section(courseList.get(1).getCourseID(),semesterList.get(1).getSemesterID(),1004));
	sectionList.add(new Section(courseList.get(2).getCourseID(),semesterList.get(0).getSemesterID(),1005));
	sectionList.add(new Section(courseList.get(2).getCourseID(),semesterList.get(1).getSemesterID(),1006));
	
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.PHYSICS,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.PHYSICS,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.PHYSICS,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.COMPSI,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	studentList.add(new Student("AAA","BBB","CCC",df.parse("1995-01-01"), eMajor.CHEM,
			"Address0", "(302)-111-2222", "ABC@gmail.com"));
	//Enroll the ten students.
	for (int i=0; i<studentList.size(); i++){
		for (int j=0; j<sectionList.size(); j++){
			enrollmentList.add(new Enrollment(studentList.get(i).getStudentID(), sectionList.get(j).getSectionID()));
		}
	}
	
	for (int i=0; i<enrollmentList.size(); i++){
		enrollmentList.get(i).SetGrade(100);
	}
}

@Test
public void enrollmentTest() {
	assertEquals(enrollmentList.size(),60);	
}

@Test
public void gpaTest(){
	ArrayList<Double> GradesNow = new ArrayList<Double>();
	for (int j = 0; j < 60; j++) {
		double grade=0;
		GradesNow.add(grade);
		enrollmentList.get(j).GetGrade();
}
}

@Test
public void averageTest(){
	
	for (int i=0;i<sectionList.size(); i++){
		double gpa=0;
		for (int j=i; j<enrollmentList.size(); j=j+sectionList.size()){
			gpa += enrollmentList.get(j).GetGrade();
		
		}	
		assertEquals((int)gpa/studentList.size(),100);
	}
	
}


@Test
public void replaceMajorTest() {
	studentList.get(0).setMajor(eMajor.CHEM);
	assertEquals(studentList.get(0).getMajor(), eMajor.CHEM);
}

}