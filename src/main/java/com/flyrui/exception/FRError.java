package com.flyrui.exception;

import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FRError implements Serializable {
	private static final transient ResourceBundle res = ResourceBundle
			.getBundle("com.flyrui.exception.Resources");

	/** 错误信息资源 */
	private transient static final ResourceBundle messageRes = ResourceBundle
			.getBundle("com.flyrui.exception.MessageResources");

	/** 解决信息资源 */
	private transient static final ResourceBundle resolveRes = ResourceBundle
			.getBundle("com.flyrui.exception.ResolveResources");

	private static final String ERROR = res.getString("error");
	private static final String ERROR_CODE = res.getString("errorCode");
	private static final String ERROR_MESSAGE = res.getString("errorMessage");
	private static final String ERROR_RESOLVE = res.getString("errorResolve");
	private String errorCode;
	private String errorMessage;
	private String errorResolve;

	public FRError(String errorCode) {
		this.errorCode = errorCode;
		initialize(errorCode);
	}

	protected void initialize(String errorCode) {
		setErrorMessage(getMessageRes(errorCode));
		setErrorResolve(getResolveRes(errorCode));
	};

	protected void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	protected void setErrorResolve(String errorResolve) {
		this.errorResolve = errorResolve;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public String getErrorResolve() {
		return this.errorResolve;
	}

	public String toString() {
		return ERROR + "[" + ERROR_CODE + "=" + this.errorCode + ", "
				+ ERROR_MESSAGE + "=" + this.errorMessage + ", "
				+ ERROR_RESOLVE + "=" + this.errorResolve + ']';
	}
	
	public String getMessageRes(String errCode){
		String msgRes = errCode;
		try{
			msgRes = messageRes.getString(errCode);
		}catch(MissingResourceException mre){
			//报资源找不到不处理，默认为errCode
		}
		return msgRes;
	}
	
	public String getResolveRes(String errCode){
		String rslRes = errCode;
		try{
			rslRes = resolveRes.getString(errCode);
		}catch(MissingResourceException mre){
			//报资源找不到不处理，默认为errCode
		}
		return rslRes;
	}
}
