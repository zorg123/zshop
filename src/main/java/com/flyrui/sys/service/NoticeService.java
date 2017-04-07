package com.flyrui.sys.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.sys.Notice;
import com.flyrui.dao.pojo.sys.TbNotice;

public interface NoticeService {
	
	public int insert(Notice notice)  ;
	
	public int update(Notice notice) ;
	
	public int delete(Notice notice);
	
	public List<TbNotice> selectList(TbNotice notice);	
	
	public PageModel getPagerListByCon(TbNotice notice,int pageNo,int pageSize);
	
	public Notice queryNoticeDetail(TbNotice notice);
	
	public List<Notice> queryEffNoticeList(Notice notice,int pageNo,int pageSize);
	
}
