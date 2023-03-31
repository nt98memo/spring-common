package com.example.common.validator;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.common.util.LocaleUtil;

import jakarta.persistence.EntityManager;

public class BaseValidator implements Validator {

	@Autowired
	protected ApplicationContext context;

	@Autowired
	protected MessageSource messageSource;

	@Autowired
	protected LocaleUtil localeUtil;

	protected Class<?> formClass;

	private Locale locale = Locale.ENGLISH;

	protected EntityManager entityManager;

	public BaseValidator() {
	}

	public void init(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public boolean supports(Class<?> formClass) {
		this.formClass = formClass;
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getRequestLocale() {
		return localeUtil.getRequestLocale(this.getLocale());
	}

}
