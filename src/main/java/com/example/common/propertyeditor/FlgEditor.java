package com.example.common.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import com.example.common.enumeration.Flg;
import com.example.common.util.EnumUtil;

public class FlgEditor extends PropertyEditorSupport {

	@Autowired
	private MessageSource messageSource;

	private Locale locale;

	public FlgEditor(Locale locale) {
		this.locale = locale;
	}

	@Override
	public void setAsText(@Nullable String text) throws IllegalArgumentException {

		if (text != null && !"".equals(text)) {
			try {
				Flg value = EnumUtil.get(Flg.class, Integer.parseInt(text));
				setValue(value);
			} catch (Exception e) {
				throw new IllegalArgumentException(messageSource.getMessage("typeMismatch.java.lang.Enum", null, "Wrong value entered", this.locale));
			}
		} else {
			setValue(null);
		}

	}

	@Override
	public String getAsText() {
		Flg flg = (Flg) getValue();
		if (flg == null) {
			return "";
		}
		return String.valueOf(flg.ordinal());
	}

}
