package com.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.feignclient.StaffAuthClient;
import com.staff.model.AuthenticationResponse;

@Service
public class StaffAuthService 
{

	@Autowired
	StaffAuthClient staffAuthClient;

	public boolean isSessionValid(String token) 
	{

	       AuthenticationResponse authResponse = staffAuthClient.getValidity(token);
	        if (authResponse == null) {
	            throw new RuntimeException("Auth reponse returned as  NULL");
	        }
	        String role = authResponse.getRole().substring(5);
	        if (role.equals("MANAGER"))
	           return true;
	        else if (role.equals("OWNER"))
				return true;
			else

				return false;
	}
}

