package com.flyrui.framework.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.flyrui.common.ContextHelper;
import com.flyrui.exception.FRException;
import com.flyrui.framework.web.filter.vo.PageLogVO;
/**
 * @author Reason.Yea
 * @version Created Jul 6, 2012
 */
/*
	--insert service
	insert into tfm_services (SERVICE_NAME, MODULE_ID, SERVICE_DESC, CLASS_NAME)
	values ('PAGE_LOG', 'WT', '记录用户访问日志', 'com.ztesoft.ibss.ct.bo.PageLogBO');
	-- Create sequence 
	create sequence s_twb_event	minvalue 1 	maxvalue 999999 start with 1 	increment by 1	cycle;
	
	<filter>
		<filter-name>EventFilter</filter-name>
		<filter-class>com.ztesoft.common.filter.EventFilter</filter-class>
		<init-param>
			<param-name>noEventPage</param-name>
			<param-value>
				404.jsp,500.jsp
			</param-value>
		</init-param>
	</filter>
	
	<filter-mapping>
		<filter-name>EventFilter</filter-name>
		<url-pattern>/tr.gif</url-pattern>
	</filter-mapping>
 */
public class EventFilter implements Filter {
	
	private FilterConfig filterConfig;
	private String[] noFilterPages ;
	//private DisruptorInst disruptorInst = DisruptorInst.getInst();
	private Logger logger = Logger.getLogger(EventFilter.class);
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		if(!checkNoise(request, response)){
			chain.doFilter(request, response);
			return;
		}
		try{
			doEventService(request,response);
		}catch (Exception e) {
			logger.error("记录页面访问日志出错", e);
		}
		chain.doFilter(request, response);
	}

	private void doEventService(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, FRException {
		Map map = new HashMap();
		String ip = ContextHelper.getRequestIp(request) ;
		map.put(PageLogVO.PARAM_VISIT_IP, ip ) ;
		String channel = request.getParameter("channel");
		if("wap".equals(channel)){
			getWapClientData(map,request);
		}else{
			Enumeration paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length >= 1) {
					String paramValue = paramValues[0];
					paramValue = new String(paramValue.getBytes("iso-8859-1"),"UTF-8");
					if (paramValue.length() != 0) {
						map.put(paramName, paramValue);
					}
				}
			}
		}
		//System.out.println("map:::"+map);
		if(!map.containsKey(PageLogVO.PARAM_SESSION_ID)){//页面生成session_id
			map.put(PageLogVO.PARAM_SESSION_ID, request.getSession().getId());
		}
		
		PageLogVO log = new PageLogVO();
		processSession(request,map);
		log.loadFromHashMap(map);
		
		//保存数据库异步处理
		//AsynServiceConfig confgiInfo=new AsynServiceConfig(new BusinessHandler(){
		//	public void execute(Object... objects) {
		//		PageLogVO log = (PageLogVO) objects[0];
		//		try {
					log.save();
		//		} catch (FRException e) {
		//			logger.error("page visit log error:"+e.getMessage());
		//		}
		//	}
		//});
		//confgiInfo.parameters_1=log;
		//disruptorInst.putEvent(confgiInfo);		
	}
	
	private void getWapClientData(Map map, HttpServletRequest request) {
		String strSourceURL = request.getHeader("referer");
		String agent = request.getHeader("User-Agent");
		Cookie [] c=request.getCookies();
        StringTokenizer st = new StringTokenizer(agent, ";");
        String[] agents = agent.split(";") ;
        String browser = "";
        String os = "";
		String cookie_id="";
		String mob_regex = "IPAD,IPHONE,ANDROID,MIDP,OPERA MOBI,OPERA MINI,BLACKBERRY,HP IPAQ,IEMOBILE, MSIEMOBILE,WINDOWS PHONE,SYMBIAN,WINDOWS CE,WINDOWSCE,SMARTPHONE,WEBOS, PALM,UCWEB";
//		String [] browers = {"se360","se","maxthon","qq","tt","theworld","cometbrowser","greenbrowser","ie","chrome","netscape","firefox","opera","safari","konq","uc"};
		String [] browers={"opera","firefox","msie"};
		String mob_flag ="1";
		String win_regex = ".*(Windows).*";
		String [] r = mob_regex.split(",");
		for(int i=0;i<r.length;i++){
			String b = r[i];
			if((agent.toUpperCase()).indexOf(b)>-1) {
				 mob_flag="0";
				 break;
			}
		}
		if(agent.matches(win_regex)) {
			String windows = agent.substring(agent.indexOf("Windows"));
			String [] win_v =  windows.split(" ");
			if(win_v[1].equals("NT")){
				if(win_v[2].indexOf("5.0")>-1){
					os="Windows 2000";
				}else if(win_v[2].indexOf("5.1")>-1){
					os="Windows xp";
				}else if(win_v[2].indexOf("6.0")>-1){
					os="Windows vista";
				}else if(win_v[2].indexOf("6.1")>-1){
					os="Windows 7";
				}else{
					os="Windows nt";
				}
			}else if(win_v[1].equals("9x")){
				os="Windows me";
			}else{
				os="Windows "+win_v[1];
			}
		}
		/**if(os!=null&&!"".equals("")){
			
		for(int i=0;i<browers.length;i++){
			
			if(browers[i].equals("se360")){
				if(agent.matches(".*se360.*")){
					browser=agent.substring(agent.indexOf("se360"),agent.indexOf(" "));
					break;
				}
			}else if(browers[i].equals("se")){
				if(agent.matches(".*se.*")){
					browser=agent.substring(agent.indexOf("se"),agent.indexOf(" "));
					break;
				}
			}else if(browers[i].equals("qq")){
				if(agent.matches(".*qq.*")){
					browser=agent.substring(agent.indexOf("qq"),agent.indexOf(" "));
					break;
				}
			}else if(browers[i].equals("tt")){
				if(agent.matches(".*tt.*")){
					browser=agent.substring(agent.indexOf("tt"),agent.indexOf(" "));
					break;
				}
			}else if(browers[i].equals("safari")){
				if(agent.matches(".*safari.*")){
					browser=agent.substring(agent.indexOf("safari"),agent.indexOf(" "));
					break;
				}
			}else if(browers[i].equals("konq")){
				if(agent.matches(".*konq.*")){
					browser=agent.substring(agent.indexOf("konq"),agent.indexOf(" "));
					break;
				}
				
			}else if(browers[i].equals("netscape")){
				if(agent.matches(".*netscape.*")){
					browser=agent.substring(agent.indexOf("netscape"),agent.indexOf(" "));
					break;
				}
			}else{
				if((agent.toUpperCase()).indexOf(browers[i].toUpperCase())>-1){
					int start = (agent.toUpperCase()).indexOf(browers[i].toUpperCase());
					int end = agent.indexOf(";",start);
					if(agent.indexOf(" ",start)<end)
					{
						end=agent.indexOf(" ",start);
					}
					
					if(end==-1){
						browser=agent.substring(start);
					}else{
						browser=agent.substring(start,end);
					}
					break;
				}
			}
		}*/
			/**修改于2013-3-20*/
				boolean is_ie=agent.indexOf("MSIE")!=-1;
				boolean is_firefox=agent.indexOf("Firefox")!=-1; 
				boolean is_opera=agent.indexOf("Opera")!=-1; 
				boolean is_safari=agent.indexOf("Safari")!=-1; //Safari,360极速版,谷歌 都包含
				boolean is_chrome=agent.indexOf("Chrome")!=-1;
				boolean is_navigator=agent.indexOf("Navigator")!=-1;
				boolean is_maxthon=agent.indexOf("Maxthon")!=-1;//傲游
				boolean qq=agent.indexOf("QQ")!=-1;
				boolean mob=agent.indexOf("Mobile")!=-1;
				
				if(is_ie){//当为ie
					
					
					boolean tt=agent.indexOf("TencentTraveler")!=-1;//TT浏览器
					boolean theworld=agent.indexOf("TheWorld")!=-1;
					
					if(qq){ //QQ浏览器
						if(mob){//手机QQ浏览器
							/*String [] e =agent.split("/");
							for (int t = 0; t < e.length; t++) {
								if(e[t].matches(".*QQBrowser.*")){
									browser=e[0]+e[1];
								}
							}*/
						}else{
							String [] e =agent.split(";");
							for (int t = 0; t < e.length; t++) {
								if(e[t].matches(".*QQBrowser.*")){
									browser=e[t].substring(0,e[t].lastIndexOf(")"));
								}
							}
						}
					}else if(tt){
						String [] e =agent.split(" ");
						for (int t = 0; t < e.length; t++) {
							if(e[t].matches(".*TencentTraveler.*")){
								browser=e[t].substring(0,e[t].lastIndexOf(")"));
							}
						}
					}else if(theworld){
						String [] e =agent.split(" ");
						for (int t = 0; t < e.length; t++) {
							if(e[t].matches(".*TheWorld.*")){
								browser=e[t].substring(0,e[t].lastIndexOf(")"));
							}
						}
					}else{//IE浏览器
						String [] ie =agent.split("; ");
						for (int t = 0; t < ie.length; t++) {
							if(ie[t].matches(".*MSIE.*")){
								browser=ie[t];
							}
						}
					}
				}else if(is_navigator){//为 Navigator浏览器
					String [] e =agent.split(" ");
					for (int t = 0; t < e.length; t++) {
						if(e[t].matches(".*Navigator.*")){
							browser=e[t];
						}
					}
				}else if(is_maxthon){
					//傲游浏览器
					String [] e =agent.split(" ");
					for (int t = 0; t < e.length; t++) {
						if(e[t].matches(".*Maxthon.*")){
							browser=e[t];
						}
					}
				}else if(is_firefox){//为火狐 浏览器
					String [] e =agent.split(" ");
					for (int t = 0; t < e.length; t++) {
						if(e[t].matches(".*Firefox.*")){
							browser=e[t];
						}
					}
				}else if(is_opera){//为Opera 浏览器
					String [] e =agent.split(" ");
					for (int t = 0; t < e.length; t++) {
						if(e[t].matches(".*Opera.*")){
							browser=e[t];
						}
					}
				}else if(is_safari){
					boolean is_version=agent.indexOf("Version")!=-1; 
				    boolean is_baidu=agent.indexOf("baidubrowser")!=-1;
				    boolean is_tiantian=agent.indexOf("tiantian")!=-1;
				    boolean is_uc=agent.indexOf("UCBrowser")!=-1;
				    
					if(is_version){ 
						if(is_baidu){
							//百度浏览器
							String versi="";
							String [] e =agent.split("/");
							for (int t = 0; t < e.length; t++) {
								
								if(e[t].matches(".*Version.*")){
									versi=e[t].split(" ")[0];
								}
								if(e[t].matches(".*baidubrowser.*")){
									browser=e[t].split(" ")[1];
								}
							}
							browser=browser+' '+versi;
						}else if(is_tiantian){
							//天天浏览器
							browser="tiantian";
						}else if(qq){
							//手机QQ浏览器
							String [] e =agent.split("/");
							for (int t = 0; t < e.length; t++) {
								if(e[t].matches(".*QQBrowser.*")){
									browser=e[0]+e[1];
								}
							}
						}else{
							//为Safari 浏览器
							String [] e =agent.split("/");
							if(mob){
								//手机
								for (int t = 0; t < e.length; t++) {
									if(e[t].matches(".*Safari.*")){
										String tt[]=e[t].split(" ");
										browser=tt[2]+" "+tt[0];
									}
								}
							}else{
								//电脑
								for (int t = 0; t < e.length; t++) {
									if(e[t].matches(".*Safari.*")){
										String tt[]=e[t].split(" ");
										browser=tt[1]+" "+tt[0];
									}
								}
							}
						}
					}else if(is_uc){
						//为UC
						String [] e =agent.split(" ");
						for (int t = 0; t < e.length; t++) {
							if(e[t].matches(".*UCBrowser.*")){
								browser=e[t];
							}
						}
					}else{ //为Chrome 
						String [] e =agent.split(" ");
						for (int t = 0; t < e.length; t++) {
							if(e[t].matches(".*Chrome.*")){
								browser=e[t];
							}
						}
					}
					
				}
		
		
		if(browser==null||"".equals(browser)){
			browser=agent.substring(0,agent.indexOf(" ("));
		}
		if(os==null||"".equals(os)){
			if(agent.indexOf("JUC")>-1){
				os="Android "+agents[2];
			}else {
				os=agents[2];
			}
		}
		
		if(c!=null){
			for(int i=0;i<c.length;i++){
				Cookie cookie = c[i];
				if("JSESSIONID".equals(cookie.getName())){
					//cookie_id = cookie.getValue();
				}
				if("WSSNETID".equals(cookie.getName())){
					cookie_id = cookie.getValue();
				}			
			}
		}
		if(cookie_id==null)cookie_id=String.valueOf(System.currentTimeMillis());
		String user_id = "";//"189"+(String.valueOf(System.currentTimeMillis())).substring(0,8);
		String area_code = "";//"020";
		map.put("f", "0");
		map.put("os", os);
		map.put("browser", browser);
		map.put("if_logined", "0");//cookie
		map.put("c_id", cookie_id);//cookie id// 参照前台
		map.put("area_code", area_code);//cookie    >应该是前台传
		map.put("user_id", user_id);// 参照前台   >应该是前台传
		map.put("user_no", user_id);// 参照前台   >应该是前台传
		map.put("user_type", "");// 参照前台    >应该是前台传
		map.put("s_id", request.getRequestedSessionId());//session_id
		map.put("visit_url", strSourceURL);
		map.put("screen", "");//?
		map.put("identify_id", String.valueOf(System.currentTimeMillis()));// 参照前台
		map.put("source_url", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/index.html");// 参照前台//
		map.put("terminal_type", mob_flag);// 参照前台
		
		if(agents != null && agents.length>4){
			String tn = agents[4].trim().toLowerCase() ;
			if(tn.indexOf("build") != -1){
				tn = tn.substring(0, tn.indexOf("build")).trim() ;
			}else{
				tn ="u" ;
			}
			map.put("terminal_name",tn );
		}
//		System.out.println(map);
		
	}
public static void main(String[] args) {
	String agent="MQQBrowser/3.7/Mozilla/5.0 (Linux; U; Android 4.0.4; zh-cn; XT910 Build/6.7.2_GC-145-SPDU-10) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
	boolean is_ie=agent.indexOf("Version")!=-1;
	boolean is_ie2=agent.indexOf("baidubrowser")!=-1;
	String [] e =agent.split("/");
	for (int t = 0; t < e.length; t++) {
		if(e[t].matches(".*QQBrowser.*")){
			System.out.println(e[0]+e[1]);
		}
	}
}
	private void processSession(HttpServletRequest request, Map map) {
		HttpSession session = request.getSession();
		String strSeqNo = session.getAttribute("SEQ_NO") == null ? "1" : (String) session.getAttribute("SEQ_NO");
		if (strSeqNo.equals("")) strSeqNo = "1";
		map.put(PageLogVO.PARAM_SEQU, strSeqNo);
		
		HashMap user = null;
		if(user!=null){
			String vLogin_Name = user.get("LOGIN_NAME") == null ? "": (String) user.get("LOGIN_NAME");
			String vLOGIN_TYPE = user.get("LOGIN_TYPE") == null ? "": (String) user.get("LOGIN_TYPE");
			String vUSER_NO = user.get("USER_NO") == null ? "" : (String) user.get("USER_NO");
			String vLOGIN_PROD_NO = user.get("PRODUCT_ID") == null ? "": (String) user.get("PRODUCT_ID");
			String vLOGIN_AREA_CODE = user.get("AREA_CODE") == null ? "": (String) user.get("AREA_CODE");
			String vOPR_PROD_NO = user.get("PRODUCT_ID") == null ? "": (String) user.get("PRODUCT_ID");
			String vCUSTGROUP = user.get("CUST_GROUP") == null ? "": (String) user.get("CUST_GROUP");
			
			map.put(PageLogVO.PARAM_USER_NO, vUSER_NO);
			map.put(PageLogVO.PARAM_LOGIN_AREA_CODE, vLOGIN_AREA_CODE);
			map.put(PageLogVO.PARAM_LOGIN_PROD_NO, vLOGIN_PROD_NO);
			map.put(PageLogVO.PARAM_LOGIN_TYPE, vLOGIN_TYPE);
			map.put(PageLogVO.PARAM_LOGON_NAME, vLogin_Name);
			map.put(PageLogVO.PARAM_OPR_AREA_CODE, vLOGIN_AREA_CODE);
			map.put(PageLogVO.PARAM_OPR_PROD_NO, vOPR_PROD_NO);
			map.put(PageLogVO.PARAM_OPR_USER_NO, vUSER_NO);
			map.put(PageLogVO.PARAM_CUSTGROUP, vCUSTGROUP);
			
			//客户列表
			ArrayList cust_list = (ArrayList) user.get("CUST_LIST");
			if (cust_list!=null && cust_list.size() > 0 && cust_list.get(0)!=null) {
				
				HashMap custInfo = (HashMap) cust_list.get(0);
				String vCUSTBRAND = custInfo.get("cust_brand") == null ? "": (String) custInfo.get("cust_brand");

				map.put(PageLogVO.PARAM_CUSTBRAND, vCUSTBRAND);
				
			}
		}
		int nextSeqNo = Integer.parseInt(strSeqNo)+1;
		session.setAttribute("SEQ_NO", String.valueOf(nextSeqNo));
	}

	/**
	 * 屏蔽无须记录访问事件的数据，例如
	 * 1.无用界面：404.jsp，500.jsp
	 * @return
	 */
	private boolean checkNoise(HttpServletRequest request, HttpServletResponse response) {
		//逻辑处理
    	String vistUrl = request.getParameter(PageLogVO.PARAM_VISIT_URL) ;
    	if(StringUtils.isEmpty(vistUrl)){
    		vistUrl= request.getRequestURI();
    	}
    	
		for (int i = 0; i < noFilterPages.length; i++) {
			if(vistUrl.indexOf(noFilterPages[i])>-1){
				return false;
			}
		}
		return true;
	}

	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		String pages = this.filterConfig.getInitParameter("noEventPage");
    	if(!pages.equals("")){
    		this.noFilterPages=pages.split(",");
    	}
	}
	
	public void destroy() {
		
	}
}
