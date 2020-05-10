package com.uwm.onlineshopping.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ShoppingCartUtil {

	public static String encodePassword(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder(8);
        return encoder.encode(password);
    }
}
