package com.flyrui.infoshare.common.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.common.pojo.InfoFile;     		

public interface InfoFileService {
		
	
	public int insert(InfoFile infoFile);
	
	public int update(InfoFile infoFile);
	
	public int delete(InfoFile infoFile);
	
	public List<InfoFile> getListByCon(InfoFile infoFile);
	
	public PageModel getPagerListByCon(InfoFile infoFile,int pageNo,int pageSize);	
}
