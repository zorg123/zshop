package com.flyrui.sys.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.sys.dto.TbNoticeLog;     		
import com.flyrui.sys.service.TbNoticeLogService;     		


@Service(value="tbNoticeLogService")
public class TbNoticeLogServiceImpl extends BaseService<TbNoticeLog> implements TbNoticeLogService {	
	public TbNoticeLogServiceImpl(){
		super.setNameSpace("com.flyrui.sys.dao.mapper.TbNoticeLogMapper");
	}
}
