package com.lonewolf.memeStream.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

/**
 * Custom Exception thrown by REST API to be handled by API Exception Handler
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.exception.MemeExceptionHandler}
 */
@ToString
public class MemeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final HttpStatus status;

	public MemeException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
