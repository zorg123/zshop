package com.flyrui.financMgmt.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.financMgmt.pojo.UserDirectRecommend;     		

public interface UserDirectRecommendService {
		
	
	public int insert(UserDirectRecommend userDirectRecommend);
	
	public int update(UserDirectRecommend userDirectRecommend);
	
	public int delete(UserDirectRecommend userDirectRecommend);
	
	public List<UserDirectRecommend> getListByCon(UserDirectRecommend userDirectRecommend);
	
	public PageModel getPagerListByCon(UserDirectRecommend userDirectRecommend,int pageNo,int pageSize);	
}
