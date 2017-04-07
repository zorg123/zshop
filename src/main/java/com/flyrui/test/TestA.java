package com.flyrui.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyrui.sys.service.LoginService;

public class TestA
{    
    public static Logger loger = Logger.getLogger(TestA.class);
    public static void main(String[] args){
        new TestA().testIt();
    }
    
    public void testIt() {
        String[] Configurations = { "config/spring/applicationContext.xml" };
        ApplicationContext context = new ClassPathXmlApplicationContext(
                Configurations);
        LoginService dao = (LoginService)context.getBean("loginService");
        //dao.insertA(true); 
        String claimLineId = "";//dao.getA();
        //List l = dao.getA();
        try{
        //dao.insertA(true);
        }catch(Exception ex){
            loger.error(ex.getMessage(), ex);
        }
        
        System.out.println(claimLineId);
       // System.out.println(l);
    }
    
}
