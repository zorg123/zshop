package com.flyrui.infoshare.common.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;


/**
 *
 * 
 *
 */
@Component("infoSqlConfig")
public class InfoSqlConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private Integer sql_id;

	/** 1 返回list 2 返回map */
	private String sql_type;

	/**  */
	private String sql_body_content;

	/** where语句,使用/分开，如果条件不存在，则生成条件 */
	private String sql_where;

	/** 条件变量 */
	private String sql_param;

	/**  */
	private String sql_desc;

	/**  */
	private Date create_date;


	public Integer getSql_id() {
		return this.sql_id;
	}

	public void setSql_id(Integer sql_id) {
		this.sql_id = sql_id;
	}

	public String getSql_type() {
		return this.sql_type;
	}

	public void setSql_type(String sql_type) {
		this.sql_type = sql_type;
	}

	public String getSql_body_content() {
		return this.sql_body_content;
	}

	public void setSql_body_content(String sql_body_content) {
		this.sql_body_content = sql_body_content;
	}

	public String getSql_where() {
		return this.sql_where;
	}

	public void setSql_where(String sql_where) {
		this.sql_where = sql_where;
	}

	public String getSql_param() {
		return this.sql_param;
	}

	public void setSql_param(String sql_param) {
		this.sql_param = sql_param;
	}

	public String getSql_desc() {
		return this.sql_desc;
	}

	public void setSql_desc(String sql_desc) {
		this.sql_desc = sql_desc;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
