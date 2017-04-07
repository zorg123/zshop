package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.bean.MenuOptBean;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.SQLMapConstant;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbMenu;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.TbRoleMenu;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRException;
import com.flyrui.sys.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseService<TbMenu> implements MenuService {
	
	public MenuServiceImpl(){
		   super.setNameSpace("tb_menu");
	}
	
	/**
	 * 根据角色查询角色拥有的菜单信息
	 * @param roleId
	 * @return
	 */
    public List<TbMenu> getRootMenuListByRole(String roleId){
        List<TbMenu> listMenu=  baseDao.selectList(SQLMapConstant.GET_ROOT_MENULIST_BY_ROLE, roleId);             
        return listMenu;
    }
    
    /**
	 * 根据角色查询角色拥有的菜单信息
	 * @param roleId
	 * @return
	 */
    public List<TbMenu> getSubMenuListByUpIdAndRole(Map map){
        List<TbMenu> listMenu=  baseDao.selectList(SQLMapConstant.getSubMenuListByUpIdAndRole, map);             
        return listMenu;
    }
    
    
    /**
	 * 根据角色查询角色拥有的菜单信息
	 * @param roleId
	 * @return
	 */
    public List<TbMenu> getRootMenuListByRoles(List<TbRole> tbRoleList){
        List<TbMenu> listMenu=  baseDao.selectList(SQLMapConstant.GET_ROOT_MENULIST_BY_ROLES, tbRoleList);             
        return listMenu;
    } 
 

    /**
     * 
     * 根据菜单Id,角色Id查找子菜单
     *  
     * @param menuId
     * @return [返回类型说明]
     * 
     * Administrator
     * Jul 6, 2012
     */
    public List<TbMenu> getSubMenuListByUpId(Map<String,String> param){
    	List<TbMenu> listMenu =  baseDao.selectList(SQLMapConstant.GET_SUBMENU_LIST_BY_UPID, param);             
        return listMenu;
    }
    
    public List<TbMenu> getSubTwoLevelMenuList(Map<String,String> param){
    	List<TbMenu> listMenu = getSubMenuListByUpId(param);
    	if(listMenu!=null && listMenu.size()>0){
        	for(TbMenu menu : listMenu ){
        		Map<String,String> p = new HashMap<String,String>();
        		p.put("menu_id", String.valueOf(menu.getMenu_id()));
        		p.put("user_id", param.get("user_id"));
        		menu.setSub_menu_list(getSubMenuListByUpId(p));
        	}        	
        }
    	return listMenu;
    }
    
   public Map getRootMenuJsonByRole(String roleId){
	   Map retMap = new HashMap();
	   String retJson= "";
	   String code = ErrorConstants.RETURN_SUCCESS;
	   String msg  = "";
	   try{
		   List source = getRootMenuListByRole(roleId);
		   Map propertiesMap = new HashMap();
		   propertiesMap.put("menu_id", "id");
		   propertiesMap.put("menu_name", "name");
		   propertiesMap.put("menu_url", "url");
		   propertiesMap.put("url_open_type", "url_open_type");
		   retJson =CommonUtils.transformListToJson(source, propertiesMap);
	   }catch(Throwable tr){
		   if(tr instanceof FRException){
			 code = ((FRException)tr).getError().getErrorCode();
			 msg = ((FRException)tr).getMessage();
		   }else {
			   code = ErrorConstants.RETURN_FAIL;
			   msg = tr.getMessage();
		   }
	   }
	   retMap.put("code", code);
	   retMap.put("msg", msg);
	   retMap.put("retValue", retJson);
	   
	   return retMap;
   }
   
   public Map getSubMenuJsontByUpId(Map<String,String> param){
	   
	   Map retMap = new HashMap();
	   String retJson= "";
	   String code = ErrorConstants.RETURN_SUCCESS;
	   String msg  = "";
	   try{
		   
		   List source = getSubMenuListByUpId(param);
		   Map propertiesMap = new HashMap();
		   propertiesMap.put("menu_id", "id");
		   propertiesMap.put("menu_name", "name");
		   propertiesMap.put("menu_url", "url");
		   propertiesMap.put("url_open_type", "url_open_type");
		   retJson =CommonUtils.transformListToJson(source, propertiesMap);
	   }catch(Throwable tr){
		   if(tr instanceof FRException){
			 code = ((FRException)tr).getError().getErrorCode();
			 msg = ((FRException)tr).getMessage();
		   }else {
			   code = ErrorConstants.RETURN_FAIL;
			   msg = tr.getMessage();
		   }
	   }
	   retMap.put("code", code);
	   retMap.put("msg", msg);
	   retMap.put("retValue", retJson);
	   
	   return retMap;
   }
   
   /**
    * 
    * 根据菜单Id查找子菜单
    *  
    * @param menuId
    * @return [返回类型说明]
    * 
    * Administrator
    * Jul 6, 2012
    */
   public PageModel getSubMenuPagerListByUpId(String menuId,int pageNo,int pageSize){
	   TbMenu tbMenu = new TbMenu();
	   tbMenu.setMenu_id(Integer.valueOf(menuId));
	   PageModel pageModel = getPagerList(tbMenu,"getSubMenuListByUpId2",pageNo,pageSize);             
       return pageModel;
   }
   
   /**
    * 
    * 根据菜单Id查找子菜单，不分页
    *  
    * @param menuId
    * @return [返回类型说明]
    * 
    * Administrator
    * Jul 6, 2012
    */
   public List getSubMenuNoRoleListByUpId(String menuId){
	   TbMenu tbMenu = new TbMenu();
	   tbMenu.setMenu_id(Integer.valueOf(menuId));
	   List retList = baseDao.selectList(getNameSpace()+".getSubMenuListByUpId2",tbMenu);             
       return retList;
   }
   
   /**
    * 对Menu进行增，删，改
    * @param menuOptBean
    * @return
    */
   @Transactional
   public Map OptMenuList(MenuOptBean menuOptBean){
	   int totalCount =0;
	   int insertcount = 0;
	   int deleteCount = 0;
	   int updateCount = 0;
	   if(menuOptBean!=null){
		   List<TbMenu> insertMenuList = menuOptBean.getInsertList();	    	 
	        for(TbMenu m : insertMenuList){
	        		m.setCreate_date(new Date());
	        		m.setModify_date(new Date());
		    		insert(m);
		    		insertcount++;
		    }
	    	
	    	List<TbMenu> deleteMenuList = menuOptBean.getDeleteList();
	    	for(TbMenu m : deleteMenuList){
	    		delete(m);
	    		deleteCount++;
	    	}
	    	
	    	List<TbMenu> updateMenuList = menuOptBean.getUpdateList();
	    	for(TbMenu m : updateMenuList){
	    		m.setModify_date(new Date());
	    		update(m);
	    		updateCount++;
	    	}		   
	   }	
	   Map<String, String> retMap  = new HashMap<String, String>();
	   	retMap.put("insertcount", insertcount+"");
	   	retMap.put("updateCount", updateCount+"");
	   	retMap.put("deleteCount", deleteCount+"");
	   return retMap;
   }
   
   /**     
    * 查询用户角色未选择的顶级菜单 
    *    
    * @param roleId
    * @return [返回类型说明]
    * 
    * rover.lee
    * Feb 11, 2014
    */
   public List<TbMenu> getNoSelectRootMenuByRole(String roleId){
	   List<TbMenu> retList =  baseDao.selectList(getNameSpace()+".getNoSelectRootMenuByRole",roleId);             
       return retList;
   }
   
   /**
    * 
    * 查询用户角色未选择的下级菜单
    * 
    * @param roleId
    * @return [返回类型说明]
    * 
    * rover.lee
    * Feb 11, 2014
    */
   public List<TbMenu> getNoSelectSubMenuListByUpId(Map map){
	   List<TbMenu> retList =  baseDao.selectList(getNameSpace()+".getNoSelectSubMenuListByUpId",map);             
       return retList;
   }
   
   /**
    * 保存用户和菜单关系
    * @param m
    */
   
   @Transactional
   public void saveRoleMenu(Map<String,String> m){
	   String roleId = (String)m.get("role_id");
	   String deleteRoleMenus = (String)m.get("deleteRoleMenus");
	   String addRoleMenus = (String)m.get("addRoleMenus");
	   String[] delMenus = deleteRoleMenus.split(",");
	   String[] addMenus = addRoleMenus.split(",");
	   TbRoleMenu trMenu = null;
	   if(addRoleMenus !=null && !"".equals(addRoleMenus)&& addMenus.length>0){
		   for(String menu : addMenus){
			   trMenu = new TbRoleMenu();
			   trMenu.setMenu_id(Integer.parseInt(menu));
			   trMenu.setRole_id(Integer.parseInt(roleId));
			   trMenu.setCreate_date(new Date());
			   baseDao.insert("tb_role_menu.insert",trMenu);
		   }
	   }
	   if(deleteRoleMenus !=null && !"".equals(deleteRoleMenus)&& delMenus.length>0){
		   for(String menu : delMenus){ 
			   trMenu = new TbRoleMenu();
			   trMenu.setMenu_id(Integer.parseInt(menu));
			   trMenu.setRole_id(Integer.parseInt(roleId));		  
			   baseDao.delete("tb_role_menu.delete",trMenu);
		   }	  
	   }
   }
    
}
