package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public enum Deny implements BaseEnum {

	ALL("app.enum.deny.all"), NO_LOGIN_USER("app.enum.deny.noLoginUser"), SPECIFIC("app.enum.deny.specific"), NONE("app.enum.deny.none");

	private String msgCode;

	private Deny(String msgCode) {
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
