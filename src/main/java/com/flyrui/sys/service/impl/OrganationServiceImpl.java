package com.flyrui.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbOrganation;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.sys.service.OrganationService;

@Service(value="organationService")
public class OrganationServiceImpl extends BaseService<TbOrganation> implements OrganationService {

	public OrganationServiceImpl(){
		   super.setNameSpace("tb_organation");
	}
}
