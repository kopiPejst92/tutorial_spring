package com.in28min.springboot.myfirst.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenthicate(String username, String password) {
		String VALIDUSER="aga";
		String VALIDPASS = "learn";
			
		boolean isValidUserName = username.equalsIgnoreCase(VALIDUSER);
		boolean isValidPass= password.equalsIgnoreCase(VALIDPASS);
		return isValidUserName & isValidPass;
	}
}
