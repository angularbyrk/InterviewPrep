package com.cenit.exc.student.exception;

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public DataNotFoundException(String msg) {
		this.msg = msg;
	}

}
