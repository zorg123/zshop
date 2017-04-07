package com.flyrui.sys.service;

import java.util.List;
import java.util.Map;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.User;

public interface UserService {
	
	public int insert(User user);
	
	public int update(User user);
	
	public int delete(User user);
	
	public List<User> getListByCon(User user);
	
	public PageModel getPagerListByCon(User user,int pageNo,int pageSize);
	
	public int saveUserRole(String user_id,String role_id);
	
	public int deleteUserRole(String user_id,String role_id);
	
	public int modifyPwd(Map<String,String> param);	
	
	public int batchInsert(List<User> user);
	
	public int deleteRolesByUser(String user_id);
	
}
