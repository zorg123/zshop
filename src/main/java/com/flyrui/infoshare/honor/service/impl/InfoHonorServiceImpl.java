package com.flyrui.infoshare.honor.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.honor.pojo.InfoHonor;     		
import com.flyrui.infoshare.honor.service.InfoHonorService;     		


@Service(value="infoHonorService")
public class InfoHonorServiceImpl extends BaseService<InfoHonor> implements InfoHonorService {	
	public InfoHonorServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.honor.dao.mapper.InfoHonorMapper");
	}
}
