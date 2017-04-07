package com.flyrui.channel.service.impl;

import org.springframework.stereotype.Service;

import com.flyrui.channel.service.ChannelExtService;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.channel.FrChannelExt;

@Service(value="channelExtService")
public class ChannelExtServiceImpl extends BaseService<FrChannelExt> implements ChannelExtService {	
   public ChannelExtServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.FrChannelExtMapper");
   }
 }
