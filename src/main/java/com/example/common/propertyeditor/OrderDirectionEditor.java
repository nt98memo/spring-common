package com.example.common.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import com.example.common.enumeration.OrderDirection;
import com.example.common.util.EnumUtil;

public class OrderDirectionEditor extends PropertyEditorSupport {

	@Autowired
	private MessageSource messageSource;

	private Locale locale;

	public OrderDirectionEditor(Locale locale) {
		this.locale = locale;
	}

	@Override
	public void setAsText(@Nullable String text) throws IllegalArgumentException {

		if (text != null && !"".equals(text)) {
			try {
				OrderDirection value = EnumUtil.get(OrderDirection.class, Integer.parseInt(text));
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
		OrderDirection order = (OrderDirection) getValue();
		if (order == null) {
			return "";
		}
		return String.valueOf(order.ordinal());
	}

}
