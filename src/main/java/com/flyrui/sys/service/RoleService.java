package com.flyrui.sys.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;

public interface RoleService {
	
	public int insert(TbRole role);
	
	public int update(TbRole role);
	
	public int delete(TbRole role);
	
	public List<TbRole> selectList(TbRole role);
	
	public List<TbRole> getListByCon(TbRole role);
	
	public PageModel getPagerListByCon(TbRole role,int pageNo,int pageSize);
	
	public PageModel queryRoleIdByUserCode(User user,int pageNo,int pageSize);
	
	public PageModel queryRoleListFilterByUser(TbRole role,int pageNo,int pageSize);
}
