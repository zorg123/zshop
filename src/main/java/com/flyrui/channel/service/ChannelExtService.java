package com.flyrui.channel.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrChannelExt;

public interface ChannelExtService {
	
	public int insert(FrChannelExt frChannel);
	
	public int update(FrChannelExt frChannel);
	
	public int delete(FrChannelExt frChannel);
	
	public List<FrChannelExt> getListByCon(FrChannelExt frChannel);
	
	public PageModel getPagerListByCon(FrChannelExt frChannel,int pageNo,int pageSize);
	
}
