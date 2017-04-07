package com.flyrui.infoshare.manage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.infoshare.common.pojo.InfoServFile;
import com.flyrui.infoshare.common.service.InfoServFileService;
import com.flyrui.infoshare.manage.pojo.InfoManage;
import com.flyrui.infoshare.manage.service.InfoManageService;


@Service(value="infoManageService")
public class InfoManageServiceImpl extends BaseService<InfoManage> implements InfoManageService {	
	
	@Autowired
	private InfoServFileService infoServFileService;
	
	public InfoManageServiceImpl(){
		super.setNameSpace("com.flyrui.infoshare.manage.dao.mapper.InfoManageMapper");
	}
	
	@Transactional
	public int update(InfoManage infoManage){
		List<InfoManage> infoManageList = super.queryById("queryMaxSeq", infoManage);
		int maxSeq= 0;
		if(infoManageList.size()>0){
			InfoManage infoManageTemp = infoManageList.get(0);
			maxSeq = infoManageTemp==null?0:infoManageTemp.getSeq()+1;
		}
		int cnt=0;
		infoManage.setSeq(0);
		if(infoManage.getState()==null){
			infoManage.setState("1");
		}
		infoManage.setCreate_date(new Date());
		if(maxSeq!=0){
			//备份原纪录
			InfoManage infoManageTemp = new InfoManage();
			infoManageTemp.setManage_id(infoManage.getManage_id());
			infoManageTemp.setSeq(maxSeq);
			super.insertById("bakOldRecord", infoManageTemp);
			cnt = super.update(infoManage);
		}else{	
			
			infoManage.setManage_id(UUIDHexGenerator.generator());
			cnt = super.insert(infoManage);
		}
		
		//
		InfoServFile infoServFile = new InfoServFile();
		infoServFile.setRela_id(infoManage.getManage_id());
		infoServFileService.delete(infoServFile);
		if(infoManage.getInfoServFileList()!=null && infoManage.getInfoServFileList().size()>0){
			for(InfoServFile infoServFileTemp : infoManage.getInfoServFileList()){
				infoServFileTemp.setRela_id(infoManage.getManage_id());
				infoServFileTemp.setId(UUIDHexGenerator.generator());
				infoServFileService.insert(infoServFileTemp);
			}
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
					InfoManage infoManage = null;
					for(String id : idArr){
						infoManage= new InfoManage();
						infoManage.setManage_id(id);
						super.delete(infoManage);
						retV++;
					}
				}
			}
		 return retV;
	}
}
