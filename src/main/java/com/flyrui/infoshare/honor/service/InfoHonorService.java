package com.flyrui.infoshare.honor.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.honor.pojo.InfoHonor;     		

public interface InfoHonorService {
		
	
	public int insert(InfoHonor infoHonor);
	
	public int update(InfoHonor infoHonor);
	
	public int delete(InfoHonor infoHonor);
	
	public List<InfoHonor> getListByCon(InfoHonor infoHonor);
	
	public PageModel getPagerListByCon(InfoHonor infoHonor,int pageNo,int pageSize);	
}
