package com.springpractice.jee;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if((user.equals("John") && password.equals("password")) || (user.equals("Sarah") && password.equals("meow"))) 
			return true;
		else {
			return false;
		}
	}
}
