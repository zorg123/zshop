package com.flyrui.infoshare.train.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.infoshare.asset.pojo.InfoAsset;
import com.flyrui.infoshare.train.pojo.InfoTrain;     		
import com.flyrui.infoshare.train.service.InfoTrainService;     		


@Service(value="infoTrainService")
public class InfoTrainServiceImpl extends BaseService<InfoTrain> implements InfoTrainService {	
	public InfoTrainServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.train.dao.mapper.InfoTrainMapper");
	}
	
	@Transactional
	public int update(InfoTrain infoTrain){
		List<InfoTrain> InfoTrainList = super.queryById("queryMaxSeq", infoTrain);
		int maxSeq= 0;
		if(InfoTrainList.size()>0){
			InfoTrain infoTrainTemp = InfoTrainList.get(0);
			maxSeq = infoTrainTemp==null?0:infoTrainTemp.getSeq()+1;
		}
		int cnt=0;
		infoTrain.setSeq(0);
		if(infoTrain.getState()==null){
			infoTrain.setState("2");
		}
		infoTrain.setCreate_date(new Date());
		if(maxSeq!=0){
			//备份原纪录
			InfoTrain infoTrainTemp = new InfoTrain();
			infoTrainTemp.setTrain_id(infoTrain.getTrain_id());
			infoTrainTemp.setSeq(maxSeq);
			super.insertById("bakOldRecord", infoTrainTemp);
			cnt = super.update(infoTrain);
		}else{	
			
			infoTrain.setTrain_id(UUIDHexGenerator.generator());
			cnt = super.insert(infoTrain);
		}
		
		return cnt;
	}
	@Transactional
	@Override
	public int deleteByIds(String ids) {
		   int retV = 0;
			if(ids != null ){		
				String[] idArr = ids.split(",");
				if(idArr.length >0){
					InfoTrain infoTrain = null;
					for(String id : idArr){
						infoTrain= new InfoTrain();
						infoTrain.setTrain_id(id);
						super.delete(infoTrain);
						retV++;
					}
				}
			}
			return retV;
	}
}
