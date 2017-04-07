package com.flyrui.infoshare.meeting.service;

import java.util.List;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.meeting.pojo.InfoMeeting;     		

public interface InfoMeetingService {
		
	
	public int insert(InfoMeeting infoMeeting);
	
	public int update(InfoMeeting infoMeeting);
	
	public int delete(InfoMeeting infoMeeting);
	
	public List<InfoMeeting> getListByCon(InfoMeeting infoMeeting);
	
	public PageModel getPagerListByCon(InfoMeeting infoMeeting,int pageNo,int pageSize);	
}
