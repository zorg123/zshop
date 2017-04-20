package com.flyrui.sys.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.flyrui.common.service.BaseService;
import com.flyrui.sys.dto.InfodictDto;
import com.flyrui.sys.service.InfodictService;

@Service(value="infodictService")
public class InfodictServiceImpl extends BaseService implements InfodictService {
	
	public InfodictServiceImpl(){
		   super.setNameSpace("com.flyrui.dao.mapper.InfodictMapper");
	}
	
	public List<InfodictDto> queryInfoDictList(InfodictDto infodictDto){
		return baseDao.selectList(this.nameSpace+".queryInfoDictList", infodictDto);
	}
	
	public int updateInfoDict(InfodictDto infodictDto){
		return baseDao.update(this.nameSpace+".updateInfoDict", infodictDto);
	}
	
	public int insertInfoDict(InfodictDto infodictDto){
		return baseDao.update(this.nameSpace+".insertInfoDict", infodictDto);
	}
	
}
