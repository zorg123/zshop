package com.flyrui.infoshare.asset.service;

import java.util.List;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.infoshare.asset.pojo.InfoAsset;     		
import com.flyrui.infoshare.staff.pojo.InfoUserExt;

public interface InfoAssetService {
		
	
	public int insert(InfoAsset infoAsset);
	
	public int update(InfoAsset infoAsset);
	
	public int delete(InfoAsset infoAsset);
	
	public List<InfoAsset> getListByCon(InfoAsset infoAsset);
	
	public PageModel getPagerListByCon(InfoAsset infoAsset,int pageNo,int pageSize);	
	
	public int batchInsert(List<InfoAsset> infoAssetList);
	
	public int deleteByIds(String ids);
}
