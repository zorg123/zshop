package com.flyrui.infoshare.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.flyrui.common.CommonUtils;
import com.flyrui.common.action.BaseAction;
import com.flyrui.common.utls.Const;
import com.flyrui.common.uuid.UUIDHexGenerator;
import com.flyrui.exception.ErrorConstants;
import com.flyrui.exception.FRError;
import com.flyrui.exception.FRException;
import com.flyrui.infoshare.common.pojo.InfoFile;
import com.flyrui.infoshare.common.service.InfoFileService;

@ParentPackage("frcms_default")
@Namespace("/Attachement") //访问路径的包名
@Results({
		@Result(name="file",type="stream", params={"contentDisposition","attachment;filename=\"${excelName}\"","inputName","inputStream","bufferSize","4096"}),
		@Result(type="json", params={"root","result"})}) 
public class AttachementAction extends BaseAction {
	
	private static final long serialVersionUID = 3062866820835980617L;
	
	private static Logger log = Logger.getLogger(AttachementAction.class);
	private File uploadFile;
	private String fileName;
	private String image;
	private String contentType;
	
	@Autowired
	private InfoFileService infoFileService;
	
	public String fid;
	
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
    
    public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private String getPath(){
    	HttpServletRequest request = super.getHttpReqeust();
		String basePath = request.getRealPath("/");
    	return basePath+File.separator+Const.DEFAULT_UPLOAD_FILE_HOME_DIR;
    }
	private String getRelativePath(){    
		HttpServletRequest request = super.getHttpReqeust();
		String context = request.getContextPath();
		if(!context.endsWith("/")){
			context = request.getContextPath()+"/";
		}
    	return context+Const.DEFAULT_UPLOAD_FILE_HOME_DIR;
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
    @Action("upload")
	public String upload()throws FRException{
		Map retMap = new HashMap();			
		String path=getPath();
				
		if(fileName==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		
		String newFileName="";
		String limitExt="jpg,jpeg,png,gif,bmp,doc,xls,docx,xlsx,ppt,pptx,pdf";
		int limitSize=5*1024*1024;
		
		String[] supportExt=limitExt.split(",");//获取serv_no支持的文件扩展名
		boolean ifSupport=false;		
		String fileType = fileName.substring(fileName.indexOf(".")+1);
		for (int j = 0; j < supportExt.length; j++) {
			if(fileType.endsWith(supportExt[j])){
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		String curDate= sdf.format(new Date());
				
		File pathFile = new File(path+File.separator+curDate);
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		String id = UUIDHexGenerator.generator();
		String fkey = File.separator+curDate+File.separator+id+"."+fileType;
		newFileName =path+File.separator+fkey;
		
		File newFile = new File(newFileName);
		CommonUtils.saveFile(uploadFile,newFile);				
		//将文件信息保存到数据库，返回前台一个id
		InfoFile infoFile = new InfoFile();
		
		infoFile.setFile_id(id);
		infoFile.setFile_size(Integer.parseInt(len+""));
		infoFile.setFile_name(fileName);
		infoFile.setFile_key(fkey);
		infoFile.setFile_type(fileType);
		infoFile.setCreate_date(new Date());
		infoFileService.insert(infoFile);
		retMap.put("id", id);
		retMap.put("fileName", fileName);
		retMap.put("fileUrl", File.separator+Const.DEFAULT_UPLOAD_FILE_HOME_DIR+fkey);
		retMap.put("code", "0");
		setResult(retMap);
    	return SUCCESS;
    } 
	
	/**
	 * 
	 * 文件下载
	 * 
	 * @return
	 * @throws FRException [返回类型说明]
	 * 
	 * rover.lee
	 * Oct 30, 2014
	 */
    
    @Action("download")
	public String download()throws FRException{
		if(fid==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}			
		InfoFile infoFile = new InfoFile();
		infoFile.setFile_id(fid);
		List<InfoFile> infoFileList = infoFileService.getListByCon(infoFile);
		if(infoFileList == null || infoFileList.size()==0){
			throw new FRException(new FRError(ErrorConstants.FILE_NOT_FOUND));
		}
		infoFile = infoFileList.get(0);
		String path = getPath();
		path = path+infoFile.getFile_key();
		File f = new File(path);
		if(!f.exists()){
			throw new FRException(new FRError(ErrorConstants.FILE_NOT_FOUND));
		}
				
        setExcelName(infoFile.getFile_name());
        try{        	
        	inputStream =new FileInputStream(f);
        }catch(Exception ex){
        	log.error("获取文件失败："+ex);
        	throw new FRException(new FRError(ErrorConstants.FILE_NOT_FOUND));
        }
        return "file";
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
    @Action("uploadHead")
	public String uploadHead()throws FRException{
		Map retMap = new HashMap();			
		String path=getPath();
				
		if(image==null){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		int sIndex = image.indexOf("data:image/");
		if(sIndex<0){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		int eIndex = image.indexOf(";");
		if(eIndex<0){
			throw new FRException(new FRError(ErrorConstants.PARAM_ERROR));
		}
		String fileType = image.substring(sIndex+11,eIndex);
		if(fileType==null || "".equals(fileType)){
			fileType = "jpg";
		}
		if("jpeg".equalsIgnoreCase(fileType)){//data:image/jpeg;base64,base64编码的jpeg图片数据  
			fileType = "jpg";  
        } else if("x-icon".equalsIgnoreCase(fileType)){//data:image/x-icon;base64,base64编码的icon图片数据  
        	fileType = "ico";  
        }  
		String content = image.substring(image.indexOf("base64,")+7);
		String newFileName="";
		String limitExt="jpg,jpeg,png,gif,bmp,doc,xls,docx,xlsx,ppt,pptx,pdf";
		int limitSize=5*1024*1024;
		
		String[] supportExt=limitExt.split(",");//获取serv_no支持的文件扩展名
		boolean ifSupport=false;		
		 
		for (int j = 0; j < supportExt.length; j++) {
			if(fileType.endsWith(supportExt[j])){
				ifSupport=true;
				break;
			}
		}
		long len = content.length();
		if(!ifSupport){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}
		
		if(len>limitSize){
			throw new FRException(new FRError(ErrorConstants.UPLOAD_FILE_TYPE_NOT_SUPPORT));
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		String curDate= sdf.format(new Date());
				
		File pathFile = new File(path+File.separator+curDate);
		if(!pathFile.exists()){
			pathFile.mkdirs();
		}
		String id = UUIDHexGenerator.generator();
		String fkey = File.separator+curDate+File.separator+id+"."+fileType;
		newFileName =path+File.separator+fkey;
		String fileNameContext =getRelativePath()+"/"+curDate+"/"+id+"."+fileType;
		
		File newFile = new File(newFileName);
		CommonUtils.saveFile(content,newFile);				
		//将文件信息保存到数据库，返回前台一个id
		InfoFile infoFile = new InfoFile();
		
		infoFile.setFile_id(id);
		infoFile.setFile_size(Integer.parseInt(len+""));
		infoFile.setFile_name(fileName);
		infoFile.setFile_key(fkey);
		infoFile.setFile_type("jpg");
		infoFile.setCreate_date(new Date());
		infoFileService.insert(infoFile);
		retMap.put("id", id);
		retMap.put("fileName",fileNameContext);
		retMap.put("code", "0");
		setResult(retMap);
    	return SUCCESS;
    } 
}
