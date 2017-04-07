package com.flyrui.infoshare.common.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.common.pojo.InfoServFile;     		

public interface InfoServFileService {
		
	
	public int insert(InfoServFile infoServFile);
	
	public int update(InfoServFile infoServFile);
	
	public int delete(InfoServFile infoServFile);
	
	public List<InfoServFile> getListByCon(InfoServFile infoServFile);
	
	public PageModel getPagerListByCon(InfoServFile infoServFile,int pageNo,int pageSize);	
	
	public List<InfoServFile> queryServFileByRelaId(InfoServFile infoServFile);
}
