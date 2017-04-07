package com.flyrui.infoshare.common.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoServFile implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private String id;

	/** 关联id */
	private String rela_id;

	/** 关联类型 */
	private String rela_type;

	/**  */
	private String file_id;

	/**  */
	private String state;

	/**  */
	private Date create_date;

	/**  */
	private String file_name;
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRela_id() {
		return this.rela_id;
	}

	public void setRela_id(String rela_id) {
		this.rela_id = rela_id;
	}

	public String getRela_type() {
		return this.rela_type;
	}

	public void setRela_type(String rela_type) {
		this.rela_type = rela_type;
	}

	public String getFile_id() {
		return this.file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

}
