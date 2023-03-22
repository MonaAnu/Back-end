package com.manager.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.manager.model.AuthenticationResponse;

@FeignClient (name="Authentication", url= "http://localhost:9999/auth")
public interface RoomAuthClient {
	 @GetMapping("/validate")
	    public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token) ;
	    
	    }


