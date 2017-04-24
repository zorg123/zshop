package com.flyrui.goods.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * 
 *
 */
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 商品id */
	private String goods_id;

	/** 所属目录 */
	private String catalog_id;

	/** 商品名称 */
	private String goods_name;

	/** 商品别名 简短提示 */
	private String goods_alias;

	/** 1 有效 0 无效 */
	private String state;

	/** 生效时间 */
	private Date eff_date;

	/** 失效时间 */
	private Date exp_date;

	/** 商品类型，所属模块 1 长期拼 2 短期拼 这个也可以用目录来区分 */
	private String goods_type;

	/** 商品数量 */
	private Integer goods_amount;

	/** 商品价格 */
	private Double goods_price;

	/** 商品市场价,展示用 */
	private Double goods_market_price;

	/** 支付类型 0 两种都支持 2 电子币 3 重销币  */
	private String pay_type;

	/** 商品描述 */
	private String goods_desc;

	/** 缩略图片,列表展示时用 */
	private String icon_url;

	/** 详情展示时轮播图,可用,分割 */
	private String pic_url;

	/** 创建时间 */
	private Date create_date;

	/** 记录更新时间 */
	private Date state_date;

	/** 创建人id */
	private String create_user_id;

	/** 排序id 商品的展示顺序 */
	private Integer order_id;

	/** 详情页面展示的title，用于搜索引擎搜索到 */
	private String goods_title;

	/** 详情页面展示的关键字，用于搜索引擎搜索到 */
	private String goods_keywords;

	/** 详情页面展示的页面描述，用于搜索引擎搜索到 */
	private String goods_descriptions;


	public String getGoods_id() {
		return this.goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getCatalog_id() {
		return this.catalog_id;
	}

	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}

	public String getGoods_name() {
		return this.goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_alias() {
		return this.goods_alias;
	}

	public void setGoods_alias(String goods_alias) {
		this.goods_alias = goods_alias;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getGoods_type() {
		return this.goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}

	public Integer getGoods_amount() {
		return this.goods_amount;
	}

	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}

	public Double getGoods_price() {
		return this.goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	public Double getGoods_market_price() {
		return this.goods_market_price;
	}

	public void setGoods_market_price(Double goods_market_price) {
		this.goods_market_price = goods_market_price;
	}

	public String getPay_type() {
		return this.pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getGoods_desc() {
		return this.goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public String getIcon_url() {
		return this.icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getPic_url() {
		return this.pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
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

	public String getCreate_user_id() {
		return this.create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	public Integer getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getGoods_title() {
		return this.goods_title;
	}

	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}

	public String getGoods_keywords() {
		return this.goods_keywords;
	}

	public void setGoods_keywords(String goods_keywords) {
		this.goods_keywords = goods_keywords;
	}

	public String getGoods_descriptions() {
		return this.goods_descriptions;
	}

	public void setGoods_descriptions(String goods_descriptions) {
		this.goods_descriptions = goods_descriptions;
	}

}
