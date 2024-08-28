package com.webdevelopemnt.SpringWeb.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String userName, String password) {
		boolean isvalidName = userName.equalsIgnoreCase("prasanna");
		boolean isvalidPassword = password.equalsIgnoreCase("1234");
	
		return isvalidName && isvalidPassword;
	}

}
