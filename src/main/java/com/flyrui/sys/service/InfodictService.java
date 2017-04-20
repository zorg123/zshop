package com.flyrui.sys.service;

import java.util.List;
import com.flyrui.sys.dto.InfodictDto;

public interface InfodictService {
		
	public List<InfodictDto> queryInfoDictList(InfodictDto infodictDto);
	
	public int updateInfoDict(InfodictDto infodictDto);
		
	public int insertInfoDict(InfodictDto infodictDto);
}
