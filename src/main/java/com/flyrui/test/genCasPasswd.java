package com.flyrui.test;

import org.jasig.cas.authentication.handler.DefaultPasswordEncoder;

public class genCasPasswd {
	public static void main(String[] args){
		DefaultPasswordEncoder d = new DefaultPasswordEncoder("MD5");
		System.out.println(d.encode("123456").toUpperCase());
	}
}
