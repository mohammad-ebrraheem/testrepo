package com.beyondapps.pointsgame.enums;

public enum Errors {

	SERVICE_LAYER_ERROR("srv_1", "SERVICE_LAYER_ERROR"),
	INSUFFICIENT_POINTS_ERROR("srv_2", "INSUFFICIENT_POINTS_ERROR"),
	INVALID_INPUTS_ERROR("srv_3", "INVALID_INPUTS_ERROR");

	private String errorCode;
	private String errorDescription;

	private Errors(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String errorCode() {
		return errorCode;
	}

	public String errorDescription() {
		return errorDescription;
	}

}
