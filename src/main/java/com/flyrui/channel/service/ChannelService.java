package com.flyrui.channel.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrChannel;

public interface ChannelService {
	
	public int insert(FrChannel frChannel);
	
	public int update(FrChannel frChannel);
	
	public int delete(FrChannel frChannel);
	
	public List<FrChannel> getListByCon(FrChannel frChannel);
	
	public PageModel getPagerListByCon(FrChannel frChannel,int pageNo,int pageSize);
	
	public List<FrChannel> queryChannelInfoList(FrChannel frChannel);
	
}
