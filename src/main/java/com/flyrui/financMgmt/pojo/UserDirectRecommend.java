package com.flyrui.financMgmt.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class UserDirectRecommend {

	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private Integer pid;

	/**  */
	private Integer user_id;

	/** main:主账号 child:子账号 */
	private String user_type;

	/** 节点下所有2级会员个数,包含当前节点 */
	private String grade2Number;

	/** 节点下所有3级会员个数,包含当前节点 */
	private String grade3Number;

	/** 节点下所有4级会员个数,包含当前节点 */
	private String grade4Number;

	/** 节点下所有5级会员个数,包含当前节点 */
	private String grade5Number;
	
	private String state;
	
	private String user_level;
	
	private Integer allorder_num;
	
	private String user_code;
	
	private String name;
	
	private String preMonthGoodsSum;
	
	private String currentMonthGoodsSum;

	/**  */
	private Date create_time;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUser_id() {
		return this.user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_type() {
		return this.user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getGrade2Number() {
		return this.grade2Number;
	}

	public void setGrade2Number(String grade2Number) {
		this.grade2Number = grade2Number;
	}

	public String getGrade3Number() {
		return this.grade3Number;
	}

	public void setGrade3Number(String grade3Number) {
		this.grade3Number = grade3Number;
	}

	public String getGrade4Number() {
		return this.grade4Number;
	}

	public void setGrade4Number(String grade4Number) {
		this.grade4Number = grade4Number;
	}

	public String getGrade5Number() {
		return this.grade5Number;
	}

	public void setGrade5Number(String grade5Number) {
		this.grade5Number = grade5Number;
	}

	public Date getCreate_time() {
		return this.create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUser_level() {
		return user_level;
	}

	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}

	public Integer getAllorder_num() {
		return allorder_num;
	}

	public void setAllorder_num(Integer allorder_num) {
		this.allorder_num = allorder_num;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreMonthGoodsSum() {
		return preMonthGoodsSum;
	}

	public void setPreMonthGoodsSum(String preMonthGoodsSum) {
		this.preMonthGoodsSum = preMonthGoodsSum;
	}

	public String getCurrentMonthGoodsSum() {
		return currentMonthGoodsSum;
	}

	public void setCurrentMonthGoodsSum(String currentMonthGoodsSum) {
		this.currentMonthGoodsSum = currentMonthGoodsSum;
	}
	
}