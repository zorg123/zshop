package com.flyrui.channel.service.impl;

import org.springframework.stereotype.Service;

import com.flyrui.channel.service.ContentExtService;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.channel.FrContentExt;

@Service(value="contentExtService")
public class ContentExtServiceImpl extends BaseService<FrContentExt> implements ContentExtService {	
   public ContentExtServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.FrContentExtMapper");
   }
 }
