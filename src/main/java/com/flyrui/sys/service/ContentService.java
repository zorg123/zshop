package com.flyrui.sys.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbContent;

public interface ContentService {
	
	public int insert(TbContent content);
	
	public int update(TbContent content);
	
	public int delete(TbContent content);
	
	public List<TbContent> selectList(TbContent content);	
	
	public PageModel getPagerListByCon(TbContent org,int pageNo,int pageSize);
	
}
