package com.flyrui.infoshare.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.common.pojo.InfoServFile;
import com.flyrui.infoshare.common.service.InfoServFileService;


@Service(value="infoServFileService")
public class InfoServFileServiceImpl extends BaseService<InfoServFile> implements InfoServFileService {	
	public InfoServFileServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.common.dao.mapper.InfoServFileMapper");
	}
	
	@Override
	public List<InfoServFile> queryServFileByRelaId(InfoServFile infoServFile){
		return super.queryById("queryServFileByRelaId", infoServFile);
	}
}
