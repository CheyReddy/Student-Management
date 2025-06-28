package com.sm.dto;

import org.springframework.stereotype.Component;

@Component
public class AcademicDetails {

	private String grade;
	private String rollNo;
	private String course;

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "AcademicDetails [grade=" + grade + ", rollNo=" + rollNo + ", course=" + course + "]";
	}




}
