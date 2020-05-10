package com.uwm.onlineshopping.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private final HttpStatus status;
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;

	public ErrorResponse(HttpStatus status, Throwable ex) {
		this(status, LocalDateTime.now(), "Unexpected error", ex.getLocalizedMessage());
	}

	public ErrorResponse(HttpStatus status, String message, Throwable ex) {
		this(status, LocalDateTime.now(), message, ex.getLocalizedMessage());
	}

	public ErrorResponse(HttpStatus status, LocalDateTime timestamp, String message, String debugMessage) {
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.debugMessage = debugMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

}
