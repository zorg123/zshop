package com.flyrui.infoshare.staff.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.infoshare.staff.pojo.InfoUserExt;
import com.flyrui.infoshare.staff.service.InfoUserExtService;


@Service(value="infoUserExtService")
public class InfoUserExtServiceImpl extends BaseService<InfoUserExt> implements InfoUserExtService {	
	public InfoUserExtServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.staff.dao.mapper.InfoUserExtMapper");
	}
	
	/**
	 * 更新的时候，需要先置失效老记录，再修改
	 */
	@Transactional
	public int update(InfoUserExt infoUserExt){
		List<InfoUserExt> infoUserExtList = super.queryById("queryMaxSeq", infoUserExt);
		int maxSeq= 0;
		if(infoUserExtList.size()>0){
			InfoUserExt infoUserExtTemp = infoUserExtList.get(0);
			maxSeq = infoUserExtTemp==null?0:infoUserExtTemp.getSeq()+1;
		}
		int cnt=0;
		infoUserExt.setSeq(0);
		infoUserExt.setState("1");
		if(maxSeq!=0){
			//备份原纪录
			InfoUserExt infoUserExtTemp = new InfoUserExt();
			infoUserExtTemp.setUser_id(infoUserExt.getUser_id());
			infoUserExtTemp.setSeq(maxSeq);
			infoUserExtTemp.setState("1");
			super.insertById("bakOldRecord", infoUserExtTemp);
			cnt = super.update(infoUserExt);
		}else{			
			cnt = super.insert(infoUserExt);
		}
		
		return cnt;
	}

	@Override
	public List<InfoUserExt> getDetailInfoByCon(InfoUserExt infoUserExt) {
		
		return super.queryById("selectAll", infoUserExt);
	}
	
	
}
