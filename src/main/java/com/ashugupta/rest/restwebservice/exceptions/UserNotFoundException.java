package com.ashugupta.rest.restwebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	
	

}
