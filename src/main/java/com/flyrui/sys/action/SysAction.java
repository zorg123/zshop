package com.flyrui.sys.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.bean.MenuOptBean;
import com.flyrui.dao.pojo.sys.TbMenu;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.framework.annotation.SessionCheckAnnotation;
import com.flyrui.framework.common.DateUtil;
import com.flyrui.sys.service.MenuService;
import com.flyrui.sys.service.RoleService;
import com.flyrui.sys.service.UserService;

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
    	if(user != null && user.getBus_state()==0){    		
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
    public String adminIdxInitWap() throws FRException{
    	String resultName= "main";
    	User user = getLoginUserInfo();
    	if(user != null && user.getBus_state()==1){
    		UserService userService = (UserService)SpringBeans.getBean("userService");
    		User t = new User();
    		t.setUser_id(getUserId());
    		User tempU = userService.getListByCon(t).get(0);
    		user.setState(tempU.getState());
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
    				    List<TbMenu> retList = menuService.getSubMenuListByUpId(param);
    				    /*for(TbMenu subMenu : retList){//增加查询三层菜单
    				    	Map<String,String> paramSub = new HashMap<String,String>();
    				    	paramSub.put("user_id", user.getUser_id());
    				    	paramSub.put("menu_id", subMenu.getMenu_id()+"");    					
        				    List<TbMenu> retSubList = menuService.getSubMenuListByUpId(param);
        				    subMenu.setSub_menu_list(retSubList);
    				    }*/
    				    
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
	 * 新版管理页面初始化
	 * 根据登陆的角色，查询最上层功能模块和下级模块
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Sep 27, 2014
	 */
    @SessionCheckAnnotation(needCheckSession="true")
    public String index() throws FRException{
    	AccoutInfoService accoutInfoService = (AccoutInfoService)SpringBeans.getBean("accoutInfoService");
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getUserId()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	
    	UserService userService = (UserService)SpringBeans.getBean("userService");
    	List<Map> userLevelShareoutList = userService.queryUserLevelShareout();
    	HashMap mapPara = new HashMap();
    	mapPara.put("cf_id", "Threshold");
    	List<Map> frConfigList = userService.queryfrConfig(mapPara);
    	
    	
    	Map<String,String> param = new HashMap<String,String>();
    	param.put("user_id", getUserId());
    	String curMonth = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_7);
    	param.put("months", curMonth);
    	List<Map> monthOrder = userService.queryUserMonthGoods(param);
    	Integer curMonthOrdrs = 0;
    	if(monthOrder.size()>0) {
    		curMonthOrdrs = Integer.parseInt(monthOrder.get(0).get("goodsSum")+"");
    	}
    	
    	param = new HashMap<String,String>();
    	param.put("user_id", getUserId());
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	c.add(Calendar.MONTH, -1);
    	String lastMonth = DateUtil.formatDate(new Date(c.getTimeInMillis()), DateUtil.DATE_FORMAT_7);
    	param.put("months", lastMonth);
    	monthOrder = userService.queryUserMonthGoods(param);
    	Integer lastMonthOrdrs = 0;
    	if(monthOrder.size()>0) {
    		lastMonthOrdrs = Integer.parseInt(monthOrder.get(0).get("goodsSum")+"");
    	}
    	
    	param = new HashMap<String,String>();
    	param.put("user_id", getUserId());
    	List<Map> goodsOrders = userService.queryUserGoodsOrder(param);
    	Integer totalUserGoodsOrders = 0;
    	if(goodsOrders.size()>0) {
    		totalUserGoodsOrders = Integer.parseInt(goodsOrders.get(0).get("goodscount")+"");
    	}
    	
    	//查询用户最新的级别
    	User u = new User();
    	u.setUser_id(getUserId());
    	u = userService.getListByCon(u).get(0);
    	
    	String currentLevelPepoleCount = "";
    	String currentLevelAmount = "";
    	for(Map map:userLevelShareoutList){
    		if(u.getUser_level().toString().equals(map.get("cf_desc"))){
    			currentLevelAmount=(String)map.get("total");
    			currentLevelPepoleCount=String.valueOf(map.get("usercount")) ;
    			break;
    		}
    	}
    	
    	int num_need_tobe_share = 0;
    	//如果不具备分红资格，查询还差多少个
    	for(Map map : frConfigList){
    		if(map.get("cf_desc").toString().indexOf(u.getUser_level()+"")>=0){
    			num_need_tobe_share = lastMonthOrdrs+curMonthOrdrs - Integer.parseInt((String)map.get("cf_value")) ;
    		}
    	}
    	
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	returnMap.put("userLevelShareoutList",userLevelShareoutList);
    	returnMap.put("curMonthOrdrs",curMonthOrdrs);
    	returnMap.put("lastMonthOrdrs",lastMonthOrdrs);
    	returnMap.put("userLevel",u.getUser_level());
    	returnMap.put("getShareout_qua",u.getShareout_qua());
    	returnMap.put("Allorder_num",u.getAllorder_num());
    	returnMap.put("totalUserGoodsOrders",totalUserGoodsOrders);
    	returnMap.put("currentLevelAmount",currentLevelAmount);
    	returnMap.put("currentLevelPepoleCount",currentLevelPepoleCount);
    	returnMap.put("num_need_tobe_share",num_need_tobe_share);
    	
    	/*CoinTrackService coinTrackService = (CoinTrackService)SpringBeans.getBean("coinTrackService");
    	CoinTrackDto coinTrackDto = new CoinTrackDto();
    	coinTrackDto.setUser_id(Integer.valueOf(getUserId()));
    	HashMap bonusActMap = coinTrackService.getBonusActSum(coinTrackDto);    
    	Double actSum  = 0d;
    	if(bonusActMap!=null){
    		actSum = (Double)bonusActMap.get("actSum");
    	}
    	retAccoutInfoDto.setComments(actSum+"");*/
    	setResult(returnMap);
    	result.put("retAccoutInfo", retAccoutInfoDto);
    	return "index";
    }
}
