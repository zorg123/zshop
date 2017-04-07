package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.sys.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends BaseService<User> implements UserService {	
   public UserServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.pojo.sys.tb_user");
   }
   
   public int saveUserRole(String user_id,String role_id){
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   userRoleMap.put("role_id", role_id);
	   userRoleMap.put("create_date", new Date());
	   return baseDao.update(getNameSpace()+".saveUserRole", userRoleMap);
   }
   
   public int deleteUserRole(String user_id,String role_id){	
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   userRoleMap.put("role_id", role_id);
	   return baseDao.update(getNameSpace()+".deleteUserRole", userRoleMap);
   }
   public int deleteRolesByUser(String user_id){	
	   Map userRoleMap = new HashMap();
	   userRoleMap.put("user_id", user_id);
	   return baseDao.update(getNameSpace()+".deleteRolesByUser", userRoleMap);
   }
   
   public int modifyPwd(Map<String,String> param){
	   return baseDao.update(getNameSpace()+".modifyPwd", param);
   }
   
}
