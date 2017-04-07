package com.flyrui.sys.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.pojo.sys.TbOrganation;
import com.flyrui.exception.FRException;
import com.flyrui.sys.service.OrganationService;

public class OrganationAction extends BaseAction {	

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 4657873450414687250L;

	public TbOrganation tbOrganation = new TbOrganation();
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
    private static final Logger log = Logger.getLogger(OrganationAction.class);
    
    public OrganationService getOrganationService(){
    	return (OrganationService)SpringBeans.getBean("organationService");
    }



	/**
     * 
     * 删除
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String delete(){
    	OrganationService  organationService = getOrganationService();    	 
    	setResult(organationService.delete(tbOrganation));
    	return SUCCESS;
    }
    
    /**
     * 
     * 更新一条
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String update(){
    	OrganationService  organationService = getOrganationService(); 	
    	setResult(organationService.update(tbOrganation));
    	return SUCCESS;
    }
    
    /**
     * 
     * 插入一条
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String insert(){
    	OrganationService  organationService = getOrganationService(); 
    	tbOrganation.setCreate_date(new Date());
    	setResult(organationService.insert(tbOrganation));
    	return SUCCESS;
    }
    
    /**
     * 
     * 分页查询组织信息
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryPageList(){
    	OrganationService  organationService = getOrganationService(); 
    	setResult(organationService.getPagerListByCon(tbOrganation,page,rows));    	
    	return SUCCESS;
    }
    
    /**
     * 
     * 查询组织信息列表
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryList(){
    	OrganationService  organationService = getOrganationService(); 
    	setResult(organationService.selectList(tbOrganation));    	
    	return SUCCESS;
    }

    /**
     * 
     * 查询组织信息列表
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String queryTreeList() throws FRException{
    	OrganationService  organationService = getOrganationService(); 
    	List retList = organationService.selectList(tbOrganation);
    	Map propertiesMap = new HashMap();
    	propertiesMap.put("org_id", "id");
	    propertiesMap.put("org_name", "text");
	    retList = CommonUtils.transformList(retList, propertiesMap);
    	setResult(retList);    	
    	return SUCCESS;
    }
}
