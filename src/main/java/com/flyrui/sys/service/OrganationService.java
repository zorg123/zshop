package com.flyrui.sys.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbOrganation;

public interface OrganationService {
	
	public int insert(TbOrganation org);
	
	public int update(TbOrganation org);
	
	public int delete(TbOrganation org);
	
	public List<TbOrganation> selectList(TbOrganation org);	
	
	public PageModel getPagerListByCon(TbOrganation org,int pageNo,int pageSize);
	
}
