package com.flyrui.infoshare.train.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.train.pojo.InfoTrainAuditStaff;     		

public interface InfoTrainAuditStaffService {
		
	
	public int insert(InfoTrainAuditStaff infoTrainAuditStaff);
	
	public int update(InfoTrainAuditStaff infoTrainAuditStaff);
	
	public int delete(InfoTrainAuditStaff infoTrainAuditStaff);
	
	public List<InfoTrainAuditStaff> getListByCon(InfoTrainAuditStaff infoTrainAuditStaff);
	
	public PageModel getPagerListByCon(InfoTrainAuditStaff infoTrainAuditStaff,int pageNo,int pageSize);	
}
