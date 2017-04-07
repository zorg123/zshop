package com.flyrui.sys.service;

import java.util.List;
import java.util.Map;

import com.flyrui.common.bean.MenuOptBean;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.TbMenu;
import com.flyrui.dao.pojo.sys.TbRole;

public interface MenuService {
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
    public List getSubMenuListByUpId(Map<String,String> param);
    
    /**
	 * 根据角色查询角色拥有的菜单信息
	 * @param roleId
	 * @return
	 */
    public List<TbMenu> getRootMenuListByRole(String roleId);
    
    public Map getRootMenuJsonByRole(String roleId);
    
    public Map getSubMenuJsontByUpId(Map<String,String> param);
    
    public List getSubTwoLevelMenuList(Map<String,String> param);
    
    public PageModel getSubMenuPagerListByUpId(String menuId,int pageNo,int pageSize);
    
    public int insert(TbMenu menu);
	
	public int update(TbMenu menu);
	
	public int delete(TbMenu menu);
	
	public Map OptMenuList(MenuOptBean menuOptBean);
	
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
	 public List getSubMenuNoRoleListByUpId(String menuId);
	 
	 /**     
	    * 查询用户角色未选择的菜单 
	    *    
	    * @param roleId
	    * @return [返回类型说明]
	    * 
	    * rover.lee
	    * Feb 11, 2014
	    */
	   public List<TbMenu> getNoSelectRootMenuByRole(String roleId);
	   
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
	   public List<TbMenu> getNoSelectSubMenuListByUpId(Map map);
	   
	   public void saveRoleMenu(Map<String,String> m);
	   
	   public List<TbMenu> getRootMenuListByRoles(List<TbRole> tbRoleList);
	   
	   public List<TbMenu> getSubMenuListByUpIdAndRole(Map map);
}
