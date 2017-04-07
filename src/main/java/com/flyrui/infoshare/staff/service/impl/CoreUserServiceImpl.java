package com.flyrui.infoshare.staff.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.staff.pojo.CoreUser;     		
import com.flyrui.infoshare.staff.pojo.InfoUserExt;
import com.flyrui.infoshare.staff.service.CoreUserService;     		


@Service(value="coreUserService")
public class CoreUserServiceImpl extends BaseService<CoreUser> implements CoreUserService {	
	public CoreUserServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.staff.dao.mapper.CoreUserMapper");
	}
}
