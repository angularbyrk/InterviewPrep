package com.cenit.exc.student.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cenit.exc.student.exception.BadRequestException;
import com.cenit.exc.student.exception.DataNotFoundException;
import com.cenit.exc.student.exception.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = { BadRequestException.class, DataNotFoundException.class })
	public ResponseEntity<ErrorDetails> dataNotFoundException(Exception ex) {
		ErrorDetails response = new ErrorDetails(new Date(), ex.getClass().getName(), ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
