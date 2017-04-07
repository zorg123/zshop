package com.flyrui.infoshare.common.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class InfoFile implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 文件id */
	private String file_id;

	/** 文件名字 */
	private String file_name;

	/** 文件类型 */
	private String file_type;

	/** 文件大小 */
	private Integer file_size;

	/** 文件保存名字 */
	private String file_key;

	/** 创建时间 */
	private Date create_date;


	public String getFile_id() {
		return this.file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return this.file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return this.file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public Integer getFile_size() {
		return this.file_size;
	}

	public void setFile_size(Integer file_size) {
		this.file_size = file_size;
	}

	public String getFile_key() {
		return this.file_key;
	}

	public void setFile_key(String file_key) {
		this.file_key = file_key;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
