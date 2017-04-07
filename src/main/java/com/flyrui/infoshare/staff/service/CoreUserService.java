package com.flyrui.infoshare.staff.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.staff.pojo.CoreUser;     		

public interface CoreUserService {
		
	
	public int insert(CoreUser coreUser);
	
	public int update(CoreUser coreUser);
	
	public int delete(CoreUser coreUser);
	
	public List<CoreUser> getListByCon(CoreUser coreUser);
	
	public PageModel getPagerListByCon(CoreUser coreUser,int pageNo,int pageSize);	
}
