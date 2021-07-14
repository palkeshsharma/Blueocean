package com.register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//If record is not present in databse then API will encounter this exception

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	public static final long serialVersionUID=1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
