package com.diogorolins.battleShip.resources.handler;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;

	public StandardError() {

	}

	public StandardError(String error) {
		super();

		this.error = error;

	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
