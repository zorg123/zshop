package com.flyrui.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtils {

	public static final Exception EXCEPTION = new Exception();

	public static void copyProperties(Object target, Object src) throws Exception {
		if (target instanceof Map) {
			Map targetMap = (Map) target;
			if (src instanceof Map) {
				targetMap.putAll((Map) src);
			} else
				targetMap.putAll(PropertyUtils.describe(src));
		} else
			org.apache.commons.beanutils.BeanUtils.copyProperties(target, src);
	}
	public static void setProperty(Object bean, String name, Object value) {
		try {
			PropertyUtils.setProperty(bean, name, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static Object getProperty(Object bean, String name, Object replace) {
		try {
			return PropertyUtils.getProperty(bean, name);
		} catch (Exception e) {
			if (replace == EXCEPTION)
				throw new RuntimeException(e);
			return replace;
		}
	}
	public static Object getProperty(Object bean, String name) {
		return getProperty(bean, name, EXCEPTION);
	}
	public static List toList(Object bean, String[] fields) {
		List values = new ArrayList();
		for (int i = 0; i < fields.length; i++) {
			values.add(getProperty(bean, fields[i], ""));
		}
		return values;
	}
	public static void changeMapKey(Map map, String orgKey, String targetKey) {
		if (map == null)
			return;
		if (map.containsKey(orgKey)) {
			map.put(targetKey, map.get(orgKey));
			map.remove(orgKey);
		}
	}
}
