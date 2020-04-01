package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.RoleDto;

public interface RoleService {

	void saveRole(RoleDto roleDto);

	void updateRole(RoleDto roleDto);

	void deleteRole(Long id);

	RoleDto getRoleById(Long id);

	List<RoleDto> getAllRole();

}
