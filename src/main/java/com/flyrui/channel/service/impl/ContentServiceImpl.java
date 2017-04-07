package com.flyrui.channel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.channel.service.ContentExtService;
import com.flyrui.channel.service.ContentService;
import com.flyrui.channel.service.ContentTxtService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrContent;
import com.flyrui.dao.pojo.channel.FrContentExt;
import com.flyrui.dao.pojo.channel.FrContentTxt;

@Service(value="frContentService")
public class ContentServiceImpl extends BaseService<FrContent> implements ContentService {	
   public ContentServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.FrContentMapper");
   }
   
   /**
    * 查询栏目信息列表
    * @param FrContent
    * @return
    */
	public List<FrContent> queryContentInfoList(FrContent frContent) {
		return super.queryById("queryAllWithExt",frContent);
	}
	
	public PageModel getPagerListByCon(FrContent frContent,int pageNo,int pageSize){
		return getPagerList(frContent,getNameSpace()+".queryAllWithExt",pageNo,pageSize) ;
	}
	
	@Transactional
	public int insert(FrContent frContent,FrContentTxt contentTxt){
		String seqId = getSequence("seq_content_id");
		frContent.setContent_id(Integer.valueOf(seqId));
		int cnt = super.insert(frContent);
		ContentExtService  contentExtService = (ContentExtService)SpringBeans.getBean("contentExtService");
		FrContentExt frContentExt = (FrContentExt)frContent;
		contentTxt.setContent_id(frContent.getContent_id());
		ContentTxtService  contentTxtService = (ContentTxtService)SpringBeans.getBean("contentTxtService");
		contentTxtService.insert(contentTxt);
		return contentExtService.insert(frContentExt);
	}
	
	@Transactional
	public int update(FrContent frContent,FrContentTxt contentTxt){		
		super.update(frContent);
		ContentExtService  contentExtService = (ContentExtService)SpringBeans.getBean("contentExtService");
		FrContentExt frContentExt = (FrContentExt)frContent;
		ContentTxtService  contentTxtService = (ContentTxtService)SpringBeans.getBean("contentTxtService");
		contentTxt.setContent_id(frContent.getContent_id());
		contentTxtService.update(contentTxt);
		return contentExtService.update(frContentExt);
	}
	
	@Transactional
	public int delete(FrContent frContent){	
		ContentExtService  contentExtService = (ContentExtService)SpringBeans.getBean("contentExtService");
		FrContentExt frContentExt = (FrContentExt)frContent;
		contentExtService.delete(frContentExt);
		
		ContentTxtService  contentTxtService = (ContentTxtService)SpringBeans.getBean("contentTxtService");
		FrContentTxt frContentTxt = new FrContentTxt();
		frContentTxt.setContent_id(frContent.getContent_id());
		contentTxtService.delete(frContentTxt);
		
		return super.delete(frContent);
	}
 }
