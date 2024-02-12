package com.jsp.integration.util;

import java.util.Base64;

public class EDUtil {

	public static String encode(String pass) {
		String encode = Base64.getEncoder().encodeToString(pass.getBytes());
		return encode;
		
	}

	public static String decode(String pass) {

		byte[] decode = Base64.getDecoder().decode(pass);
		return new String(decode);
	}
	
	
}
