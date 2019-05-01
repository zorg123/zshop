package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.flyrui.common.CASMd5Utils;
import com.flyrui.common.Constants;
import com.flyrui.common.MapUtils;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.SQLMapConstant;
import com.flyrui.dao.pojo.sys.TbRole;
import com.flyrui.dao.pojo.sys.TbSysLog;
import com.flyrui.dao.pojo.sys.TbUser;
import com.flyrui.dao.pojo.sys.User;
import com.flyrui.sys.service.LoginService;

@Service(value="loginService")
public class LoginServiceImpl  extends BaseService implements LoginService
{   
    Logger log = Logger.getLogger(LoginServiceImpl.class);
    
    
    /**
     * 验证登录
     * @param param
     * @return
     * @throws ServiceException
     */
    public Map validateLogin(Map param) {
        
        Map retMap = new HashMap();        
        String retCode = "-1";
        String retString = "验证失败";
        String userCode = MapUtils.getStrFromMap(param, "user_code");
        String pwd = MapUtils.getStrFromMap(param, "password");  
        String bus_state = MapUtils.getStrFromMap(param, "bus_state"); 
        TbUser paraUser = new TbUser();
        paraUser.setUser_code(userCode);
        //paraUser.setState(Constants.NORMAL_RECORD_STATE); 去掉未激活的用户也可以登录
        paraUser.setBus_state(Integer.parseInt(bus_state));
        User user = (User)baseDao.selectOne(SQLMapConstant.QUERY_USER_BY_CODE, paraUser);
        if(user!=null){
            String tPwd = user.getPassword(); 
            //校验成功
            String enPwd = CASMd5Utils.getPwd(pwd,userCode);
            if(tPwd!=null && (tPwd.equals(pwd) || tPwd.equals(enPwd))){
                //获取用户的所属角色
                List<TbRole> roleList = baseDao.selectList(SQLMapConstant.QUERY_ROLE_INFO_BY_USER_ID, user);                
                user.setRoleList(roleList);
                if(roleList!=null&roleList.size()>0){
                    //有角色信息,则写入到session中,记录登录信息
                    if(ServletActionContext.getRequest().getSession()!=null){
                    	ServletActionContext.getRequest().getSession().setAttribute("user",user);
                    }
                    
                    Date curDate = new Date();
                    User tUser = new User();
                    tUser.setUser_id(user.getUser_id());
                    tUser.setLast_login_ip(MapUtils.getStrFromMap(param, "ip"));
                    tUser.setLast_login_time(curDate);
                    tUser.setLogin_count((user.getLogin_count()==null?0:user.getLogin_count())+1);
                    try{
                        baseDao.insert(SQLMapConstant.UPDATE_USER_LOGIN_INFO, tUser);
                    }catch(Exception ex){
                        log.error("更新用户登录信息失败",ex);
                    }
                    
                    retCode = "0";
                    retString = "登录成功"; 
                    
                    TbSysLog sysLog = new TbSysLog();
                    sysLog.setCreate_time(new Date());        
                    sysLog.setResultCode(retCode);
                    sysLog.setUser_id(user.getUser_id());       
                    sysLog.setIp(MapUtils.getStrFromMap(param, "ip"));            
                    sysLog.setUrl(MapUtils.getStrFromMap(param, "url"));
                           
                    sysLog.setLog_type(Constants.LOG_TYPE_LOGIN);
                    sysLog.setContent(user.getName()+retString);
                    sysLog.setTitle("登录");        
                    //记录系统日志
                    insertSysLog(sysLog);
                }else{
                    retCode = "-3";
                    retString = "登录失败，没有找到角色，请联系管理员."; 
                }
               
            }else{
                retCode = "-2";
                retString = "密码错误";
            }
        }else{
            retCode = "-1";
            retString = "用户不存在";
        }
        
        retMap.put("code", retCode);
        retMap.put("msg", retString);
        retMap.put("user", user);        
        return retMap;
    }
   
    /**
     * 查询信息
     * @param param
     * @return
     * @throws ServiceException
     */
    public User queryUserByBankAccount(Map param) {
        
        Map retMap = new HashMap();        
        
        String bankAccount = MapUtils.getStrFromMap(param, "bank_account");
        String pwd = MapUtils.getStrFromMap(param, "password");   
        TbUser paraUser = new TbUser();
        paraUser.setBank_account(bankAccount);
        paraUser.setState(Constants.NORMAL_RECORD_STATE);
        User user = (User)baseDao.selectOne("queryUserByBankAccountState", paraUser);
               
        return user;
    }
    
    /**
     * 查询信息
     * @param param
     * @return
     * @throws ServiceException
     */
    public User queryUserByCasAccount(Map param) {
        
        Map retMap = new HashMap();        
        
        String casAccount = MapUtils.getStrFromMap(param, "cas_account");
        TbUser paraUser = new TbUser();
        paraUser.setCas_account(casAccount);
        paraUser.setState(Constants.NORMAL_RECORD_STATE);
        User user = (User)baseDao.selectOne("queryUserByCasAccountState", paraUser);
               
        return user;
    }
    
    public void insertSysLog(TbSysLog sysLog){
        try{
            baseDao.insert(SQLMapConstant.INSERT_SYS_LOG, sysLog);
        }catch(Exception e){
            log.error("记录登录日志失败",e);
        }
    }

}
