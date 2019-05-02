package com.flyrui.sys.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.flyrui.common.BeanUtils;
import com.flyrui.common.CASMd5Utils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ImportExcel;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbOrganation;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.financMgmt.pojo.AccoutInfoDto;
import com.flyrui.financMgmt.pojo.UserDirectRecommend;
import com.flyrui.financMgmt.service.AccoutInfoService;
import com.flyrui.financMgmt.service.UserDirectRecommendService;
import com.flyrui.sys.dto.UserInfoDto;
import com.flyrui.sys.dto.UserNetTree;
import com.flyrui.sys.service.FrconfigService;
import com.flyrui.sys.service.OrganationService;
import com.flyrui.sys.service.RoleService;
import com.flyrui.sys.service.UserService;

@ParentPackage("frcms_default")
@Namespace("/Sys/User") //访问路径的包名
@Results({	
		@Result(name="queryRegisterUser", location = "/wap/user/queryRegisterUserNew.jsp"),
		@Result(name="userProfile", location = "/wap/user/userProfile.jsp"),
		@Result(name="userMarket", location = "/wap/user/userMarket.jsp"),
		@Result(type="json", params={"root","result"})}) 
public class UserAction extends BaseAction {	

	public User user  = new User();
	
	public TbRole role = new TbRole();
	
	public int rows; //每页大小
	
	public int page;//当前页号
	
	public String ids;
	
	private String contentType;
    private File upload;
    private String fileName;
    private String caption;	
    public String beActivedUserId;
	
    private static final Logger log = Logger.getLogger(UserAction.class);	
    
    public String getUploadFileName() {
        return fileName;
    }
    public void setUploadFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadContentType() {
        return contentType;
    }
    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
        
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService(){
    	return (UserService)SpringBeans.getBean("userService");
    }
    
    public RoleService getRoleService(){
    	return (RoleService)SpringBeans.getBean("roleService");
    }
    
    public UserDirectRecommendService getUserDirectRecommendService(){
    	return (UserDirectRecommendService)SpringBeans.getBean("userDirectRecommendService");
    } 
    /**      
     * 添加用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("insertUser")
    public String insertUser() throws FRException{
    	UserService userService = getUserService();
    	String ip = getIp();
    	//user.setUser_id(UUIDHexGenerator.generator());
    	user.setRegister_ip(ip);
    	user.setRegister_date(new Date());
    	User u = new User();
    	u.setUser_code(user.getUser_code());    	
    	List retList = userService.getListByCon(u);
    	if(retList!=null &&retList.size() >0){
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_USER_EXISTS));
    		throw frException;
    	}
    	
    	//再查银行账号
    	u = new User();
    	u.setBank_account(user.getBank_account());
    	retList = userService.getListByCon(u);
    	if(retList!=null &&retList.size() >0){
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_BANK_ACCOUNT_EXISTS));
    		throw frException;
    	}
    	user.setPassword(CASMd5Utils.getMdResults(user.getPassword(), "12", user.getUser_code()));
    	user.setBus_state(0);
    	userService.insert(user);
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    /**      
     * 查询用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("queryUser")
    public String queryUser(){
    	UserService userService = getUserService();
    	if(user!=null && user.getName()!=null && !user.getName().equals("")){
    		user.setName("%"+user.getName()+"%");
    	}
    	
    	PageModel pageModel = userService.getPagerListByCon(user, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    /**      
     * 通过用户id查询用户，只有一个返回值       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("queryUserById")
    public String queryUserById(){
    	UserService userService = getUserService();    	    	
    	List retList = userService.getListByCon(user);
    	setResult(retList);
    	return SUCCESS;
    }
    
    /**      
     * 删除用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("deleteUser")
    public String deleteUser(){
    	UserService userService = getUserService();
    	userService.delete(user);
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    /**      
     * 修改用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("updateUser")
    public String updateUser(){
    	UserService userService = getUserService();
    	userService.update(user);
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    /**      
     * 获取角色       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("queryRoleList")
    public String queryRoleList(){
    	RoleService roleService = getRoleService();
    	if(role.getRole_name()!=null && !"".equals(role.getRole_name())){
    		role.setRole_name("%"+role.getRole_name()+"%");
    	}
    	if(role.getRole_desc()!=null && !"".equals(role.getRole_desc())){
    		role.setRole_desc("%"+role.getRole_desc()+"%");
    	}
    	PageModel pageModel = roleService.getPagerListByCon(role, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    /**      
     * 获取角色       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("queryRoleListFilterByUser")
    public String queryRoleListFilterByUser(){
    	RoleService roleService = getRoleService();
    	if(role.getRole_name()!=null && !"".equals(role.getRole_name())){
    		role.setRole_name("%"+role.getRole_name()+"%");
    	}
    	if(role.getRole_desc()!=null && !"".equals(role.getRole_desc())){
    		role.setRole_desc("%"+role.getRole_desc()+"%");
    	}
    	role.setUser_id(getUserId());
    	PageModel pageModel = roleService.queryRoleListFilterByUser(role, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    /**      
     * 保存用户角色关系       
     * @param user
     * @return [返回类型说明]      
     *  
     */
    @Action("saveUserRole")
    public String saveUserRole() throws FRException{
    	UserService userService = getUserService();
    	if( ids != null && ids.length()>0){
    		//把老的角色全部删除
    		userService.deleteRolesByUser(user.getUser_id());
    		String[] idArray = ids.split(",");
    		for(String id : idArray){
    			userService.saveUserRole(user.getUser_id(),id);
    		}
    	}else{
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	setResult("0");
    	return SUCCESS;
    }
    
    @Action("queryRoleIdByUserId")
    public String queryRoleIdByUserId() {
    	RoleService roleService = getRoleService();
    	PageModel pageModel = roleService.queryRoleIdByUserCode(user, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
    @Action("deleteUserRole")
    public String deleteUserRole() throws FRException{
    	UserService userService = getUserService();
    	if( ids != null && ids.length()>0){
    		String[] idArray = ids.split(",");
    		for(String id : idArray){
    			userService.deleteUserRole(user.getUser_id(),id);
    		}
    	}else{
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	setResult(null);
    	return SUCCESS;
    }
      
    @Action("importUser")
    public String importUser(){
    	UserService userService = getUserService();    	
    	ImportExcel<UserInfoDto> importExcel = new ImportExcel(
    			UserInfoDto.class);
    	List<UserInfoDto> resultList = (ArrayList) importExcel.importExcel(upload);
    	System.out.println("共转化为List的行数为：" + resultList.size());
    	Map retMap = new HashMap();
    	retMap.put("transformErrNum", importExcel.getErrNum());
    	retMap.put("transformErrMsg", importExcel.getErrMessage());
    	int importErrNum=0;
    	int importSucNum=0;
    	StringBuffer importErrMsg = new StringBuffer();
    	
    	if(resultList!=null && resultList.size()>0){
    		User localUser = null;
    		List<User> trueUser = new ArrayList<User>();
    		//查询所有组织信息
    		OrganationService  organationService = (OrganationService)SpringBeans.getBean("organationService"); 
        	List<TbOrganation> orgList = organationService.selectList(new TbOrganation());
        	List<User> userList = userService.getListByCon(new User());
        	int count = 0;
        	int i=0;
    		for(UserInfoDto userInfoDto : resultList){
    			localUser = new User();
    			i++;
    			try{
    				BeanUtils.copyProperties(localUser, userInfoDto);
    			}catch(Exception ex){
    				importErrMsg.append("工号"+userInfoDto.getUser_code()+"入库失败:"+ex.getMessage());
    				importErrNum++;
    				continue;
    			}
    			Integer orgId = selectOrgByName(orgList,localUser.getOrg_name());
    			if(orgId == null){
    				importErrMsg.append("工号"+userInfoDto.getUser_code()+"入库失败:组织"+localUser.getOrg_name()+"在系统中不存在.");
    				importErrNum++;
    				continue;
    			}
    			if(checkUserExist(userList,localUser)){
    				importErrMsg.append("工号"+userInfoDto.getUser_code()+"入库失败:"+userInfoDto.getUser_code()+"已在系统中存在.");
    				importErrNum++;
    				continue;
    			}
    			if(checkBankAccountExist(userList,localUser)){
    				importErrMsg.append("工号"+userInfoDto.getUser_code()+"入库失败:银行账号 "+userInfoDto.getBank_account()+"已在系统中存在.");
    				importErrNum++;
    				continue;
    			}
    			
    			if("男".equals(localUser.getSex())){
    				localUser.setSex("1");
    			}else{
    				localUser.setSex("2");
    			}
    			localUser.setRegister_date(new Date());
    			localUser.setRegister_ip(getIp()); 
    			localUser.setOrg_id(orgId);
    			localUser.setState("1");
    			try{
    				count++;
    				userService.insert(localUser);
    				//插入默认角色
    				userService.saveUserRole(localUser.getUser_id(),"2");
    				//trueUser.add(localUser);
    				//if(count%100==0){
    				//	userService.batchInsert(trueUser);
    				//	trueUser.clear();
    				//}else{
    					//执行剩余的记录.
    					//if(i == resultList.size() -1){
    					//	userService.batchInsert(trueUser);
    					//	trueUser.clear();
        				//}
    				//}
    			}catch(Exception ex){
    				importErrMsg.append("工号"+getUserCodeStr(trueUser)+"入库失败:"+ex.getMessage());
    				importErrNum++;//importErrNum = importErrNum + trueUser.size();
    				//trueUser.clear();
    				continue;
    			}
    			importSucNum++;
    		}    		
    	}
    	
    	retMap.put("importSucNum", importSucNum);
    	retMap.put("importErrNum", importErrNum);
    	retMap.put("importErrMsg", importErrMsg.toString());
    	
    	setResult(retMap);
    	return SUCCESS;    	
    }
    
    
    public Integer selectOrgByName(List<TbOrganation> orgList,String orgName){
    	Integer orgId = null;
    	for(TbOrganation org : orgList){
    		if(org.getOrg_name().equals(orgName)){
    			orgId = org.getOrg_id();
    			break;
    		}
    	}
    	return orgId;
    }
    
     
    public boolean checkUserExist(List<User> userList,User localUser){
    	boolean isExist = false;
    	for(User user : userList){
    		if(user.getUser_code().equals(localUser.getUser_code())){
    			isExist = true;
    			break;
    		}
    	}    	
    	return isExist;
    }
    
    public boolean checkBankAccountExist(List<User> userList,User localUser){
    	boolean isExist = false;
    	for(User user : userList){
    		if(user.getBank_account().equals(localUser.getBank_account())){
    			isExist = true;
    			break;
    		}
    	}    	
    	return isExist;
    }
    
    
    @Action("getUserCodeStr")
    public String getUserCodeStr(List<User> userList){
    	StringBuffer userCodeStr= new StringBuffer();
    	for(User user : userList){
    		if(userCodeStr.toString().equals("")){
    			userCodeStr.append(user.getUser_code());
    		}else{
    			userCodeStr.append(","+user.getUser_code());
    		}
    	}
    	return userCodeStr.toString();
    }
    
    /**      
     * 添加用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("registerUser")
    @SkipValidation
    public String registerUser() throws FRException{
    	UserService userService = getUserService();
    	String ip = getIp();
    	//user.setUser_id(UUIDHexGenerator.generator());
    	user.setRegister_ip(ip);
    	user.setRegister_date(new Date());
    	User u = new User();
    	u.setUser_code(user.getUser_code());    	
    	List<User> retList = userService.getListByCon(u);
    	if(retList!=null &&retList.size() >0){
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_USER_EXISTS));
    		throw frException;
    	}
    	    	
    	user.setRegister_id(getUserId());
    	//根据注册人的账号查询注册人的id
    	u = new User();
    	u.setUser_code(user.getPid()+"");
    	u.setBus_state(1);
    	retList = userService.getListByCon(u);
    	if(retList == null || retList.size()==0){
    		FRException frException = new FRException(new FRError("USER_002"));
    		throw frException;
    	}
    	User tempUser = retList.get(0);
    	if("0".equals(tempUser.getState())){
    		FRException frException = new FRException(new FRError("USER_008"));
    		throw frException;
    	}
    	//查询节点人下的节点数，如果超过3个就不让注册
    	u = new User();
    	u.setPid(tempUser.getUser_id());
    	u.setBus_state(1);
    	retList = userService.getListByCon(u);
    	if(retList!=null && retList.size()>=3){
    		FRException frException = new FRException(new FRError("USER_009"));
    		throw frException;
    	}
    	
    	user.setPid(tempUser.getUser_id());
    	user.setState("0");
    	user.setUser_level(-1);
    	user.setBus_state(1);
    	user.setCreate_time(new Date());
    	user.setRegister_date(new Date());
    	user.setRegister_ip(super.getIp());
    	user.setPassword(CASMd5Utils.getPwd(user.getPassword(),user.getUser_code()));
    	user.setTrans_pwd(CASMd5Utils.getPwd(user.getTrans_pwd(),user.getUser_code()));
    	userService.insertRegister(user);
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    /**      
     * 添加用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("getUserNetWork")   
    public String getUserNetWork() throws FRException{
    	UserNetTree userNetTree = new UserNetTree();
    	UserService userService = getUserService();    
    	if((user.getUser_id()==null || "".equals(user.getUser_id()))&& (user.getUser_code()==null || "".equals(user.getUser_code()))){
    		user.setUser_id(getUserId());
    	}
    	User u = new User();
    	u.setUser_id(user.getUser_id());
    	if(user.getUser_code()!=null){
    		u.setUser_code(user.getUser_code());
    	}
    	List<User> retList = userService.selectUserNetTree(u);
    	if(retList==null || retList.size() == 0){
    		FRException frException = new FRException(new FRError(ErrorConstants.SYS_USER_NOT_EXISTS));
    		throw frException;
    	}    	
    	User curUser = retList.get(0);
    	userService.checkCurrentChild(super.getLoginUserInfo(),curUser);
    	userNetTree.setId(curUser.getUser_id());
    	userNetTree.setTitle(curUser.getName()+"("+curUser.getUser_code()+")");
    	userNetTree.setClassName(getUserNetClass(curUser.getState()+""));
    	userNetTree.setStar(curUser.getUser_star());
    	userNetTree.setStarName(curUser.getUser_star_name());
    	userNetTree.setUserCode(curUser.getUser_code());
    	userNetTree.setAllchild_num((curUser.getAllchild_num()==null?0:curUser.getAllchild_num())+"");
    	userNetTree.setUserState(curUser.getState());
    	//获取下级节点    	
    	u = new User();
    	u.setPid(curUser.getUser_id());
    	retList = userService.selectUserNetTree(u);
    	List<UserNetTree> subUserNetTreeList = new ArrayList<UserNetTree>();
    	for(User us : retList){
    		UserNetTree userNetTreeTemp = new UserNetTree();
    		userNetTreeTemp.setId(us.getUser_id());
    		userNetTreeTemp.setTitle(us.getName()+"("+us.getUser_code()+")");
    		userNetTreeTemp.setClassName(getUserNetClass(us.getState()+""));
    		userNetTreeTemp.setStar(us.getUser_star());
    		userNetTreeTemp.setStarName(us.getUser_star_name());
    		userNetTreeTemp.setUserCode(us.getUser_code());
    		userNetTreeTemp.setAllchild_num((us.getAllchild_num()==null?0:us.getAllchild_num())+"");
    		userNetTreeTemp.setUserState(us.getState());
    		u = new User();
        	u.setPid(us.getUser_id());
        	List<User> retList2 = userService.selectUserNetTree(u);
        	List<UserNetTree> subUserNetTreeList2 = new ArrayList<UserNetTree>();
    		for(User us2 : retList2){
        		UserNetTree userNetTreeTemp2 = new UserNetTree();
        		userNetTreeTemp2.setId(us2.getUser_id());
        		userNetTreeTemp2.setTitle(us2.getName()+"("+us2.getUser_code()+")");
        		userNetTreeTemp2.setClassName(getUserNetClass(us2.getState()+""));
        		userNetTreeTemp2.setStar(us2.getUser_star());
        		userNetTreeTemp2.setStarName(us2.getUser_star_name());
        		userNetTreeTemp2.setUserCode(us2.getUser_code());
        		userNetTreeTemp2.setAllchild_num((us2.getAllchild_num()==null?0:us2.getAllchild_num())+"");        		
        		userNetTreeTemp2.setUserState(us2.getState());
        		//再查一下下级的,用于做判断
        		u = new User();
            	u.setPid(us2.getUser_id());
            	List<User> retList3 = userService.selectUserNetTree(u);
            	userNetTreeTemp2.setChildrenLength(retList3.size());            	
            	subUserNetTreeList2.add(userNetTreeTemp2);
        	}
    		userNetTreeTemp.setChildren(subUserNetTreeList2);
    		userNetTreeTemp.setChildrenLength(subUserNetTreeList2.size());
    		subUserNetTreeList.add(userNetTreeTemp);
    	}
    	userNetTree.setChildren(subUserNetTreeList);
    	userNetTree.setChildrenLength(subUserNetTreeList.size());
    	setResult(userNetTree);
    	return SUCCESS;
    }
    
        
    @Action("queryRegisterUser")    
    public String queryRegisterUser(){
    	UserService userService = getUserService();
    	user.setRegister_id(getUserId());
    	if(user.getState()==null){
    		user.setState("1");
    	}
    	if(rows==0){
    		rows=5;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel pageModel = userService.getPagerListByCon(user, page, rows);
    	setResult(pageModel);
    	return "queryRegisterUser";
    }
    
    @Action("queryWaitActiveUser")
    public String queryWaitActiveUser(){
    	UserService userService = getUserService();
    	user.setUser_id(getUserId());
    	if(user.getState()==null){
    		user.setState("1");
    	}
    	if(rows==0){
    		rows=10;
    	}
    	if(page==0){
    		page = 1;
    	}
    	PageModel pageModel = userService.selectForWaitActiveUser(user, page, rows);
    	setResult(pageModel);
    	return "queryRegisterUser";
    }
    
    private String getUserNetClass(String state){
    	String retV = "state_green";
    	if("0".equals(state)){
    		retV = "state_white";
    	}else{
    		retV = "state_green";
    	}
    	
    	return retV;
    }
    
    @Action("genSubUser")  
    public String genSubUser() throws FRException{
    	User currUser = getLoginUserInfo();
    	if(currUser.getUser_type().equals("child")){
    		Map retMap = new HashMap();
    		retMap.put("_code", "-1");
    		retMap.put("_msg", "当前是子帐号用户登录！不允许该操作！");
    		result.putAll(retMap);
        	return SUCCESS;
    	}
    	UserService userService = getUserService();
    	User user = new User();
    	user.setPid(currUser.getUser_id());
    	user.setUser_type("child");
    	List li = userService.getListByCon(user);
    	if(li != null && li.size() > 0){
    		Map retMap = new HashMap();
    		retMap.put("_code", "-1");
    		retMap.put("_msg", "已存在子帐号，请使用[z"+currUser.getUser_code()+"]和原账户密码即可登录");
    		result.putAll(retMap);
        	return SUCCESS;
    	}

    	currUser.setPid(currUser.getUser_id());
    	currUser.setUser_id(null);
    	currUser.setUser_code("z"+currUser.getUser_code());
    	currUser.setLogin_count(0);
    	currUser.setLast_login_time(null);
    	currUser.setLast_login_ip(null);
    	currUser.setAllchild_num(0);
    	currUser.setUser_type("child");
    	currUser.setAllorder_num(0);
    	currUser.setRegister_date(new Date());
    	currUser.setRegister_date(new Date());
    	currUser.setCreate_time(new Date());
    	currUser.setAct_time(null);
    	currUser.setState("1");
    	userService.insert(currUser);
    	
    	Map retMap = new HashMap();
		retMap.put("_code", "-1");
		retMap.put("_msg", "子帐号创建成功，请使用[z"+currUser.getUser_code()+"]和原账户密码即可登录！");
		result.putAll(retMap);
    	return SUCCESS;
    }
    @Action("activeUser2")  
    public String activeUser2() throws FRException{
    	User currUser = getLoginUserInfo();
    	if(!currUser.getUser_type().equals("child")){
    		Map retMap = new HashMap();
    		retMap.put("_code", "-1");
    		retMap.put("_msg", "请使用子账户激活");
    		result.putAll(retMap);
        	return SUCCESS;
    	}
    	
    	UserService userService = getUserService();
    	User beActivedUser = new User();
    	beActivedUser.setUser_id(beActivedUserId);
    	List<User> li= userService.getListByCon(beActivedUser);
    	if(li == null || li.size() == 0){
    		Map retMap = new HashMap();
    		retMap.put("_code", "-1");
    		retMap.put("_msg", "被激活用户不存在");
    		result.putAll(retMap);
        	return SUCCESS;
    	}
    	String[] ret = userService.activeUser2(getLoginUserInfo(), li.get(0));
    	
    	Map retMap = new HashMap();
		retMap.put("_code", ret[0]);
		retMap.put("_msg", ret[1]);
		result.putAll(retMap);
    	return SUCCESS;
    	
    }
    @Action("activeUser")  
    public String activeUser() throws FRException{
    	if(ids==null){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	String userId = getUserId();
    	
    	//校验是否是当前用户注册的
    	UserService userService = getUserService();
    	User uu= new User();
    	uu.setRegister_id(userId);
    	String[] idStr = ids.split(";");
    	List<User> userList = new ArrayList<User>();
    	for(String idTemp : idStr){
    		uu.setUser_id(idTemp);
    		List<User> userListRet = userService.getListByCon(uu);
    		if(userListRet==null || userListRet.size() == 0){
    			throw new FRException(new FRError("USER_003"));
    		}
    		User uuTemp = userListRet.get(0);
    		if("1".equals(uuTemp.getState())){
    			throw new FRException(new FRError("USER_004"));
    		}
    		userList.add(uuTemp);
    	}
    	
    	//激活之前要判断一下，登录用户的账户上电子币是否小于600，小于600不能激活，提示充值。   
    	AccoutInfoService accoutInfoService = (AccoutInfoService)SpringBeans.getBean("accoutInfoService");
    	AccoutInfoDto accoutInfo = new AccoutInfoDto();
    	accoutInfo.setUser_id(Integer.valueOf(getUserId()));
    	AccoutInfoDto retAccoutInfoDto = accoutInfoService.queryAccountInfo(accoutInfo);
    	Double electCoin = (Double)retAccoutInfoDto.getElect_coin();
    	
    	FrconfigService frconfigService = (FrconfigService)SpringBeans.getBean("frconfigService");
    	HashMap param =new HashMap();
    	param.put("cf_id", "userInNetAmout");
    	List<HashMap> cfgList = frconfigService.queryFrCfgList(param);
    	if(cfgList!=null && cfgList.size()>0){
    		Double userInNetAmount = Double.parseDouble((String)cfgList.get(0).get("cf_value"));
    		if(electCoin<userInNetAmount){
    			throw new FRException(new FRError("USER_005"));
    		}
    	}else{
    		throw new FRException(new FRError("SYS_ERR006"));
    	}
    	userService.activeUser(userList,getLoginUserInfo());
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    @Action("userProfile")  
    public String userProfile() throws FRException{
    	String userId = getUserId();
    	
    	UserService userService = getUserService();
    	User uu= new User();
    	uu.setUser_id(userId);
    	List<User> userList = userService.getListByCon(uu);
    	user = userList.get(0);
    	return "userProfile";
    }
    @Action("ModifyUser")  
    public String ModifyUser() throws FRException{
    	String userId = getUserId();
    	
    	UserService userService = getUserService();
    	User uu= new User();
    	uu.setUser_id(userId);
    	List<User> userList = userService.getListByCon(uu);
    	User curUser = userList.get(0);
    	user.setUser_id(curUser.getUser_id());
    	userService.update(user);
    	setCommonSuccessReturn();
    	return SUCCESS;
    }
    
    @Action("modifyPwd")
    public String modifyPwd() throws FRException{
    	
    	String userId = getUserId();
    	
    	//校验是否是当前用户注册的
    	UserService userService = getUserService();
    	User uu= new User();
    	uu.setUser_id(userId);
    	List<User> userList = userService.getListByCon(uu);
    	User curUser = userList.get(0);
    	boolean isModify = true;
    	if(user.getPassword()!=null&&user.getPassword().length()>0 && user.getOld_password()!=null &&user.getOld_password().length() >0 ){
    		String oldPwd = CASMd5Utils.getPwd(user.getOld_password(),curUser.getUser_code());
    		if(!oldPwd.equals(curUser.getPassword())){
    			throw new FRException(new FRError("USER_006"));
    		}
    		user.setPassword( CASMd5Utils.getPwd(user.getPassword(),curUser.getUser_code()));
    	}else{
    		isModify = false;
    	}
    	if(user.getTrans_pwd()!=null&&user.getTrans_pwd().length()>0 && user.getOld_trans_pwd()!=null &&user.getOld_trans_pwd().length() >0 ){
    		String oldTrasPwd = CASMd5Utils.getPwd(user.getOld_trans_pwd(),curUser.getUser_code());
    		if(!oldTrasPwd.equals(curUser.getTrans_pwd()) ){
    			throw new FRException(new FRError("USER_007"));
    		}
    		user.setTrans_pwd(CASMd5Utils.getPwd(user.getTrans_pwd(),curUser.getUser_code()));
    		isModify = true;
    	}else{
    		if(!isModify){
    			isModify = false;
    		}
    	}
    	if(isModify){
	    	user.setUser_id(curUser.getUser_id());
	    	userService.update(user);
	    	setCommonSuccessReturn();
    	}else{
    		throw new FRException(new FRError("SYS_ERR005"));
    	}
    	return SUCCESS;
    }
    
    @Action("delUnActiveUser")
    public String delUnActiveUser() throws FRException{
    	
    	if(ids==null){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}    	
    	String userId = getUserId();
    	String[] idStr = ids.split(";");
    	//校验是否是当前用户注册的
    	UserService userService = getUserService();
    	User uu= new User();
    	uu.setRegister_id(userId);
    	uu.setUser_id(idStr[0]);
    	uu.setBus_state(1);
    	uu.setState("0");
    	int cnt = userService.delUnActiveUser(uu);
    	if(cnt==0){
    		throw new FRException(new FRError("SYS_ERR010"));
    	}else{
    		setCommonSuccessReturn();
    	}
    	return SUCCESS;
    }
    
    /**      
     * 通过用户code查询用户是否存在       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
    @Action("queryUserByCode")
    public String queryUserByCode() throws FRException{
    	UserService userService = getUserService(); 
    	if(user.getUser_code() == null){
    		throw new FRException(new FRError(ErrorConstants.SYS_PARAMETER_NOT_SEND));
    	}
    	List<User> retList = userService.getListByCon(user);    	
    	User retUser = new User();
    	if(retList!=null && retList.size()>0){
    		User tempUser = retList.get(0);
    		retUser.setBus_state(tempUser.getBus_state());
    		retUser.setState(tempUser.getState());
    		if("1".equals(tempUser.getBus_state()+"")){
	    		//查询节点人下的节点数，如果超过3个就不让注册
	        	User u = new User();
	        	u.setPid(tempUser.getUser_id());
	        	u.setBus_state(1);
	        	retList = userService.getListByCon(u);
	        	if(retList !=null){
	        		retUser.setAllchild_num(retList.size());
	        	}
    		}
    	}
    	setResult(retUser);
    	return SUCCESS;
    }
    @Action("userMarket")  
    public String userMarket() throws FRException{
    	/*UserService userService = getUserService();
    	User uu= new User();
    	uu.setPid(getLoginUserInfo().getUser_id());
    	uu.setState("1");
    	uu.setBus_state(1);
    	List<User> userList = userService.getListByCon(uu);
    	setResult(userList);*/
    	UserDirectRecommendService userDirectRecommendService = getUserDirectRecommendService();
    	UserDirectRecommend userDirectRecommend = new UserDirectRecommend();
    	userDirectRecommend.setUser_id(Integer.valueOf(getLoginUserInfo().getUser_id()));
    	List<UserDirectRecommend> userDirectRecommendList = userDirectRecommendService.getListByCon(userDirectRecommend);
    	setResult(userDirectRecommendList);
    	return "userMarket";
    }
}
