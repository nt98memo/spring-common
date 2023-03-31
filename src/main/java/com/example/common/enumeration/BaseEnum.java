package com.example.common.enumeration;

import java.util.Locale;

import org.springframework.context.MessageSource;

public interface BaseEnum {

	public abstract String msgCode();

	public abstract String label(MessageSource messageSource, Locale locale);

}
