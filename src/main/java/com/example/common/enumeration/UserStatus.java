package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public enum UserStatus implements BaseEnum {

	PROVISIONAL("app.enum.userStatus.provisional"), COMPLETION("app.enum.userStatus.completion"), DELETE("app.enum.userStatus.delete");

	private String msgCode;

	private UserStatus(String msgCode) {
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
