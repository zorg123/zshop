package com.flyrui.infoshare.staff.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.staff.pojo.InfoUserExt;     		

public interface InfoUserExtService {
		
	
	public int insert(InfoUserExt infoUserExt);
	
	public int update(InfoUserExt infoUserExt);
	
	public int delete(InfoUserExt infoUserExt);
	
	public List<InfoUserExt> getListByCon(InfoUserExt infoUserExt);
	
	public PageModel getPagerListByCon(InfoUserExt infoUserExt,int pageNo,int pageSize);
	
	public List<InfoUserExt> getDetailInfoByCon(InfoUserExt infoUserExt);
	
	public int batchInsert(List<InfoUserExt> infoUserExt);
}
