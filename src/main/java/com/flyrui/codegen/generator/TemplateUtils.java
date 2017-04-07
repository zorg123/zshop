package com.flyrui.codegen.generator;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtils {
	
	private static Configuration conf;
	private static int tempSeq = 1;
	private static Map utils = new HashMap();
	
	static {
		conf = new Configuration();
		conf.setEncoding(Locale.CHINA,"UTF-8");
		conf.setNumberFormat("0");
	}

	public static Template createTemplate(String content) throws Exception {
		return new Template("ID:" + (tempSeq++), new StringReader(content), conf);
	}
	
	public static Template createTemplate(InputStreamReader inputStreamReader) throws Exception {
		return new Template("ID:" + (tempSeq++),inputStreamReader, conf);
	}
	
	public static Map getUtilMethods() {
		return utils;
	}
	
	public static void addUtils(Map root) {
		root.put("ut", utils);
	}
}
