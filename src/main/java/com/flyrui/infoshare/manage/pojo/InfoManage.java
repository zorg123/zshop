package com.flyrui.infoshare.manage.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.flyrui.infoshare.common.pojo.InfoServFile;


/**
 *
 * 
 *
 */
public class InfoManage implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 管理id */
	private String manage_id;

	/** 记录顺序 */
	private Integer seq;

	/** 类型 MAN 管理办法 SYS 制度文件 */
	private String manange_type;

	/** 标题 */
	private String titile;

	/** 内容 */
	private String content;

	/** 生效时间 */
	private Date eff_date;

	/** 失效时间 */
	private Date exp_date;

	/** 状态 1 有效 0 失效 */
	private String state;

	/** 创建时间 */
	private Date create_date;
	
	private String create_date_start;
	
	private String create_date_end;
	
	private List<InfoServFile> infoServFileList;


	public String getManage_id() {
		return this.manage_id;
	}

	public void setManage_id(String manage_id) {
		this.manage_id = manage_id;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getManange_type() {
		return this.manange_type;
	}

	public void setManange_type(String manange_type) {
		this.manange_type = manange_type;
	}

	public String getTitile() {
		return this.titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEff_date() {
		return this.eff_date;
	}

	public void setEff_date(Date eff_date) {
		this.eff_date = eff_date;
	}

	public Date getExp_date() {
		return this.exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
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

	public String getCreate_date_start() {
		return create_date_start;
	}

	public void setCreate_date_start(String create_date_start) {
		this.create_date_start = create_date_start;
	}

	public String getCreate_date_end() {
		return create_date_end;
	}

	public void setCreate_date_end(String create_date_end) {
		this.create_date_end = create_date_end;
	}

	public List<InfoServFile> getInfoServFileList() {
		return infoServFileList;
	}

	public void setInfoServFileList(List<InfoServFile> infoServFileList) {
		this.infoServFileList = infoServFileList;
	}
	
}
