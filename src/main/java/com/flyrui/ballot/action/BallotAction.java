package com.flyrui.ballot.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.flyrui.ballot.service.BallotService;
import com.flyrui.common.SpringBeans;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.utls.Const;
import com.flyrui.dao.common.page.PageModel;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.SessionCheckAnnotation;
import com.flyrui.salary.service.SalaryService;

public class BallotAction extends BaseAction {	

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(BallotAction.class);
	public List<Map> ballotList;
	public List<Map> questionList;
    public String ballotId; 
    
    public String questionId; 
    
    public String ballotDetails;
    
    public String queryResult;
    
    public int rows; //每页大小
	
	public int page;//当前页号
    
    public BallotService getBallotService(){
    	return (BallotService)SpringBeans.getBean("ballotService");
    }
    
    public List<Map> getBallotList(){
    	return this.ballotList;
    }
    
    public List<Map> getQuestionList(){
    	return this.questionList;
    }
    
    
    
    /**
     * 
     * 根据问卷ID查询问卷和答案信息
     * 
     * @return [返回类型说明]
     * 
     * rover.lee
     * Sep 14, 2014
     */
    
    @SessionCheckAnnotation(needCheckSession="false")
    public String showBallotDetail(){
    	String returnCode="showBallotDetail";
    	BallotService ballotService = getBallotService();
    	ballotList =  ballotService.queryBallotById(ballotId);
    	questionList =  ballotService.queryBallotQuestionByBallotId(ballotId);
    	if(questionList!=null && questionList.size()>0){
    		List<Map> statResultList = new ArrayList<Map>();
    		if(queryResult!=null && queryResult.equals("1")){
    			returnCode="showBallotResult";
    			Map p = new HashMap();
    			p.put("ballot_id", ballotId);
    			statResultList = ballotService.queryBallotStatByBallotId(p);
    		}
    		//查询问题下面的答案
    		for(Map qeustionMap : questionList){
    			String questionId = Const.getStrValue(qeustionMap, "question_id");
    			List<Map> answerList = ballotService.queryBallotAnswerByQuestionId(questionId);
    			if(statResultList.size()>0){//如果查了统计，则加入
    				for(Map answerMap : answerList){
    					String answerId = (String)answerMap.get("answer_id");
    					for(Map resultMap : statResultList){
    						String nnAnswerId = (String)resultMap.get("answer_id");
    						if(nnAnswerId.equals(answerId)){
    							answerMap.put("answer_total", resultMap.get("answer_total"));
    							answerMap.put("cur_answer_total", resultMap.get("cur_answer_total"));
    							answerMap.put("answer_rate", resultMap.get("answer_rate"));
    							break;
    						}    						
    					}
    				}
    			}
    			qeustionMap.put("answerList", answerList);
    		}    		
    	}    	
    	return returnCode;
   }  
   
    /**     
     * 插入详情
     * 
     * @return
     * @throws FRException [返回类型说明]
     * 
     * rover.lee
     * Sep 14, 2014
     */
   
   @SessionCheckAnnotation(needCheckSession="false")
   public String insertBallotDetail() throws FRException{
	   String[] ballotDetailList = ballotDetails.split("/");
	   String strIp = getIp();
	   BallotService ballotService = getBallotService();
	   Map param = new HashMap();
	   param.put("ballot_id", ballotId);
	   param.put("ip", strIp);
	   List retList = ballotService.queryBallotDetailByBalloatIdAndIp(param);
	   if(retList!=null && retList.size()>0){
		   throw new FRException(new FRError(ErrorConstants.BALLOT_IP_SBMIT_REPEAT));
	   }
	   
	   List<Map> detailList = new ArrayList<Map>();
	   for(int i=0;i<=ballotDetailList.length - 4;i=i+4){
		    Map m = new HashMap();
			m.put("ballot_id",ballotDetailList[0+i]);
		    m.put("question_id", ballotDetailList[1+i]);
		    m.put("answer_id", ballotDetailList[2+i]);
		    m.put("ip", strIp);
		    m.put("answer_content", ballotDetailList[3+i]);
		    detailList.add(m);
	   }
	   int n = ballotService.insertBallotDetail(detailList);
	   setResult(n);
	   return "insertBallotDetail";
   }
    
   /**
    * 
    * 获取每个问题下面的答案
    * 
    * @return [返回类型说明]
    * 
    * rover.lee
    * Oct 8, 2014
    */
   @SessionCheckAnnotation(needCheckSession="false")
   public String queryBallotQuestionAnswer(){
	BallotService ballotService = getBallotService();
	Map param = new HashMap();
	param.put("ballot_id", ballotId);
	param.put("question_id", questionId);
   	PageModel pageModel = ballotService.queryBallotQuestionAnswer(param, page, rows);     		
   	setResult(pageModel);
   	return SUCCESS;
   }
    
    
}
