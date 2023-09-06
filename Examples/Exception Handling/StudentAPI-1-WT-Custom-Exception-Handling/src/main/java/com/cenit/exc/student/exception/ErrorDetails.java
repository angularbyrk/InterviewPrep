package com.cenit.exc.student.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String msg;
	private String description;

	public ErrorDetails(Date timestamp, String msg, String description) {
		this.timestamp = timestamp;
		this.msg = msg;
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
