package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public enum Flg implements BaseEnum {

	ON("app.enum.flg.on"), OFF("app.enum.flg.off");

	private String msgCode;

	private Flg(String msgCode) {
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
