package com.flyrui.sys.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.bean.MenuOptBean;
import com.flyrui.dao.pojo.sys.TbMenu;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.SessionCheckAnnotation;
import com.flyrui.sys.service.MenuService;
import com.flyrui.sys.service.RoleService;

public class SysAction extends BaseAction {	

	public List menuList ;	
	TbMenu menu;
	public MenuOptBean menuOptBean = new MenuOptBean();
	
	public TbRole tbRole = new TbRole();
	
    private static final Logger log = Logger.getLogger(SysAction.class);
	
    public String getRootMenuByRole() throws FRException{
    	User user = getLoginUserInfo();
    	if(user != null){
    		List<TbRole> role = getUserRole(user);
    		if(role!=null){
    			MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    			menuList = menuService.getRootMenuListByRoles(role);   
    			setResult(menuList);
    		}else{
    			FRException frException = new FRException(new FRError(ErrorConstants.SYS_ROLE_NOT_FOUND));
    			log.debug(frException);
    			throw frException;
    		}
    	}else{
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_USER_NO_LOGIN));
			log.debug(frException);
			throw frException;
    	}
    	return SUCCESS;
    }

	/**
	 * 
	 * 新版管理页面初始化
	 * 根据登陆的角色，查询最上层功能模块和下级模块
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Sep 27, 2014
	 */
    @SessionCheckAnnotation(needCheckSession="false")
    public String adminIdxInit() throws FRException{
    	String resultName= "main";
    	User user = getLoginUserInfo();
    	if(user != null){
    		List<TbRole> role = getUserRole(user);
    		if(role!=null){
    			MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    			menuList = menuService.getRootMenuListByRoles(role);  
    			if(menuList!=null && menuList.size()>0){
    				//查找子菜单
    				for( int i=0;i<menuList.size();i++){
    					TbMenu menu = (TbMenu)menuList.get(i);
    					Map<String,String> param = new HashMap<String,String>();
    					param.put("user_id", user.getUser_id());
    					param.put("menu_id", menu.getMenu_id()+"");    					
    				    List retList = menuService.getSubMenuListByUpId(param);
    				    menu.setSub_menu_list(retList);
    				}
    			}
    		}else{
    			FRException frException = new FRException(new FRError(ErrorConstants.SYS_ROLE_NOT_FOUND));
    			throw frException;
    		}
    	}else{
    		resultName = "login";
    	}
    	return resultName;
    }
    
    /**
     * 
     * 插入多条菜单记录
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String optMenuList(){
    	MenuService  menuService = getUserService();
    	Map retMap = menuService.OptMenuList(menuOptBean);  
    	setResult(retMap);
    	return SUCCESS;
    }
    
    
    public MenuService getUserService(){
    	return (MenuService)SpringBeans.getBean("menuService");
    }

	public MenuOptBean getMenuOptBean() {
		return menuOptBean;
	}

	/**
     * 
     * 删除一条角色
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String deleteRole(){
    	RoleService  roleService = getRoleService();    	 
    	setResult(roleService.delete(tbRole));
    	return SUCCESS;
    }
    
    /**
     * 
     * 更新一条角色
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String updateRole(){
    	RoleService  roleService = getRoleService();    	
    	setResult(roleService.update(tbRole));
    	return SUCCESS;
    }
    
    /**
     * 
     * 插入一条角色
     * 
     * @return insertCount 为插入的条数
     * 
     * rover.lee
     * Feb 10, 2014
     */
    public String insertRole(){
    	RoleService  roleService = getRoleService();
    	tbRole.setCreate_date(new Date());
    	setResult(roleService.insert(tbRole));
    	return SUCCESS;
    }
    
    /**
     * 
     * 获取当前role的信息
     *     
     * rover.lee
     * Feb 10, 2014
     */
    public String getRoleInfo(){
    	RoleService  roleService = getRoleService();
    	setResult(roleService.selectList(tbRole));
    	return SUCCESS;
    }
	
    public RoleService getRoleService(){
    	return (RoleService)SpringBeans.getBean("roleService");
    }
	

}
