package com.flyrui.infoshare.train.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.train.pojo.InfoTrain;     		

public interface InfoTrainService {
		
	
	public int insert(InfoTrain infoTrain);
	
	public int update(InfoTrain infoTrain);
	
	public int delete(InfoTrain infoTrain);
	
	public List<InfoTrain> getListByCon(InfoTrain infoTrain);
	
	public PageModel getPagerListByCon(InfoTrain infoTrain,int pageNo,int pageSize);
	
	public int deleteByIds(String ids);
}
