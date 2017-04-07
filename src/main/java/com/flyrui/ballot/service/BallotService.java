package com.flyrui.ballot.service;

import java.util.List;
import java.util.Map;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryLevel;

public interface BallotService {	

	public List<Map> queryBallotById(String ballotId);
	
	public List<Map> queryBallotQuestionByBallotId(String ballotId);	
	
	public List<Map> queryBallotAnswerByQuestionId(String questionId);
	
	public int insertBallotDetail(List<Map> param);
	
	public List<Map> queryBallotDetailByBalloatIdAndIp(Map param);
	
	public List<Map> queryBallotStatByBallotId(Map param);
	
	public PageModel queryBallotQuestionAnswer(Map param,int pageNo,int pageSize);
}
