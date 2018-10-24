package com.anil.service;

public class Register_Service {
	public boolean match_password(String pass1,String pass2)
	{
		if(pass1.equals(pass2))
		{
			return true;
		}
		return false;
		
	}
}
