package com.flyrui.infoshare.train.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.train.pojo.InfoTrainAuditStaff;     		
import com.flyrui.infoshare.train.service.InfoTrainAuditStaffService;     		


@Service(value="infoTrainAuditStaffService")
public class InfoTrainAuditStaffServiceImpl extends BaseService<InfoTrainAuditStaff> implements InfoTrainAuditStaffService {	
	public InfoTrainAuditStaffServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.train.dao.mapper.InfoTrainAuditStaffMapper");
	}
}
