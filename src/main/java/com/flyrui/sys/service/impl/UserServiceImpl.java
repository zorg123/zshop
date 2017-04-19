package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.sys.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
	
   @Autowired
   AccoutInfoService accoutInfoService;
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
   
   @Transactional
   @Override
   public int insert(User user){	   
	   super.insert(user);
	   AccoutInfoDto accoutInfo = new AccoutInfoDto();
   	   accoutInfo.setUser_id(Integer.valueOf(user.getUser_id()));
   	   accoutInfo.setBonus_coin(0d);
   	   accoutInfo.setElect_coin(0d);
   	   accoutInfo.setReconsmp_coin(0d);
   	   return accoutInfoService.insert(accoutInfo);
   }
   
   public List<User> selectUserNetTree(User user){
	   return baseDao.selectList(getNameSpace()+".selectUserNetTree",user);
   }

	@Override
	@Transactional
	public void activeUser(String[] ids, User loginUser) {
		for(String id : ids){
			Map param = new HashMap();
			param.put("in_id", id);
			param.put("login_userid", loginUser.getUser_id());
			baseDao.update(getNameSpace()+".activeUser",param);
		}	
	}
   
   
}
