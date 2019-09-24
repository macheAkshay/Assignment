package com.index.git.api.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.index.git.api.exception.ErrorResponse;
import com.index.git.api.exception.InvalidUser;
import com.index.git.api.exception.NoProjectsAvailable;
import com.index.git.api.exception.ResourceNotFound;

@ControllerAdvice
public class ExceptionController {

	private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);
	
	
	static {
		
		LOGGER.info("Exception Controller Loaded...!");
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> resourceNotFound(ResourceNotFound exc)
	{
		ErrorResponse e = new ErrorResponse();
					  e.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
					  e.setMessage(exc.getMessage());
					  e.setTimeStamp(System.currentTimeMillis());
					  
		return new ResponseEntity<ErrorResponse>(e, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> invalidUser(InvalidUser exc)
	{
		ErrorResponse e = new ErrorResponse();
					  e.setStatus(HttpStatus.NOT_FOUND.value());
					  e.setMessage(exc.getMessage());
					  e.setTimeStamp(System.currentTimeMillis());
					  
		return new ResponseEntity<ErrorResponse>(e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> noProjectsAvailable(NoProjectsAvailable exc)
	{
		ErrorResponse e = new ErrorResponse();
					  e.setStatus(HttpStatus.NO_CONTENT.value());
					  e.setMessage(exc.getMessage());
					  e.setTimeStamp(System.currentTimeMillis());
					  
		return new ResponseEntity<ErrorResponse>(e, HttpStatus.NO_CONTENT);
	}
}