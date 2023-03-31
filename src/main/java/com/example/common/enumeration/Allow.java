package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public enum Allow implements BaseEnum {

	ALL("app.enum.allow.all"), LOGIN_USER("app.enum.allow.loginUser"), SPECIFIC("app.enum.allow.specific"), NONE("app.enum.allow.none");

	private String msgCode;

	private Allow(String msgCode) {
		this.msgCode = msgCode;
	}

	@Override
	public String msgCode() {
		return this.msgCode;
	}

	@Override
	public String label(MessageSource messageSource, Locale locale) {
		return messageSource.getMessage(this.msgCode(), null, locale);
	}

}
