package com.flyrui.channel.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.channel.service.ChannelService;
import com.flyrui.channel.service.ContentService;
import com.flyrui.channel.service.ContentTxtService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrChannel;
import com.flyrui.dao.pojo.channel.FrContent;
import com.flyrui.dao.pojo.channel.FrContentTxt;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;

public class ChannelAction extends BaseAction {	
		
    /**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ChannelAction.class);
	    
    public String q;
    
    public FrChannel channel = new FrChannel();   
    
    public FrContent content = new FrContent();
    
    public FrContentTxt contentTxt = new FrContentTxt();
    
    public int rows; //每页大小
	
	public int page;//当前页号
	
	public PageModel pageModel;
	
	public String ids;    
    
    public PageModel getPageModel(){
    	return this.pageModel;
    }
    
    public FrChannel getChannel(){
    	return this.channel;
    }
    
    public FrContent getContent(){
    	return this.content;
    }
    
    public FrContentTxt getContentTxt(){
    	return this.contentTxt;
    }
    
    public ChannelService getChannelService(){
    	return (ChannelService)SpringBeans.getBean("channelService");
    }
    
    public ContentService getContentService(){
    	return (ContentService)SpringBeans.getBean("frContentService");
    }
    
    public String qryChannelList() throws FRException{
    	ChannelService channelService = getChannelService();
    	if(channel.getParent_id()==null){
    		FRException frException = new FRException(new FRError(ErrorConstants.PARAM_ERROR)); 
    		throw frException;
    	}
    	List<FrChannel> retList= channelService.queryChannelInfoList(channel);
    	setResult(retList);
    	return SUCCESS;
    }
    
    public String qryChannelPageList() throws FRException{
    	ChannelService channelService = getChannelService();
    	pageModel= channelService.getPagerListByCon(channel,page,rows);
    	return "page";
    }
    
    public String editChannel()throws FRException{
    	ChannelService channelService = getChannelService();
    	if(channel.getChannel_id()!= null){
    		List<FrChannel> retList= channelService.queryChannelInfoList(channel);
        	if(retList.size()>0){
        		channel = retList.get(0);        		
        	}else {
        		new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
        	}
    	}    	
    	return "editChannel";
    } 
    
    public String updateChannel()throws FRException{
    	ChannelService channelService = getChannelService();
    	if(channel.getChannel_id()== null){
    		channelService.insert(channel);
    	}else{
    		channelService.update(channel);
    	} 
    	Map<String, String> m = new HashMap<String,String>();
    	m.put("code", "0");
    	setResult(m);
    	return SUCCESS;
    } 
    
    public String deleteChannel()throws FRException{
    	ChannelService channelService = getChannelService();
    	if(channel.getChannel_id()== null){
    		FRException frException = new FRException(new FRError(ErrorConstants.PARAM_ERROR)); 
    		throw frException;
    	}    	
    	channelService.delete(channel);    	 
    	Map<String, String> m = new HashMap<String,String>();
    	m.put("code", "0");
    	setResult(m);
    	return SUCCESS;
    } 
    
    
    
    public String qryContentPageList() throws FRException{
    	ContentService contentService = getContentService();
    	pageModel= contentService.getPagerListByCon(content,page,rows);
    	return "page";
    }
    
    public String editContent()throws FRException{
    	ContentService contentService = getContentService();
    	if(content.getContent_id()!= null){
    		List<FrContent> retList= contentService.queryContentInfoList(content);
        	if(retList.size()>0){
        		content = retList.get(0);
        		ContentTxtService contentTxtService =  (ContentTxtService)SpringBeans.getBean("contentTxtService");
        		contentTxt.setContent_id(content.getContent_id());
        		List<FrContentTxt> contentList = contentTxtService.selectList(contentTxt);
        		if(contentList!=null && contentList.size()>0){
        			contentTxt = contentList.get(0);
        		}        		
        	}else {
        		new FRException(new FRError(ErrorConstants.NO_DATA_FOUND));
        	}
    	}    	
    	return "editContent";
    } 
    
    public String updateContent()throws FRException{
    	ContentService contentService = getContentService();
    	if(content.getChannel_id()== null){
    		FRException frException = new FRException(new FRError(ErrorConstants.PARAM_ERROR)); 
    		throw frException;
    	}
    	if(content.getContent_id()== null){
    		contentService.insert(content,contentTxt);
    	}else{
    		contentService.update(content,contentTxt);
    	} 
    	Map<String, String> m = new HashMap<String,String>();
    	m.put("code", "0");
    	setResult(m);
    	return SUCCESS;
    } 
    
    public String deleteContent()throws FRException{
    	ContentService contentService = getContentService();
    	if(content.getChannel_id()== null){
    		FRException frException = new FRException(new FRError(ErrorConstants.PARAM_ERROR)); 
    		throw frException;
    	}    	
    	contentService.delete(content);    	 
    	Map<String, String> m = new HashMap<String,String>();
    	m.put("code", "0");
    	setResult(m);
    	return SUCCESS;
    } 
}
