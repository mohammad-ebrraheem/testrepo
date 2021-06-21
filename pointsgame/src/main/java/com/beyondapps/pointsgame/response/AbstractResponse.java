package com.beyondapps.pointsgame.response;

public abstract class AbstractResponse {

	private Fault fault;

	public Fault getFault() {
		return fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}
}
