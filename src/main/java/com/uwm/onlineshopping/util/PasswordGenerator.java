package com.uwm.onlineshopping.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder(4);
		String pass = encoder.encode("pass1234");
		System.out.println("password is: " + pass);
	}
}
