package com.beyondapps.pointsgame.controllers;

import com.beyondapps.pointsgame.enums.Errors;
import com.beyondapps.pointsgame.response.AbstractResponse;
import com.beyondapps.pointsgame.response.Fault;;

public interface IController {

	default void setFault(AbstractResponse response, Errors errors) {
		Fault fault = new Fault(errors.errorCode(), errors.errorDescription());
		response.setFault(fault);
	}

	default void setFault(AbstractResponse response, String errorCode, String errorDescription) {
		Fault fault = new Fault(errorCode, errorDescription);
		response.setFault(fault);
	}
}
