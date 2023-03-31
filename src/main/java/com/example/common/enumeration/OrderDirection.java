package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public enum OrderDirection implements BaseEnum {

	ASC("app.enum.order.asc"), DESC("app.enum.order.desc");

	private String msgCode;

	private OrderDirection(String msgCode) {
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
