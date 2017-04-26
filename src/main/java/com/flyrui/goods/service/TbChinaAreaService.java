package com.flyrui.goods.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.goods.pojo.TbChinaArea;     		

public interface TbChinaAreaService {
		
	
	public int insert(TbChinaArea tbChinaArea);
	
	public int update(TbChinaArea tbChinaArea);
	
	public int delete(TbChinaArea tbChinaArea);
	
	public List<TbChinaArea> getListByCon(TbChinaArea tbChinaArea);
	
	public PageModel getPagerListByCon(TbChinaArea tbChinaArea,int pageNo,int pageSize);	
}
