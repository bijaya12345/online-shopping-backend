package com.uwm.onlineshopping.dto;

import java.util.Date;

import com.uwm.onlineshopping.model.BaseEntity;

public class UserDto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String fullName;
	private String userName;
	private String password;
	private String email;
	private Date dob;
	private RoleDto role;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}
