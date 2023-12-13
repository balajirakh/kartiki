package com.BikkatIT.NewProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.BikkatIT.NewProject.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourcenotfoundexceptionhandler(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		ApiResponse api = new ApiResponse();
		api.setMessage(message);
		api.setStatus(false);
		api.setNote("provide valid userid");

		return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);

	}
}
