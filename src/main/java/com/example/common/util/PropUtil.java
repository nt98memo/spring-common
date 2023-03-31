package com.example.common.util;

import org.apache.commons.beanutils.PropertyUtils;

public class PropUtil {

	public static void copyProperties(Object src, Object dest, String[] propertyNameArray) {

		try {
			for (String propertyName : propertyNameArray) {
				PropertyUtils.setProperty(dest, propertyName, PropertyUtils.getProperty(src, propertyName));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
