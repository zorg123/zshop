package com.flyrui.channel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.channel.service.ChannelExtService;
import com.flyrui.channel.service.ChannelService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.channel.FrChannel;
import com.flyrui.dao.pojo.channel.FrChannelExt;

@Service(value="channelService")
public class ChannelServiceImpl extends BaseService<FrChannel> implements ChannelService {	
   public ChannelServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.FrChannelMapper");
   }

   /**
    * 查询栏目信息列表
    * @param frChannel
    * @return
    */
	public List<FrChannel> queryChannelInfoList(FrChannel frChannel) {
		return super.queryById("queryAllWithExt",frChannel);
	}
	
	public PageModel getPagerListByCon(FrChannel frChannel,int pageNo,int pageSize){
		return getPagerList(frChannel,getNameSpace()+".queryAllWithExt",pageNo,pageSize) ;
	}
	
	@Transactional
	public int insert(FrChannel frChannel){
		String seqId = getSequence("seq_channel_id");
		frChannel.setChannel_id(Integer.valueOf(seqId));
		int cnt = super.insert(frChannel);
		ChannelExtService  channelExtService = (ChannelExtService)SpringBeans.getBean("channelExtService");
		FrChannelExt frChannelExt = (FrChannelExt)frChannel;
		return channelExtService.insert(frChannelExt);
	}
	
	@Transactional
	public int update(FrChannel frChannel){		
		super.update(frChannel);
		ChannelExtService  channelExtService = (ChannelExtService)SpringBeans.getBean("channelExtService");
		FrChannelExt frChannelExt = (FrChannelExt)frChannel;
		return channelExtService.update(frChannelExt);
	}
	
	@Transactional
	public int delete(FrChannel frChannel){	
		ChannelExtService  channelExtService = (ChannelExtService)SpringBeans.getBean("channelExtService");
		FrChannelExt frChannelExt = (FrChannelExt)frChannel;
		channelExtService.delete(frChannelExt);
		return super.delete(frChannel);
	}
	
 }
