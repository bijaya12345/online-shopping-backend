package com.uwm.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uwm.onlineshopping.dto.RoleDto;
import com.uwm.onlineshopping.service.RoleService;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("roles")
public class RoleController {

	private final RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	@PostMapping
	public ResponseEntity<ServiceResponse> saveRole(@RequestBody RoleDto roleDto) {
		roleService.saveRole(roleDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Role has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateRole(@RequestBody RoleDto roleDto) {
	roleService.updateRole(roleDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Role has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteRole(@PathVariable Long id) {
		roleService.deleteRole(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Role has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getRole(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Role has been deleted successfully.")
				.addParam("role", roleService.getRoleById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getRole() {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Role has been retrieved successfully.")
				.addParam("roles", roleService.getAllRole()), HttpStatus.OK);
	}

}
