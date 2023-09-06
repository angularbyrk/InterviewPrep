package com.cenit.exc.student.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

	public BadRequestException(String msg) {
		this.msg = msg;
	}

}
