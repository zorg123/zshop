package com.flyrui.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flyrui.framework.web.filter.vo.PageLogVO;

@Service(value="commonService")
public class CommonService extends BaseService<Map>{
	public CommonService(){
		   super.setNameSpace("com.flyrui.dao.mapper.common");
	}
	
	/**
	 * 
	 * 插入页面访问日志
	 * 
	 * @param pageLogVO
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Nov 3, 2014
	 */
	public int insertEventLog(PageLogVO pageLogVO){
		return baseDao.insert(getNameSpace()+".insertEventLog",pageLogVO);
	}
	
	/**
	 * 
	 * 查询页面总访问次数
	 * 
	 * @param pageLogVO
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Nov 3, 2014
	 */
	public int queryWebVisitCount(){
		int retI = 0;
		List retList =  baseDao.selectList(getNameSpace()+".queryWebVisitCount",new HashMap());
		if(retList!=null && retList.size()>0){
			Map m = (Map)retList.get(0);
			try{
			retI = Integer.parseInt((String)m.get("cf_value"));
			}catch(Exception ex){
				
			}
		}
		return retI;
	}
	
	/**
	 * 
	 * 更新页面总访问次数
	 * 
	 * @param pageLogVO
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Nov 3, 2014
	 */
	public int updateWebVisitCount(){		
		return baseDao.update(getNameSpace()+".updateWebVisitCount",new HashMap());
	
	}
	
	/**
	 * 
	 * 获取配置的参数列表
	 * 
	 * @param pageLogVO
	 * @return [返回类型说明]
	 * 
	 * rover.lee
	 * Nov 3, 2014
	 */
	public List queryFrCfgList(){		
		return baseDao.selectList(getNameSpace()+".queryFrCfgList",new HashMap());
	
	}
}
