package com.flyrui.channel.service.impl;

import org.springframework.stereotype.Service;

import com.flyrui.channel.service.ContentTxtService;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.channel.FrContentTxt;

@Service(value="contentTxtService")
public class ContentTxtServiceImpl extends BaseService<FrContentTxt> implements ContentTxtService {	
   public ContentTxtServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.FrContentTxtMapper");
   }
 }
