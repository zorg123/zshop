package com.flyrui.infoshare.asset.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;


/**
 *
 * 
 *
 */
public class InfoAsset implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 资产ID */
	private String asset_id;

	/** 记录顺序 */
	private Integer seq;

	/** 资产编号 */
	@ExcelAnnotation(exportName = "资产编号")
	private String asset_code;

	/** 资产分类 */
	@ExcelAnnotation(exportName = "资产分类")
	private String asset_class;

	/** 资产名称 */
	@ExcelAnnotation(exportName = "资产名称")
	private String asset_name;

	/** 制单时间 */
	@ExcelAnnotation(exportName = "制单时间")
	private Date make_date;

	/** 取得日期 */
	@ExcelAnnotation(exportName = "取得日期")
	private Date get_date;

	/** 规格型号 */
	@ExcelAnnotation(exportName = "规格型号")
	private String asset_type;

	/** 数量 */
	@ExcelAnnotation(exportName = "数量")
	private Integer asset_amount;

	/** 面积 */
	@ExcelAnnotation(exportName = "面积")
	private Integer asset_area;

	/** 价值 */
	@ExcelAnnotation(exportName = "价值")
	private Integer asset_cost;

	/** 使用部门 */
	@ExcelAnnotation(exportName = "使用部门")
	private String use_department;

	/** 取得方式 */
	@ExcelAnnotation(exportName = "取得方式")
	private String get_method;

	/** 使用人 */
	@ExcelAnnotation(exportName = "使用人")
	private String use_staff;

	/** 存放地点 */
	@ExcelAnnotation(exportName = "存放地点")
	private String place;

	/** 使用方向 */
	@ExcelAnnotation(exportName = "使用方向")
	private String use_direction;

	/** 使用状况 1 在用 2 失效 */
	@ExcelAnnotation(exportName = "使用状况")
	private String use_state;

	/** 车辆用途 */
	@ExcelAnnotation(exportName = "车辆用途")
	private String bus_use;

	/** 备注 */
	@ExcelAnnotation(exportName = "备注")
	private String comments;

	/** 生产厂商 */
	@ExcelAnnotation(exportName = "生产厂商")
	private String factory;

	/** 管理模式 */
	private String manage_mode;

	/** 共享模式 */
	private String share_method;

	/** 创建时间 */
	private Date create_date;

	/** 状态时间 */
	private Date state_date;

	/**  资产分类名称*/
	private String asset_class_name;

	/** 操作人 */
	private String oper_staff;
	
	/** 使用人部门名称 */
	private String use_department_name;
	
	/** 取得方式名称 */
	private String get_method_name;
	

	public String getAsset_id() {
		return this.asset_id;
	}

	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getAsset_code() {
		return this.asset_code;
	}

	public void setAsset_code(String asset_code) {
		this.asset_code = asset_code;
	}

	public String getAsset_class() {
		return this.asset_class;
	}

	public void setAsset_class(String asset_class) {
		this.asset_class = asset_class;
	}

	public String getAsset_name() {
		return this.asset_name;
	}

	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}

	public Date getMake_date() {
		return this.make_date;
	}

	public void setMake_date(Date make_date) {
		this.make_date = make_date;
	}

	public Date getGet_date() {
		return this.get_date;
	}

	public void setGet_date(Date get_date) {
		this.get_date = get_date;
	}

	public String getAsset_type() {
		return this.asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	public Integer getAsset_amount() {
		return this.asset_amount;
	}

	public void setAsset_amount(Integer asset_amount) {
		this.asset_amount = asset_amount;
	}

	public Integer getAsset_area() {
		return this.asset_area;
	}

	public void setAsset_area(Integer asset_area) {
		this.asset_area = asset_area;
	}

	public Integer getAsset_cost() {
		return this.asset_cost;
	}

	public void setAsset_cost(Integer asset_cost) {
		this.asset_cost = asset_cost;
	}

	public String getUse_department() {
		return this.use_department;
	}

	public void setUse_department(String use_department) {
		this.use_department = use_department;
	}

	public String getGet_method() {
		return this.get_method;
	}

	public void setGet_method(String get_method) {
		this.get_method = get_method;
	}

	public String getUse_staff() {
		return this.use_staff;
	}

	public void setUse_staff(String use_staff) {
		this.use_staff = use_staff;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUse_direction() {
		return this.use_direction;
	}

	public void setUse_direction(String use_direction) {
		this.use_direction = use_direction;
	}

	public String getUse_state() {
		return this.use_state;
	}

	public void setUse_state(String use_state) {
		this.use_state = use_state;
	}

	public String getBus_use() {
		return this.bus_use;
	}

	public void setBus_use(String bus_use) {
		this.bus_use = bus_use;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFactory() {
		return this.factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getManage_mode() {
		return this.manage_mode;
	}

	public void setManage_mode(String manage_mode) {
		this.manage_mode = manage_mode;
	}

	public String getShare_method() {
		return this.share_method;
	}

	public void setShare_method(String share_method) {
		this.share_method = share_method;
	}

	public Date getCreate_date() {
		return this.create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getState_date() {
		return this.state_date;
	}

	public void setState_date(Date state_date) {
		this.state_date = state_date;
	}

	public String getOper_staff() {
		return this.oper_staff;
	}

	public void setOper_staff(String oper_staff) {
		this.oper_staff = oper_staff;
	}

	public String getAsset_class_name() {
		return asset_class_name;
	}

	public void setAsset_class_name(String asset_class_name) {
		this.asset_class_name = asset_class_name;
	}

	public String getUse_department_name() {
		return use_department_name;
	}

	public void setUse_department_name(String use_department_name) {
		this.use_department_name = use_department_name;
	}

	public String getGet_method_name() {
		return get_method_name;
	}

	public void setGet_method_name(String get_method_name) {
		this.get_method_name = get_method_name;
	}

	
}
