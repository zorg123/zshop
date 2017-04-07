package com.flyrui.infoshare.common.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.common.pojo.InfoFile;     		
import com.flyrui.infoshare.common.service.InfoFileService;     		


@Service(value="infoFileService")
public class InfoFileServiceImpl extends BaseService<InfoFile> implements InfoFileService {	
	public InfoFileServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.common.dao.mapper.InfoFileMapper");
	}
}
