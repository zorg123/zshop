package com.flyrui.exception;

public class ErrorConstants {
	// 一般异常
	public static final String COMMON_ERROR = "COMMON_ERR000";	
	// 系统出错
	public static final String COMMON_SYSTEM_ERROR = "COMMON_ERR999";
	
	// 系统出错
	public static final String COMMON_NOT_SUPPORT = "COMMON_ERR001";
	
	public static final String RETURN_SUCCESS = "0000";	
	
	public static final String RETURN_FAIL = "-9999";
	
	public static final String SYS_ROLE_NOT_FOUND = "SYS_ERR001";
	
	public static final String SYS_USER_NO_LOGIN = "SYS_ERR002";
	
	/** 验证码输入不正确 **/
	public static final String SYS_VALID_CODE_ERROR = "VALID_CODE_ERROR";
	
	/** 未传递数据**/
	public static final String SYS_PARAMETER_NOT_SEND = "SYS_ERR003";
	
	/** 没有删除到数据 **/
 	public static final String SYS_NO_DELETE_DATA = "SYS_ERR004";
 	
 	/** 没有更新到数据 **/
 	public static final String SYS_NO_UPDATE_DATA = "SYS_ERR005";
 	
 	/** 用户已存在 **/
 	public static final String SYS_USER_EXISTS = "SYS_ERR006";
 	
 	/** 银行账号已存在 **/
 	public static final String SYS_BANK_ACCOUNT_EXISTS = "SYS_ERR007";
 	
 	/** 问卷调查一个IP只能提交一次  **/
 	public static final String BALLOT_IP_SBMIT_REPEAT = "SYS_ERR008";
 	
 	/** 参数错误  **/
 	public static final String PARAM_ERROR = "COMMON_ERR008";
 	
 	/** 没有找到数据  **/
 	public static final String NO_DATA_FOUND = "COMMON_ERR009";
 	
 	/** 文件没有找到  **/
 	public static final String FILE_NOT_FOUND = "FILE_NOT_FOUND";
	
 	/** 上传的文件类型不正确  **/
 	public static final String UPLOAD_FILE_TYPE_NOT_SUPPORT = "UPLOAD_FILE_TYPE_NOT_SUPPORT";
 	
 	/** 用户不存在 **/
 	public static final String SYS_USER_NOT_EXISTS = "SYS_ERR010";
 	
 	/** 市场无此账号 */
 	public static final String MARKET_NO_USER = "USER_010";
 	
 	/** 非激活用户只能购买一个会员商品  */
 	public static final String SHOP_UNACTIVE_USER_1 = "USER_011";
 	
 	/** 要修改的订单不存在!**/
 	public static final String GOODS_004 = "GOODS_004";
 	
 	/**要订购的商品不存在! **/
 	public static final String GOODS_005 = "GOODS_005";
 	
 	/**
 	 * 请到资料管理--账户资料中补充信息后提现!
 	 */
 	public static final String USER_013 = "USER_013";
}
