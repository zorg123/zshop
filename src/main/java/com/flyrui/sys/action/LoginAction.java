package com.flyrui.sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.dao.pojo.sys.TbMenu;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.sys.service.LoginService;
import com.flyrui.sys.service.MenuService;
import com.flyrui.sys.service.UserService;

public class LoginAction extends BaseAction {	

	public List menuList ;
	
	public String user_name;
	
	public String user_pass;
	
	public String valid_code;
	
	public String menuId;
	
	public String roleId;
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
	public String deleteRoleMenus;
	
	public String addRoleMenus;
	
	public String oldPwd;
	
	public String newPwd;
	
    private static final Logger log = Logger.getLogger(LoginAction.class);
	
    public String refreshSpringBean(){
    	ServletContext sc = ServletActionContext.getServletContext();   
    	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);   
    	AbstractRefreshableApplicationContext arac = (AbstractRefreshableApplicationContext)wac;   
    	arac.refresh(); 
    	log.debug("刷新Bean成功！");
		return SUCCESS;
	}
    
    public String getRootMenuByUserRole() throws FRException{
    	List<TbRole> roles = getLoginUserRole();    		
		if(roles!=null){
			MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
			menuList = menuService.getRootMenuListByRoles(roles);    		
		}else{
			FRException frException = new FRException(new FRError(ErrorConstants.SYS_ROLE_NOT_FOUND));
			log.debug(frException);
			throw frException;
		}
    	return SUCCESS;
    }
	
    public String getRootMenuByRole() throws FRException{    	
		MenuService menuService = (MenuService)SpringBeans.getBean("menuService");		 
		Map propertiesMap = new HashMap();
    	propertiesMap.put("menu_id", "id");
	    propertiesMap.put("menu_name", "text");
	    User user = getLoginUserInfo(); 
	    List l = new ArrayList();
	    List<TbMenu> retList = menuService.getRootMenuListByRole(roleId);		    
	    Map<String,String> map = new HashMap<String,String>();
	    for(TbMenu m : retList){		    	
		   	
		   	Map tM = new HashMap();
		   	tM.put("id",m.getMenu_id());
		   	tM.put("text", m.getMenu_name());
		   	map.put("role_id", roleId+"");
		   	map.put("menu_id", m.getMenu_id()+"");
		   	List<TbMenu> retList2 = menuService.getSubMenuListByUpIdAndRole(map);
		   	
		   	List l2 = new ArrayList();
		   	for(TbMenu m2 : retList2){
		   		Map tM2 = new HashMap();
			   	tM2.put("id",m2.getMenu_id());
			   	tM2.put("text", m2.getMenu_name());				   	
			   
			   	map.put("menu_id", m2.getMenu_id()+"");
				List<TbMenu> retList3 = menuService.getSubMenuListByUpIdAndRole(map);
				List l3 = new ArrayList();
				for(TbMenu m3 : retList3){
			   		Map tM3 = new HashMap();
				   	tM3.put("id",m3.getMenu_id());
				   	tM3.put("text", m3.getMenu_name());
				   	l3.add(tM3);
				}
				tM2.put("children", l3);
				l2.add(tM2);
		   	}
		   	tM.put("children", l2);
		   	l.add(tM);
	    }	 
	    List ll = new ArrayList();
	    Map mm = new HashMap();
	    mm.put("id","-1");
	    mm.put("text","菜单目录");
	    mm.put("children", l);
	    ll.add(mm);
	    setResult(ll);	    
    	return SUCCESS;
    }
    
    public String validateLogin() throws FRException{
    	LoginService loginService = (LoginService)SpringBeans.getBean("loginService");
    	String sessionValidCode= (String)super.getSessionAttribute("valid_code");
    	Map retMap = new HashMap();
    	   
    	if(sessionValidCode == null || !sessionValidCode.equals(valid_code)){
    		retMap.put("code", "-4");
            retMap.put("msg", "验证码输入错误");         
    	}else{
    		getHttpSession().removeAttribute("valid_code");
    		Map param = new HashMap();
        	param.put("user_code", user_name);
        	param.put("password", user_pass);
        	param.put("ip", getIp());
        	param.put("url", getHttpReqeust().getRequestURI());
        	retMap = loginService.validateLogin(param);
    	}
    	
    	setResult(retMap);
    	return SUCCESS;
    }
    
    public String getLoginSessionInfo(){    	
    	setResult(getLoginUserInfo());
    	return SUCCESS;
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
    public String getSubMenuListByUpId() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	User user = getLoginUserInfo();    		
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("user_id", user.getUser_id());
		param.put("menu_id", menuId);
		setResult(menuService.getSubMenuListByUpId(param));  		
		 	
    	return SUCCESS;
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
    public String getSubMenuListByUpIdAndRole() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
		Map<String,String> param = new HashMap<String,String>();
		param.put("role_id", roleId);
		param.put("menu_id", menuId);
		Map propertiesMap = new HashMap();
    	propertiesMap.put("menu_id", "id");
	    propertiesMap.put("menu_name", "text");
	    List retList = menuService.getSubMenuListByUpId(param);
	    retList = CommonUtils.transformList(retList, propertiesMap);
		setResult(retList); 
    	return SUCCESS;
    }
    
    /**
     * 
     * 根据菜单Id分页查找子菜单
     *  
     * @param menuId
     * @return [返回类型说明]
     * 
     * Administrator
     * Jul 6, 2012
     */
    public String getSubMenuPagerListByUpId(){
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	setResult(menuService.getSubMenuPagerListByUpId(menuId,page,rows));
    	return SUCCESS;
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
    public String getSubMenuTreeByUpId() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");    	 
    	List retList = new ArrayList();
		retList= menuService.getSubMenuNoRoleListByUpId(menuId);
    	
    	Map propertiesMap = new HashMap();
    	propertiesMap.put("menu_id", "id");
	    propertiesMap.put("menu_name", "text");
	    retList = CommonUtils.transformList(retList, propertiesMap);
	    if(menuId.equals("-1")){
		    List l = new ArrayList();
		    Map m = new HashMap();
		    m.put("id", "-1");
		    m.put("text", "菜单目录");
		    m.put("children", retList);
		    l.add(m);
		    setResult(l);
	    }else{
	    	setResult(retList);
	    }
    	return SUCCESS;
    }
    /**
     * 
     * 根据菜单Id查找两级子菜单
     *  
     * @param menuId
     * @return [返回类型说明]
     * 
     * Administrator
     * Jul 6, 2012
     */
    public String getSubTwoLevelMenuList() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	User user = getLoginUserInfo();
		Map<String,String> param = new HashMap<String,String>();
		param.put("user_id", user.getUser_id());
		param.put("menu_id", menuId);
		setResult(menuService.getSubTwoLevelMenuList(param));     	
    	return SUCCESS;
    }
    
    /**
	 * 根据角色查询角色拥有的菜单信息
	 * @param roleId
	 * @return
	 */
    public String getRootMenuListByRole() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	List retList= menuService.getRootMenuListByRole(roleId);    	
    	Map propertiesMap = new HashMap();
    	propertiesMap.put("menu_id", "id");
	    propertiesMap.put("menu_name", "text");
	    retList = CommonUtils.transformList(retList, propertiesMap);
    	setResult(retList);
    	return SUCCESS;
    }
    
    public String getRootMenuJsonByRole(){
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	setResult(menuService.getRootMenuJsonByRole(roleId));
    	return SUCCESS;
    }
    
    public String getSubMenuJsontByUpId() throws FRException{
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	User user = getLoginUserInfo();
		Map<String,String> param = new HashMap<String,String>();
		param.put("user_id", user.getUser_id());
		param.put("menu_id", menuId);
    	setResult(menuService.getSubMenuJsontByUpId(param));
    	return SUCCESS;
    }
    
    public String loginOut(){
    	getHttpSession().removeAttribute("user");
    	setResult(null);
    	return SUCCESS;
    }
    
    public List <TbRole> getLoginUserRole() throws FRException{
    	List<TbRole> role = null;
    	User user = getLoginUserInfo();
    	if(user != null){
    		role = getUserRole(user);
    	}else{
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_USER_NO_LOGIN));
			log.debug(frException);
			throw frException;
    	}
    	if(role==null){
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_ROLE_NOT_FOUND));
			log.debug(frException);
			throw frException;
    	}
    	return role;
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
    public String getSubMenuNoRoleListByUpId(){
    	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
    	setResult(menuService.getSubMenuNoRoleListByUpId(menuId));
    	return SUCCESS;
    }

     /**     
	    * 查询用户角色未选择的菜单 
	    *    
	    * @param roleId
	    * @return [返回类型说明]
	    * 
	    * rover.lee
	    * Feb 11, 2014
	    */
	   public String getNoSelectRootMenuByRole() throws FRException{
		   	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");	    	
	    	Map propertiesMap = new HashMap();
	    	propertiesMap.put("menu_id", "id");
		    propertiesMap.put("menu_name", "text");
		    List l = new ArrayList();
		    List<TbMenu> retList = menuService.getSubMenuNoRoleListByUpId("-1");//menuService.getNoSelectRootMenuByRole(roleId);		    
		    Map<String,String> map = new HashMap<String,String>();
		    for(TbMenu m : retList){		    	
			   	
			   	Map tM = new HashMap();
			   	tM.put("id",m.getMenu_id());
			   	tM.put("text", m.getMenu_name());
				//map.put("role_id", roleId);
			    //map.put("menu_id", m.getMenu_id()+"");
			   	List<TbMenu> retList2 = menuService.getSubMenuNoRoleListByUpId(m.getMenu_id()+"");//getNoSelectSubMenuListByUpId
			   	
			   	List l2 = new ArrayList();
			   	for(TbMenu m2 : retList2){
			   		Map tM2 = new HashMap();
				   	tM2.put("id",m2.getMenu_id());
				   	tM2.put("text", m2.getMenu_name());				   	
				   
				   	map.put("menu_id", m2.getMenu_id()+"");
					List<TbMenu> retList3 = menuService.getSubMenuNoRoleListByUpId(m2.getMenu_id()+"");//getNoSelectSubMenuListByUpId
					List l3 = new ArrayList();
					for(TbMenu m3 : retList3){
				   		Map tM3 = new HashMap();
					   	tM3.put("id",m3.getMenu_id());
					   	tM3.put("text", m3.getMenu_name());
					   	l3.add(tM3);
					}
					tM2.put("children", l3);
					l2.add(tM2);
			   	}
			   	tM.put("children", l2);
			   	l.add(tM);
		    }
		    List ll = new ArrayList();
		    Map mm = new HashMap();
		    mm.put("id","-1");
		    mm.put("text","菜单目录");
		    mm.put("children", l);
		    ll.add(mm);
		    setResult(ll);		    
	    	return SUCCESS;
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
	   public String getNoSelectSubMenuListByUpId() throws FRException{
		   	MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
		   	Map<String,String> map = new HashMap<String,String>();
		   	map.put("role_id", roleId);
		   	map.put("menu_id", menuId);
		   	Map propertiesMap = new HashMap();
	    	propertiesMap.put("menu_id", "id");
		    propertiesMap.put("menu_name", "text");
		    List retList = menuService.getNoSelectSubMenuListByUpId(map);
		    retList = CommonUtils.transformList(retList, propertiesMap);
	    	setResult(retList);
	    	return SUCCESS;
	   }
	   
	   /**	     
	    * 保存用户和菜单关系
	    * 
	    * @return [返回类型说明]
	    * 
	    * rover.lee
	    * Feb 12, 2014
	    */
	   public String saveRoleMenu(){
		   MenuService menuService = (MenuService)SpringBeans.getBean("menuService");
		   Map m = new HashMap();
		   m.put("role_id", roleId);
		   m.put("deleteRoleMenus", deleteRoleMenus);
		   m.put("addRoleMenus", addRoleMenus);
		   menuService.saveRoleMenu(m);
		   setResult(null);
		   return SUCCESS;
	   }
	   
	   /**
	    * 
	    * 修改密码
	    * 
	    * @return
	    * @throws FRException [返回类型说明]
	    * 
	    * rover.lee
	    * Feb 18, 2014
	    */
	   public String modifyPwd() throws FRException{
		   UserService userService = (UserService)SpringBeans.getBean("userService");
		   Map<String,String> param = new HashMap();
		   if(oldPwd == null || "".equals(oldPwd)){
			   throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
		   }
		   param.put("oldPwd", oldPwd);
		   if(newPwd == null || "".equals(newPwd)){
			   throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
		   }
		   param.put("newPwd", newPwd);
		   param.put("user_id", getUserId());
		   int uCount = userService.modifyPwd(param);
		   if(uCount != 1){
			   throw new FRException(new FRError(ErrorConstants.SYS_NO_UPDATE_DATA));
		   }
		   setResult(null);
		   return SUCCESS;
	   }
}
