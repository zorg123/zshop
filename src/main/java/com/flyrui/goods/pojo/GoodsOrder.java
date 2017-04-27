package com.flyrui.goods.pojo;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;
/**
 *
 * 
 *
 */
public class GoodsOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 订单id */
	private String order_id;

	/** 订单编码 */
	@ExcelAnnotation(exportName = "订单编码")
	private String order_code;

	/** 商品id */
	private String goods_id;

	/** 商品名称 */
	@ExcelAnnotation(exportName = "商品名称")
	private String goods_name;

	/** 购买数量 */
	@ExcelAnnotation(exportName = "购买数量")
	private Integer goods_amount;

	/** 订单总费用 */
	@ExcelAnnotation(exportName = "金额")
	private Double total_fee;

	/** 订单优惠费用 */
	private Double refund_fee;

	/** 支付方式 */
	private String pay_type;

	/** 购买的用户id */
	private String user_id;

	/** 购买人名称 */
	@ExcelAnnotation(exportName = "会员名称")
	private String user_name;

	/** 收货人 */
	@ExcelAnnotation(exportName = "收货人")
	private String rev_people;

	/** 联系电话 */
	@ExcelAnnotation(exportName = "联系电话")
	private String rev_link_phone;

	/** 收货区域 */
	@ExcelAnnotation(exportName = "收货区域")
	private String rev_area;

	/** 收货地址 */
	@ExcelAnnotation(exportName = "详细地址")
	private String rev_addr;

	/** 收货备注 */
	private String rev_desc;

	/** 收货人发票类型 person compony */
	private String rev_invoice;

	/** 发票名称 */
	private String rev_invoice_name;

	/** 创建日期 */
	@ExcelAnnotation(exportName = "购买时间")
	private Date create_date;
	
	/** 订单状态 */
	private String state;
	
	@ExcelAnnotation(exportName = "订单状态")
	private String state_name;

	/** 状态变更时间 */
	@ExcelAnnotation(exportName = "发货时间")
	private Date state_date;

	/** 订购ip */
	private String ord_ip;

	/** 配送物流公司 */
	private String deal_exp_comp;

	/** 配送物流订单号 */
	@ExcelAnnotation(exportName = "物流单号")
	private String deal_exp_ord;

	private String state_date_start;
	
	private String state_date_end;


	public String getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_code() {
		return this.order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}

	public String getGoods_id() {
		return this.goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return this.goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Integer getGoods_amount() {
		return this.goods_amount;
	}

	public void setGoods_amount(Integer goods_amount) {
		this.goods_amount = goods_amount;
	}

	public Double getTotal_fee() {
		return this.total_fee;
	}

	public void setTotal_fee(Double total_fee) {
		this.total_fee = total_fee;
	}

	public Double getRefund_fee() {
		return this.refund_fee;
	}

	public void setRefund_fee(Double refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getPay_type() {
		return this.pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getRev_people() {
		return this.rev_people;
	}

	public void setRev_people(String rev_people) {
		this.rev_people = rev_people;
	}

	public String getRev_link_phone() {
		return this.rev_link_phone;
	}

	public void setRev_link_phone(String rev_link_phone) {
		this.rev_link_phone = rev_link_phone;
	}

	public String getRev_area() {
		return this.rev_area;
	}

	public void setRev_area(String rev_area) {
		this.rev_area = rev_area;
	}

	public String getRev_addr() {
		return this.rev_addr;
	}

	public void setRev_addr(String rev_addr) {
		this.rev_addr = rev_addr;
	}

	public String getRev_desc() {
		return this.rev_desc;
	}

	public void setRev_desc(String rev_desc) {
		this.rev_desc = rev_desc;
	}

	public String getRev_invoice() {
		return this.rev_invoice;
	}

	public void setRev_invoice(String rev_invoice) {
		this.rev_invoice = rev_invoice;
	}

	public String getRev_invoice_name() {
		return this.rev_invoice_name;
	}

	public void setRev_invoice_name(String rev_invoice_name) {
		this.rev_invoice_name = rev_invoice_name;
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

	public String getOrd_ip() {
		return this.ord_ip;
	}

	public void setOrd_ip(String ord_ip) {
		this.ord_ip = ord_ip;
	}

	public String getDeal_exp_comp() {
		return this.deal_exp_comp;
	}

	public void setDeal_exp_comp(String deal_exp_comp) {
		this.deal_exp_comp = deal_exp_comp;
	}

	public String getDeal_exp_ord() {
		return this.deal_exp_ord;
	}

	public void setDeal_exp_ord(String deal_exp_ord) {
		this.deal_exp_ord = deal_exp_ord;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState_date_start() {
		return state_date_start;
	}

	public void setState_date_start(String state_date_start) {
		this.state_date_start = state_date_start;
	}

	public String getState_date_end() {
		return state_date_end;
	}

	public void setState_date_end(String state_date_end) {
		this.state_date_end = state_date_end;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
}