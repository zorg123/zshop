package com.flyrui.ballot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flyrui.ballot.service.BallotService;
import com.flyrui.common.service.BaseService;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryCriteria;
import com.flyrui.dao.pojo.salary.BusSalaryLevel;
import com.flyrui.dao.pojo.salary.BusSalaryCriteria.Criteria;

@Service(value="ballotService")
public class BallotServiceImpl extends BaseService implements BallotService {	   
	public BallotServiceImpl(){
	   super.setNameSpace("com.flyrui.dao.mapper.ballot");
    }

	public List<Map> queryBallotAnswerByQuestionId(String questionId) {		
		return queryById("queryBallotAnswerByQuestionId",questionId);
	}
	
	public List<Map> queryBallotById(String ballotId) {
		return queryById("queryBallotById",ballotId);
	}
	
	public List<Map> queryBallotQuestionByBallotId(String ballotId) {
		return queryById("queryBallotQuestionByBallotId",ballotId);
	}

	public int insertBallotDetail(List <Map> param) {
		int cnt =0;
		for(Map m : param){
			int c = insertById("insertBallotDetail",m);
			cnt +=c;
		}
		return cnt;
	}  
	
	public List<Map> queryBallotDetailByBalloatIdAndIp(Map param){
		return queryById("queryBallotDetailByBalloatIdAndIp",param);
	}
	
	public List<Map> queryBallotStatByBallotId(Map param){
		return queryById("queryBallotStatByBallotId",param);
	}
   
	public PageModel queryBallotQuestionAnswer(Map param,int pageNo,int pageSize){		
		return getPagerList(param,getNameSpace()+".queryBallotQuestionAnswer",pageNo,pageSize);
	}
}
