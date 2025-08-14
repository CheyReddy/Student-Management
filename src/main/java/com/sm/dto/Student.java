package com.sm.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Component
public class Student {

	private int id;
	private String name;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be 10 digits and start with 6-9")
	private String mobile;
	
	private String country;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date dob;

	private String gender;
	
	@Email(message = "Please provide a valid email address")
	@NotBlank(message = "Email is required")
	private String email;
	
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be 10 digits and start with 6-9")
	private String parentsMobile;
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
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
	public String getParentsMobile() {
		return parentsMobile;
	}
	public void setParentsMobile(String parentsMobile) {
		this.parentsMobile = parentsMobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", parentsMobile=" + parentsMobile + "]";
	}
	
	

}
