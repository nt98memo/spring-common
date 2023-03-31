package com.example.common.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.common.enumeration.OrderDirection;
import com.example.common.util.EnumUtil;

public class StringToOrderDirectionConverter implements Converter<String, OrderDirection> {

    @Override
    public OrderDirection convert(String text) {

		if (text != null && !"".equals(text)) {
			try {
				OrderDirection value = EnumUtil.get(OrderDirection.class, Integer.parseInt(text));
				return value;
			} catch (Exception e) {
				throw new IllegalArgumentException("Wrong value entered");
			}
		} else {
			return null;
		}

    }

}