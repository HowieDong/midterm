package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	private Enrollment() {
	}

	public Enrollment(UUID sectionID, UUID studentID) {
		SectionID = sectionID;
		StudentID = studentID;
		EnrollmentID = UUID.randomUUID();
	}
	public void SetGrade(double grade){
		this.Grade = grade;
	}
	public double GetGrade(){
		return this.Grade;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}

	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}

	
}