<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<jsp:include page="/admin/main/head_new.jsp"></jsp:include>
<link href="/public/ligerUI/skins/Gray/css/grid.css" rel="stylesheet" type="text/css"/>
<div id="mainLayout" style="width:99.2%; margin:0 auto; margin-top:4px; "> 	 
      <div position="center" id="rightLayOut" style="padding-top:5px;padding-left:5px"> 
          <div >
            <table>
            	<tr>
            		<td>配置类型：</td>
            		<td>
            			<select name="cf_module">
            				<option value="-1">全部</option>
            				<option value="IPBLACK">IP黑名单配置</option>
            				<option value="WEBVISIT">访问记录数配置</option>
            				<option value="ACCESSLIMIT">防爆力配置</option>
            			</select>
            		</td>
            		<td>配置ID：</td>
            		<td>
            			<input type="text" name="cf_id" />
            		</td>            		
            		<td>配置描述：</td>
            		<td>
            			<input type="text" name="cf_desc" />
            		</td>
            		<td>
            			<input type="button" id="queryBtn" />
            		</td>
            	</tr>
            </table>
          </div>
          <div id="configList" >              
          </div> 
      </div> 
</div>
<script type="text/javascript" src="/admin/config/js/config.js"></script>
<jsp:include page="/admin/main/foot.jsp"></jsp:include>