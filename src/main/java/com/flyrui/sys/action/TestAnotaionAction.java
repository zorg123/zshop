package com.flyrui.sys.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.flyrui.common.action.BaseAction;

@ParentPackage("frcms_default")
@Namespace("/test") //访问路径的包名
@Results( { 
		@Result(name = "success", location = "/index.jsp"), 
        @Result(name = "error", location = "/hello.jsp") }) 
@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class TestAnotaionAction extends BaseAction{
	
	@Action(value="helloWord")
	public String helloWord(){
		
		return SUCCESS;
	}
}
