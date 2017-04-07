package com.flyrui.sys.service;

import java.util.List;
import java.util.Map;

import com.flyrui.dao.pojo.sys.User;

public interface LoginService
{   
   public Map validateLogin(Map param);
   public User queryUserByBankAccount(Map param) ;
   public User queryUserByCasAccount(Map param) ;
}
