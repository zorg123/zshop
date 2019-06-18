package com.flyrui.sys.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.sys.dto.TbNoticeLog;     		

public interface TbNoticeLogService {
		
	
	public int insert(TbNoticeLog tbNoticeLog);
	
	public int update(TbNoticeLog tbNoticeLog);
	
	public int delete(TbNoticeLog tbNoticeLog);
	
	public List<TbNoticeLog> getListByCon(TbNoticeLog tbNoticeLog);
	
	public PageModel getPagerListByCon(TbNoticeLog tbNoticeLog,int pageNo,int pageSize);	
}
