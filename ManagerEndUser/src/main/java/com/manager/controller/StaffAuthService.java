package com.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.manager.feignclient.StaffAuthClient;
import com.manager.model.AuthenticationResponse;

@Service
public class StaffAuthService {
	@Autowired
	StaffAuthClient staffAuthClient;
	
	public boolean isSessionValid(String token) {

	       AuthenticationResponse authenticationResponse = staffAuthClient.getValidity(token);
	        if (authenticationResponse == null) {
	            throw new RuntimeException("Authentication reponse returned as  NULL");
	        }
	       String role = authenticationResponse.getRole().substring(5);
	       if (role.equals("MANAGER"))
	            return true;
	       else
	           return false;
	   }
}



