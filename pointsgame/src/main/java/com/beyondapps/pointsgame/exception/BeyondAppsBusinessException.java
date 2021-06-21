package com.beyondapps.pointsgame.exception;

public class BeyondAppsBusinessException extends Exception {

	private String errorCode;
	private String message;

	public BeyondAppsBusinessException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
