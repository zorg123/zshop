package com.flyrui.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;

import org.junit.Test;

public class TestJson {
	
	@Test
	public void testJson(){
		List a = new ArrayList();
		Map m = new HashMap();
		m.put("name", "11");
		a.add("test");
		a.add(m);
		JSONArray b = JSONArray.fromObject(a);		
		System.out.println(b.toString());
		
		System.out.println(UUID.randomUUID());
	}
}
