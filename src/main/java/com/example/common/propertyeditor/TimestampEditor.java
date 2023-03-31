package com.example.common.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

public class TimestampEditor extends PropertyEditorSupport {

	@Autowired
	private MessageSource messageSource;

	private Locale locale;

	public TimestampEditor(Locale locale) {
		this.locale = locale;
	}

	@Override
	public void setAsText(@Nullable String text) throws IllegalArgumentException {

		if (text != null && !"".equals(text)) {
			try {
				DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
				Timestamp value = new Timestamp(fmt.parse(text).getTime());
				setValue(value);
			} catch (Exception e) {
				throw new IllegalArgumentException(messageSource.getMessage("typeMismatch.java.sql.Date", null, "Please enter the yyyy/mm/dd format", this.locale));
			}
		} else {
			setValue(null);
		}

	}

	@Override
	public String getAsText() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Timestamp value = (Timestamp) getValue();
		if (value == null) {
			return "";
		}
		return format.format(value);
	}

}
