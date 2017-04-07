package com.flyrui.infoshare.meeting.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.meeting.pojo.InfoMeeting;     		
import com.flyrui.infoshare.meeting.service.InfoMeetingService;     		


@Service(value="infoMeetingService")
public class InfoMeetingServiceImpl extends BaseService<InfoMeeting> implements InfoMeetingService {	
	public InfoMeetingServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.meeting.dao.mapper.InfoMeetingMapper");
	}
}
