package com.flyrui.sys.service;

import java.util.List;
import java.util.Map;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.FRException;

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
	
	public List<User> selectUserNetTree(User user);
	
	public void activeUser(List<User> ids,User loginUser)  throws FRException;
	public int insertRegister(User user);
	public int delUnActiveUser(User user);
	public void checkCurrentChild(User loginUser,User user) throws FRException;
	
	public List<Map> queryUserLevelShareout();
	
	public List<Map> queryUserMonthGoods(Map<String,String> param);
	public PageModel selectForWaitActiveUser(User user,int pageNo,int pageSize);
	public String[] activeUser2(TbUser tbUser,TbUser beActivedtbUser);
	public List<Map> queryUserGoodsOrder(Map<String,String> param);
	public boolean genSubUser(User curcurrUser2,User currUser);
	public void setUserSessionAttr(User user);
}
