package ${packageName};

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
<#list importList as import>
${import}     		
</#list>


@Service(value="${springServiceName}")
public class ${serviceImplName} extends BaseService<${beanName}> implements ${serviceName} {	
	public ${serviceImplName}(){
		super.setNameSpace("${namesapce}");
	}
}
