package com.flyrui.dao.pojo.sys;

import java.util.List;

/**
 * 
 * 登录用户信息扩展
 * 
 * @author  Lee
 * @version  [版本号, May 3, 2012]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class User extends TbUser
{
    private List<TbRole> roleList;  
    private String org_code;
    private String org_name;
    private String cur_role;
    private String cur_role_name;
    private String user_star;
    private String user_star_name;
    
    public List<TbRole> getRoleList()
    {
        return roleList;
    }
    public void setRoleList(List<TbRole> roleList)
    {
        this.roleList = roleList;
    }
    
    public String getOrg_code()
    {
        return org_code;
    }
    public void setOrg_code(String orgCode)
    {
        org_code = orgCode;
    }
    public String getOrg_name()
    {
        return org_name;
    }
    public void setOrg_name(String orgName)
    {
        org_name = orgName;
    }
    public String getCur_role()
    {
        return cur_role;
    }
    public void setCur_role(String curRole)
    {
        cur_role = curRole;
    }
    public String getCur_role_name()
    {
        return cur_role_name;
    }
    public void setCur_role_name(String curRoleName)
    {
        cur_role_name = curRoleName;
    }
	public String getUser_star() {
		return user_star;
	}
	public void setUser_star(String user_star) {
		this.user_star = user_star;
	}
	public String getUser_star_name() {
		return user_star_name;
	}
	public void setUser_star_name(String user_star_name) {
		this.user_star_name = user_star_name;
	}
}
