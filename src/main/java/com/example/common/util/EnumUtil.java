package com.example.common.util;

import java.lang.reflect.InvocationTargetException;

public class EnumUtil {
	
	@SuppressWarnings("unchecked")
	public static <T extends Enum<?>> T get(Class<T> enumClass, int value) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		T[] objList = (T[])(enumClass.getMethod("values").invoke(null));
		for (T baseEnum : objList) {
			if (baseEnum.ordinal() == value) {
				return baseEnum;
			}
		}
		return null;
	}

}
