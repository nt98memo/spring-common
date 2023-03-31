package com.example.common.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

public class TimeEditor extends PropertyEditorSupport {

	@Autowired
	private MessageSource messageSource;

	private Locale locale;

	public TimeEditor(Locale locale) {
		this.locale = locale;
	}

	@Override
	public void setAsText(@Nullable String text) throws IllegalArgumentException {

		if (text != null && !"".equals(text)) {
			try {
				Time t = Time.valueOf(text + ":00");
				setValue(t);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(messageSource.getMessage("typeMismatch.java.sql.Time", null, "Please enter the HH:MM format", this.locale));
			}
		} else {
			setValue(null);
		}

	}

	@Override
	public String getAsText() {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		Time value = (Time) getValue();
		if (value == null) {
			return "";
		}
		return format.format(value);
	}

}
