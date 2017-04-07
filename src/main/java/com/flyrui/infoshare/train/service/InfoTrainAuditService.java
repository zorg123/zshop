package com.flyrui.infoshare.train.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.train.pojo.InfoTrainAudit;     		

public interface InfoTrainAuditService {
		
	
	public int insert(InfoTrainAudit infoTrainAudit);
	
	public int update(InfoTrainAudit infoTrainAudit);
	
	public int delete(InfoTrainAudit infoTrainAudit);
	
	public List<InfoTrainAudit> getListByCon(InfoTrainAudit infoTrainAudit);
	
	public PageModel getPagerListByCon(InfoTrainAudit infoTrainAudit,int pageNo,int pageSize);	
}
