package com.uwm.onlineshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role_tbl")
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "role_name")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
