package ${packageName};

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
<#list importList as import>
${import}     		
</#list>

public interface ${serviceName} {
		
	
	public int insert(${beanName} ${beanNameLow});
	
	public int update(${beanName} ${beanNameLow});
	
	public int delete(${beanName} ${beanNameLow});
	
	public List<${beanName}> getListByCon(${beanName} ${beanNameLow});
	
	public PageModel getPagerListByCon(${beanName} ${beanNameLow},int pageNo,int pageSize);	
}
