package com.flyrui.infoshare.asset.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.infoshare.asset.pojo.InfoAsset;
import com.flyrui.infoshare.asset.service.InfoAssetService;


@Service(value="infoAssetService")
public class InfoAssetServiceImpl extends BaseService<InfoAsset> implements InfoAssetService {	
	public InfoAssetServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.asset.dao.mapper.InfoAssetMapper");
	}
	
	@Transactional
	public int update(InfoAsset infoAsset){
		List<InfoAsset> infoAssetList = super.queryById("queryMaxSeq", infoAsset);
		int maxSeq= 0;
		if(infoAssetList.size()>0){
			InfoAsset infoAssetTemp = infoAssetList.get(0);
			maxSeq = infoAssetTemp==null?0:infoAssetTemp.getSeq()+1;
		}
		int cnt=0;
		infoAsset.setSeq(0);
		infoAsset.setUse_state("1");
		infoAsset.setCreate_date(new Date());
		if(maxSeq!=0){
			//备份原纪录
			InfoAsset infoUserExtTemp = new InfoAsset();
			infoUserExtTemp.setAsset_id(infoAsset.getAsset_id());
			infoUserExtTemp.setSeq(maxSeq);
			infoUserExtTemp.setUse_state("1");
			super.insertById("bakOldRecord", infoUserExtTemp);
			cnt = super.update(infoAsset);
		}else{		
			infoAsset.setAsset_id(UUIDHexGenerator.generator());
			cnt = super.insert(infoAsset);
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
					InfoAsset infoAsset = null;
					for(String id : idArr){
						infoAsset= new InfoAsset();
						infoAsset.setAsset_id(id);
						super.delete(infoAsset);
						retV++;
					}
				}
			}
			return retV;
	}

}
