package com.flyrui.goods.pojo;

import java.io.Serializable;


/**
 *
 * 
 *
 */
public class TbChinaArea implements Serializable {

	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;

	/**  */
	private String name;

	/**  */
	private Integer pid;

	/**  */
	private Integer sort;

	/**  */
	private Integer level;

	/**  */
	private String longcode;

	/**  */
	private String code;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLongcode() {
		return this.longcode;
	}

	public void setLongcode(String longcode) {
		this.longcode = longcode;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
