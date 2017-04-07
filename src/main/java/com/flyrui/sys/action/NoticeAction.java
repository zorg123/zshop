package com.flyrui.sys.action;

import org.apache.log4j.Logger;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.pojo.sys.Notice;
import com.flyrui.sys.service.NoticeService;

public class NoticeAction extends BaseAction {	
	
	public Notice notice = new Notice();
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
    private static final Logger log = Logger.getLogger(NoticeAction.class);
    
    private NoticeService noticeService;
   
    
    public void getNoticeService(){
    	noticeService = SpringBeans.getBean("noticeService");
    }	

	/**
     * 
     * 删除一条记录
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String delete(){
    	getNoticeService();    	 
    	setResult(noticeService.delete(notice));
    	return SUCCESS;
    }
    
    /**
     * 
     * 更新一条记录
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String update(){
    	getNoticeService();    	 
    	setResult(noticeService.update(notice));
    	return SUCCESS;
    }
    
    /**
     * 
     * 插入一条记录
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String insert(){
    	getNoticeService();    	 
    	setResult(noticeService.insert(notice));
    	return SUCCESS;
    }
    
    /**
     * 
     * 分页查询信息
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryPageList(){
    	getNoticeService();   
    	setResult(noticeService.getPagerListByCon(notice,page,rows));    	
    	return SUCCESS;
    }
    
    
    /**
     * 
     * 查询详细信息
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryContentDetail(){
    	getNoticeService();   
    	setResult(noticeService.queryNoticeDetail(notice));    	
    	return SUCCESS;
    }
    
    /**
     * 
     * 查询详细信息
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryEffNoticeList(){
    	getNoticeService();   
    	setResult(noticeService.queryEffNoticeList(notice,page,rows));    	
    	return SUCCESS;
    }

}
