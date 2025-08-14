package com.sm.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
public class Admin {

	private int adminId;
	private String adminName;
	
	@Email(message = "Please provide a valid email address")
	@NotBlank(message = "Email is required")
	private String adminEmail;
	
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
	private String adminPassword;

    @Size(min = 6, message = "Password must be at least 6 characters long")
	private String newPassword;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + ", newPassword=" + newPassword + "]";
	}

	


}
