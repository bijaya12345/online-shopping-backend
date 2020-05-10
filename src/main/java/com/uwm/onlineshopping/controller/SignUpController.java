package com.uwm.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uwm.onlineshopping.dto.UserDto;
import com.uwm.onlineshopping.service.UserService;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("/signup")
public class SignUpController {

	private final UserService userService;

	@Autowired
	public SignUpController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("User has been registered successfully."),
				HttpStatus.OK);
	}
	
}
