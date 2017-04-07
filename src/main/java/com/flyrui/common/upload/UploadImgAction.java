package com.flyrui.common.upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.utls.Const;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.framework.annotation.SessionCheckAnnotation;

public class UploadImgAction extends BaseAction {
	
	private static final long serialVersionUID = 3062866820835980617L;
	
	private static Logger log = Logger.getLogger(UploadImgAction.class);
	private File uploadFile;
	private String fileName;
	private String contentType;
	
	public String fetch;
	
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String getUploadFileFileName() {
        return fileName;
    }
    public void setUploadFileFileName(String fileName) {
        this.fileName = fileName;
    }
	
    public String getUploadFileContentType() {
        return contentType;
    }
    public void setUploadFileContentType(String contentType) {
        this.contentType = contentType;
    }
    
	/**
	 * 
	 * 文件上传，默认路径为res
	 * 
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Oct 30, 2014
	 */
	public String upload()throws FRException{
		Map retMap = new HashMap();		
		HttpServletRequest request = super.getHttpReqeust();
		String basePath = request.getRealPath("/");
		String path=File.separator+Const.DEFAULT_UPLOAD_FILE_HOME_DIR+File.separator+Const.DEFAULT_UPLOAD_FILE_PICTURE_DIR;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		String curDate= sdf.format(new Date());
		if(fileName==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}		
		String newFileName="";
		String limitExt="jpg,jpeg,png,gif,bmp";
		int limitSize=3*1024*1024;
		
		String[] supportExt=limitExt.split(",");//获取serv_no支持的文件扩展名
		boolean ifSupport=false;		
		for (int j = 0; j < supportExt.length; j++) {
			if(fileName.toLowerCase().endsWith(supportExt[j])){
				ifSupport=true;
				break;
			}
		}
		long len = uploadFile.length();
		if(!ifSupport){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}
		
		if(len>limitSize){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}
		
		path = path+File.separator+curDate;
		File pathFile = new File(basePath+path);
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		newFileName =path+File.separator+fileName;			
		File newFile = new File(basePath+newFileName);
		CommonUtils.saveFile(uploadFile,newFile);				
		
		retMap.put("filePath", newFileName.replaceAll("\\\\", "/"));
		retMap.put("code", "0");
		setResult(retMap);
    	return SUCCESS;
    } 
	
	/**
	 * 
	 * 文件上传，默认路径为res
	 * 
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Oct 30, 2014
	 */
	public Map uploadUE(String fileType)throws FRException{
		Map retMap = new HashMap();		
		HttpServletRequest request = super.getHttpReqeust();
		String basePath = request.getRealPath("/");
		String path=File.separator+Const.DEFAULT_UPLOAD_FILE_HOME_DIR;
		if(fileType==null || "".equals(fileType)){
			fileType="IMG";
		}
		String subPath="";
		String limitExt=".jpg,.jpeg,.png,.gif,.bmp";
		int limitSize=3*1024*1024;
		String fileExt="";
		if("IMG".equals(fileType)){
			subPath = File.separator+Const.DEFAULT_UPLOAD_FILE_PICTURE_DIR;
		}else if("ATTACHE".equals(fileType)){
			subPath = File.separator+Const.DEFAULT_UPLOAD_FILE_ATTACHE_DIR;
			limitSize=5*1024*1024;
			limitExt=".rar,.xls,.doc,.docx,.zip,.pdf,.txt,.swf,.wmv,.avi,.rm,.rmvb,.mpeg,.mpg,.ogg,.mov,.wmv,.mp4";
		}if("MOIVE".equals(fileType)){
			subPath = File.separator+Const.DEFAULT_UPLOAD_FILE_MOVIE_DIR;
			limitExt=".mp4,.mp3,.avi,.mpeg,.rm";
			limitSize=10*1024*1024;
		}
		path += subPath;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		String curDate= sdf.format(new Date());
		if(fileName==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}		
		String newFileName="";		
		
		String[] supportExt=limitExt.split(",");//获取serv_no支持的文件扩展名
		boolean ifSupport=false;		
		for (int j = 0; j < supportExt.length; j++) {
			if(fileName.toLowerCase().endsWith(supportExt[j])){
				ifSupport=true;
				fileExt=supportExt[j];
				break;
			}
		}
		long len = uploadFile.length();
		if(!ifSupport){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}		
		if(len>limitSize){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}
		
		path = path+File.separator+curDate;
		File pathFile = new File(basePath+path);
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		newFileName =path+File.separator+fileName;			
		File newFile = new File(basePath+newFileName);
		CommonUtils.saveFile(uploadFile,newFile);				
		
		retMap.put("filePath", newFileName.replaceAll("\\\\", "/"));
		retMap.put("fileType", fileExt);
		retMap.put("code", "0");
    	return retMap;
    }
	
	/**
	 * 
	 * 文件上传，默认路径为res
	 * 
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Oct 30, 2014
	 */
	public String uploadUEIMG() throws Exception{
		String responseStr="";
		if(fetch==null){
			try{
				Map retMap = uploadUE("IMG");
				responseStr="{'original':'"+CommonUtils.Encode((String)retMap.get("filePath"))+"','url':'"+CommonUtils.Encode((String)retMap.get("filePath"))+"','title':'','state':'SUCCESS'}";
			}catch(FRException fre){
				responseStr="{'state':'"+CommonUtils.Encode((String)fre.getError().getErrorMessage())+"'}";
			}
		}else{
			getHttpResponse().setHeader( "Content-Type", "text/javascript" );
			String dirs = "['"+Const.DEFAULT_UPLOAD_FILE_HOME_DIR+"']";
			responseStr="updateSavePath("+dirs+");";
		}	
		getHttpResponse().getWriter().print(responseStr);
		return null;
    }
	
	@SessionCheckAnnotation(needCheckSession="false")
	public String uploadUEFile() throws Exception{
		String responseStr="";
		try{
			Map retMap = uploadUE("ATTACHE");
			responseStr="{'original':'"+CommonUtils.Encode(fileName)+"','url':'"+CommonUtils.Encode((String)retMap.get("filePath"))+"','fileType':'"+retMap.get("fileType")+"','title':'','state':'SUCCESS'}";
		}catch(FRException fre){
			responseStr="{'state':'"+CommonUtils.Encode((String)fre.getError().getErrorMessage())+"'}";
		}
		getHttpResponse().getWriter().print(responseStr);
		return null;
	}
	
	public String uploadImgMng() throws Exception{
		String responseStr="";
		if(fetch==null){
			try{
				Map retMap = uploadUE("ATTACHE");
				responseStr="{'original':'"+retMap.get("filePath")+"','url':'"+retMap.get("filePath")+"''fileType':'"+retMap.get("fileType")+"','title':'','state':'SUCCESS'}";
			}catch(FRException fre){
				responseStr="{'state':'"+fre.getError().getErrorMessage()+"'}";
			}
		}else{
			getHttpResponse().setHeader( "Content-Type", "text/javascript" );
			String dirs = "['"+Const.DEFAULT_UPLOAD_FILE_HOME_DIR+"']";
			responseStr="updateSavePath("+dirs+");";
		}	
		getHttpResponse().getWriter().print(responseStr);
		return null;
    }
	
}
