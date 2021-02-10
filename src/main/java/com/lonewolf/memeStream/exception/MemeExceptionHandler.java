package com.lonewolf.memeStream.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception Handler for {@link com.lonewolf.memeStream.exception.MemeException}
 * thrown by REST API
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.exception.MemeException}
 */
@RestControllerAdvice
public class MemeExceptionHandler {
	private static final String Message = "message";

	@ExceptionHandler(value = { MemeException.class })
	public ResponseEntity<Map<String, String>> handleMemeException(MemeException exception) {
		Map<String, String> errorResponseBody = new HashMap<>();
		errorResponseBody.put(Message, exception.getMessage());

		return new ResponseEntity<Map<String, String>>(errorResponseBody, exception.getStatus());
	}
}
