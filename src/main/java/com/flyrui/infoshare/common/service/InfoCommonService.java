package com.flyrui.infoshare.common.service;

import java.util.List;
import java.util.Map;

public interface InfoCommonService {
	public List queryListBySqlId(Map param) throws Exception;
	public Map queryMapBySqlId(Map param) throws Exception;
}
