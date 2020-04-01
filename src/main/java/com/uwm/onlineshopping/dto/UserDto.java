package com.uwm.onlineshopping.dto;

import com.uwm.onlineshopping.model.BaseEntity;

public class UserDto extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String email;
	private RoleDto role;

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

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}
