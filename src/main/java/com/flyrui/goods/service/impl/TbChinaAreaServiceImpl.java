package com.flyrui.goods.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flyrui.common.service.BaseService;
import com.flyrui.goods.pojo.TbChinaArea;     		
import com.flyrui.goods.service.TbChinaAreaService;     		


@Service(value="tbChinaAreaService")
public class TbChinaAreaServiceImpl extends BaseService<TbChinaArea> implements TbChinaAreaService {	
	public TbChinaAreaServiceImpl(){
		super.setNameSpace("com.flyrui.goods.dao.mapper.TbChinaAreaMapper");
	}
}
