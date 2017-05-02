package com.flyrui.sys.dto;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class FrConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private String cf_id;

	/**  */
	private String cf_desc;

	/**  */
	private String cf_value;

	/**  */
	private Date create_time;

	/**  */
	private String cf_module;


	public String getCf_id() {
		return this.cf_id;
	}

	public void setCf_id(String cf_id) {
		this.cf_id = cf_id;
	}

	public String getCf_desc() {
		return this.cf_desc;
	}

	public void setCf_desc(String cf_desc) {
		this.cf_desc = cf_desc;
	}

	public String getCf_value() {
		return this.cf_value;
	}

	public void setCf_value(String cf_value) {
		this.cf_value = cf_value;
	}

	public Date getCreate_time() {
		return this.create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCf_module() {
		return this.cf_module;
	}

	public void setCf_module(String cf_module) {
		this.cf_module = cf_module;
	}

}
