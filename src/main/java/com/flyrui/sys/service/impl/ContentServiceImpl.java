package com.flyrui.sys.service.impl;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.sys.TbContent;
import com.flyrui.sys.service.ContentService;

@Service(value="contentService")
public class ContentServiceImpl extends BaseService<TbContent> implements ContentService {

	public ContentServiceImpl(){
		   super.setNameSpace("com.flyrui.dao.mapper.TbContentMapper");
	}
}
