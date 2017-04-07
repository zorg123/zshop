package com.flyrui.infoshare.train.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.train.pojo.InfoTrainAudit;     		
import com.flyrui.infoshare.train.service.InfoTrainAuditService;     		


@Service(value="infoTrainAuditService")
public class InfoTrainAuditServiceImpl extends BaseService<InfoTrainAudit> implements InfoTrainAuditService {	
	public InfoTrainAuditServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.train.dao.mapper.InfoTrainAuditMapper");
	}
}
