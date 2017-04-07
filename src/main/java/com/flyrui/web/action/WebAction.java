package com.flyrui.web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flyrui.channel.service.ChannelService;
import com.flyrui.channel.service.ContentService;
import com.flyrui.channel.service.ContentTxtService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.service.CommonService;
import com.flyrui.dao.pojo.channel.FrChannel;
import com.flyrui.dao.pojo.channel.FrContent;
import com.flyrui.dao.pojo.channel.FrContentTxt;
import com.flyrui.framework.annotation.SessionCheckAnnotation;

public class WebAction extends BaseAction {	

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(WebAction.class);
	
	public String channelId;
	
	public String contentId;
	
	public String flag;
	
	public String pid;
	
	public String key;
	
	public FrChannel channel = new FrChannel(); 
    
    public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	@SessionCheckAnnotation(needCheckSession="false")
    public String index(){ 
    	//查询头部导航
		if(channelId==null || "".equals(channelId)){
			channelId = "1";
		}
    	ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    	FrChannel frChannel = new FrChannel();
    	frChannel.setParent_id(-1);
    	List<FrChannel> headChannelList = channelService.queryChannelInfoList(frChannel);
    	
    	//查询首页图片集
    	frChannel.setParent_id(9);
    	List<FrChannel> picChannelList = channelService.queryChannelInfoList(frChannel);
    	
    	//查询首页友情链接
    	frChannel.setParent_id(10);
    	List<FrChannel> linkList = channelService.queryChannelInfoList(frChannel);
    	
    	setResult("headNavList",headChannelList);
    	setResult("picList",picChannelList);
    	setResult("linkList",linkList);
    	return "index";
   } 
    

    @SessionCheckAnnotation(needCheckSession="false")
    public String commonNavHeader(){ 
    	//查询头部导航
    	ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    	FrChannel frChannel = new FrChannel();
    	frChannel.setParent_id(-1);
    	List<FrChannel> headChannelList = channelService.queryChannelInfoList(frChannel); 
    	setResult("headNavList",headChannelList);    	
    	return "commonNavHeader";
   }
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String showList(){ 
    	
    	//查询某一个渠道下面的所有内容
    	ContentService contentService = (ContentService)SpringBeans.getBean("frContentService");
    	FrContent frContent = new FrContent();
    	Integer cId;
    	try{
    		cId = Integer.parseInt(channelId);
    	}catch(Exception ex){
    		log.error("查询列表出错，传入不正确的Id",ex);
    		return "showList";
    	}
    	frContent.setChannel_id(cId);
    	List<FrContent> contentList = contentService.queryContentInfoList(frContent);
    	
    	//查询首页图片集
    	channel.setChannel_id(cId);
    	ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    	List<FrChannel> channelList = channelService.queryChannelInfoList(channel);
    	if(channelList!=null && channelList.size()>0){
    		channel = channelList.get(0);
    	}
    	setResult("conetentList",contentList);    	
    	return "showList";
   } 
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String showContentDetail(){ 
    	
    	//查询内容的详细信息
    	ContentService contentService = (ContentService)SpringBeans.getBean("frContentService");
    	ContentTxtService contentTxtService = (ContentTxtService)SpringBeans.getBean("contentTxtService");
    	FrContent frContent = new FrContent();
    	Integer cId;
    	try{
    		cId = Integer.parseInt(contentId);
    	}catch(Exception ex){
    		log.error("查询列表出错，传入不正确的Id",ex);
    		return "showContentDetail";
    	}
    	frContent.setContent_id(cId);
    	frContent.setStatus("2");
    	FrContent content = new FrContent();
    	FrContentTxt contentTxt = new FrContentTxt();
    	List<FrContent> contentList = contentService.queryContentInfoList(frContent);
    	if(contentList!=null && contentList.size()>0){
    		content = contentList.get(0);
    	}
    	contentTxt.setContent_id(frContent.getContent_id());
    	List<FrContentTxt> contentTxtList = contentTxtService.getListByCon(contentTxt);
    	if(contentTxtList!=null && contentTxtList.size()>0){
    		contentTxt = contentTxtList.get(0);
    	}
    	
    	//查询本渠道信息
    	channel.setChannel_id(content.getChannel_id());
    	ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    	List<FrChannel> channelList = channelService.queryChannelInfoList(channel);
    	if(channelList!=null && channelList.size()>0){
    		channel = channelList.get(0);    		
    	} 	
    	
    	setResult("content",content); 
    	setResult("contentTxt",contentTxt);   
    	return "showContentDetail";
   }
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String commonFooter(){ 
    	CommonService commonService  = (CommonService)SpringBeans.getBean("commonService");
    	int visitCount = commonService.queryWebVisitCount();
    	setResult("visitCount",visitCount);    	
    	return "commonFooter";
   }
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String showDetailWithSub(){ 
    	
    	//查询某一个渠道下面的所有内容
    	ContentService contentService = (ContentService)SpringBeans.getBean("frContentService");
    	FrContent frContent = new FrContent();
    	Integer cId;
    	try{
    		cId = Integer.parseInt(channelId);
    	}catch(Exception ex){
    		log.error("查询列表出错，传入不正确的Id",ex);
    		return "showDetailWithSub";
    	}
    	frContent.setChannel_id(cId);
    	List<FrContent> contentList = contentService.queryContentInfoList(frContent);
    	if("1".equals(flag)){
    		//查询内容
    		FrContentTxt contentTxt = new FrContentTxt();
    		if(contentList!=null && contentList.size()>0){
        		FrContent frC = contentList.get(0);   
        		contentTxt.setContent_id(frC.getContent_id());
        		ContentTxtService contentTxtService = (ContentTxtService)SpringBeans.getBean("contentTxtService");
            	List<FrContentTxt> contentTxtList = contentTxtService.getListByCon(contentTxt);
            	if(contentTxtList!=null && contentTxtList.size()>0){
            		contentTxt = contentTxtList.get(0);
            		setResult("contentTxt",contentTxt);
            	}
        	} 	
    		
    	}
    	
    	//查询本渠道信息及下级渠道
    	channel.setChannel_id(cId);
    	ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    	List<FrChannel> channelList = channelService.queryChannelInfoList(channel);
    	if(channelList!=null && channelList.size()>0){
    		channel = channelList.get(0);    		
    	}
    	if(pid!=null && !"".equals(pid)){    		
    		try{
        		Integer pIdInt = Integer.parseInt(pid);
        		FrChannel frChannel = new FrChannel();
        		frChannel.setParent_id(pIdInt);
        		channelList = channelService.queryChannelInfoList(frChannel);
        		if(channelList!=null && channelList.size()>0){
        			setResult("subMenuList",channelList);
        		}
        	}catch(Exception ex){
        		log.error("查询列表出错，传入不正确的Id",ex);
        		return "showDetailWithSub";
        	}
    	}
    	setResult("conetentList",contentList);    	
    	return "showDetailWithSub";
   } 
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String search(){ 
    	List<FrContent> contentList = new ArrayList<FrContent>();
    	List<FrChannel> channelList = new ArrayList<FrChannel>();
    	if(key != null  && !"".equals(key.trim())){
    		key = key.trim();
    		//根据key 查询名字
    		ContentService contentService = (ContentService)SpringBeans.getBean("frContentService");
    		FrContent frContent = new FrContent();
    		frContent.setTitle("%"+key+"%");
    		contentList = contentService.queryContentInfoList(frContent);

    		//根据key 查询内容
    		FrChannel frChannel = new FrChannel();
    		frChannel.setChannel_name("%"+key+"%");
    		ChannelService channelService = (ChannelService)SpringBeans.getBean("channelService");
    		channelList = channelService.queryChannelInfoList(frChannel);
    	}
    	setResult("channelList",channelList);  
    	setResult("contentList",contentList);    	
    	return "search";
   }
    
}
