package com.flyrui.sys.service;

import java.util.HashMap;
import java.util.List;

public interface FrconfigService {
	
	public int updateFrConfig(HashMap map) ;
	
	public List<HashMap> queryFrCfgList(HashMap map);	
	
}
