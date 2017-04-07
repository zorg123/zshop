package com.flyrui.sys.service.impl;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.sys.service.RoleService;

@Service(value="roleService")
public class RoleServiceImpl extends BaseService<TbRole> implements RoleService {

	public RoleServiceImpl(){
		   super.setNameSpace("com.flyrui.dao.pojo.sys.tb_role");
	}
	
	public PageModel queryRoleIdByUserCode(User user,int pageNo,int pageSize){		
		return getPagerList(user,getNameSpace()+".queryRoleIdByUserCode",pageNo,pageSize);
	}
	
	public PageModel queryRoleListFilterByUser(TbRole role,int pageNo,int pageSize){		
		return getPagerList(role,getNameSpace()+".queryRoleListFilterByUser",pageNo,pageSize);
	}
}
