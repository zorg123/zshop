package com.flyrui.sys.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.common.BeanUtils;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.excel.ImportExcel;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbOrganation;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.sys.dto.UserInfoDto;
import com.flyrui.sys.service.OrganationService;
import com.flyrui.sys.service.RoleService;
import com.flyrui.sys.service.UserService;

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
    
    public UserService getUserService(){
    	return (UserService)SpringBeans.getBean("userService");
    }
    
    public RoleService getRoleService(){
    	return (RoleService)SpringBeans.getBean("roleService");
    }
    /**      
     * 添加用户       
     * @param user
     * @return [返回类型说明]      
     * Administrator
     * Jul 6, 2012
     */
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
    
    public String queryRoleIdByUserId() {
    	RoleService roleService = getRoleService();
    	PageModel pageModel = roleService.queryRoleIdByUserCode(user, page, rows);
    	setResult(pageModel);
    	return SUCCESS;
    }
    
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
}
