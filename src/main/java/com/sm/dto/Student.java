package com.sm.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private int id;
	private String name;
	private long mobile;
	private String country;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date dob;

	private String gender;
	private String email;
	private long parentsMobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getParentsMobile() {
		return parentsMobile;
	}
	public void setParentsMobile(long parentsMobile) {
		this.parentsMobile = parentsMobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", parentsMobile=" + parentsMobile + "]";
	}
	
	

}
