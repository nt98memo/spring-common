package com.example.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class DemoException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<ObjectError> globalErrors = new ArrayList<ObjectError>();
	private List<FieldError> fieldErrors = new ArrayList<FieldError>();

	public DemoException() {
	}

	public DemoException(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
		this.setGlobalErrors(globalErrors);
		this.setFieldErrors(fieldErrors);
	}

	public DemoException(String message) {
		super(message);
	}

	public DemoException(Throwable cause) {
		super(cause);
	}

	public DemoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public List<ObjectError> getGlobalErrors() {
		return globalErrors;
	}

	public void setGlobalErrors(List<ObjectError> globalErrors) {
		this.globalErrors = globalErrors;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
