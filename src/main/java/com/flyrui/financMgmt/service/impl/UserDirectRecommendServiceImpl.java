package com.flyrui.financMgmt.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.financMgmt.pojo.UserDirectRecommend;     		
import com.flyrui.financMgmt.service.UserDirectRecommendService;     		


@Service(value="userDirectRecommendService")
public class UserDirectRecommendServiceImpl extends BaseService<UserDirectRecommend> implements UserDirectRecommendService {	
	public UserDirectRecommendServiceImpl(){
		super.setNameSpace("com.flyrui.financMgmt.pojo.UserDirectRecommendMapper");
	}
}
