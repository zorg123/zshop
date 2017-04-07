/**
 * 业务受理核心模块
 */
(function(scope) {
	var AcpSplite = Base.extend({
		constructor : function(config) {
			this.version = "1.0";
			this.config ={};
			this.config.div_id ='';
		},
		init:function(div_id){
			this.config.div_id = div_id; 
			this.config.serv_no =serv_no;
		},
		//添加标题
		addServTitle:function(div_id,lx,p_title,p_title_id){
			var title;
			var title_id = p_title_id || 'accept_title_id';
			if(p_title)
				title =p_title;
			else
				title =  "您选择办理的是<span class='f_red'>“"+pageWizard.serv_info.SERV_NAME+"”</span>。";
			var action_type = acpBeanFactory.getRequestParameter("action_type");
			
			if(!p_title){
				if("A" == action_type)
					title="您选择办理的是【订购】"+"<span class='f_red'>“"+pageWizard.serv_info.SERV_NAME+"”</span>。";
				if("D" == action_type)
					title="您选择办理的是【退订】"+"<span class='f_red'>“"+pageWizard.serv_info.SERV_NAME+"”</span>。";
			}
			var titlesArr ="<div class='OrderTitle' id='"+title_id+"'><span class='f_red'>尊敬的客户</span>，"+title+"</div>";
			var titleJq =$(titlesArr);
			if(lx =="prev")
				titleJq.insertBefore($("#"+div_id));
			else
				this.getDivPanel().append(titleJq);
		},
		addPageTitle:function(title,div_id,lx,title_id,parent_id){
			var p_title_id =title_id || 'title';
			var titlesArr ="<div class='OrderTitle' id="+p_title_id+"><span class='f_red'>尊敬的客户</span><br>您好,"+title+"</div>";
			var titleJq =$(titlesArr);
			if(parent_id)
			{
				$("#"+parent_id).append(titleJq);
			}else{
				if(lx =="prev")
					titleJq.insertBefore($("#"+div_id));
				else
					this.getDivPanel().append(titleJq);
			}
		},
		addTableTitle:function(title,div_id,lx,title_id,parent_id){
			var p_title_id =title_id || 'title';
			var titlesArr ="<div class='ser_tit2' id='"+p_title_id+"'><h3>"+title+"</h3><span></span></div>";
			var titleJq =$(titlesArr);
			if(parent_id)
			{
				$("#"+parent_id).append(titleJq);
			}else{
				if(lx =="prev")
					titleJq.insertBefore($("#"+div_id));
				else
					this.getDivPanel().append(titleJq);
			}
		},
		removeTableTitle:function(title_id){
			$("#"+title_id).remove();
		},
		addTable:function(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show){
			var pageTable = new PageTable(this.config);
			pageTable.createTable(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show);
			var obj ={};
			obj.id = pageTable.id;
			obj['pageTable']= pageTable;
			acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).addPageTables(obj);
			return pageTable;
		},
		addHeaderTable:function(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show,headTitle){
			var pageTable = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).getPageTableById(table_id);
			var exist = false;
			if(!pageTable)
			   pageTable = new PageTable(this.config);
			else
			   exist = true;
			pageTable.createHeaderTable(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show);
			var obj ={};
			obj.id = pageTable.id;
			obj['pageTable']= pageTable;
			!exist && acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).addPageTables(obj);
			return pageTable;
		},
		addV5HeaderTable:function(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show,headTitle,style){
		
			var pageTable = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).getPageTableById(table_id);
			var exist = false;
			if(!pageTable)
			   pageTable = new PageTable(this.config);
			else
			   exist = true;
			
			pageTable.createV5HeaderTable(title,table_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show,'','',style);
			var obj ={};
			obj.id = pageTable.id;
			obj['pageTable']= pageTable;
			!exist && acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).addPageTables(obj);
			return pageTable;
		},
		removePageTable:function(table_id){
			var pageTable = this.getPageTable(table_id);
			if(pageTable){
				$("#"+pageTable.table_id+"_title_div").remove();
				$("#"+pageTable.getTableId()).parent().remove();
				acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).removePageTables(table_id);
			}
		},
		addPageSelect:function(title,select_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show,show_title){
			var pageSelect = new PageSelect(this.config);
			pageSelect.createSelect(title,select_id,fields,func_id,is_sql,chooseMethod,parent_id,is_show,show_title);
			var obj ={};
			obj.id = pageSelect.id;
			obj['pageSelect']= pageSelect;
			acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).addPageSelects(obj);
			return pageSelect;
		},
		showCardText:function(form_id){ //获取卡片信息
			var me =this;
			 $("#"+me.getTableViewId(form_id)).remove();
			this.getTabCard(form_id).each(function(){
				var id =$(this).attr("id");
				var obj =getInputDomainAndLabel(id);
				var tableTextHtml = [];
			    tableTextHtml.push('<div class="Form_Body">');
			    tableTextHtml.push('<table width="100%" border="0" cellspacing="0" cellpadding="0" id='+me.getTableViewId(form_id)+'>');
				for(p in obj){
					if(p.indexOf("cname")>-1)
					{
						var cname_key =p;
						 var cname =obj[p];
						 var value_key =cname_key.substring(0,cname_key.indexOf("_cname"));
						 if(value_key && value_key !="logon_valid"){
							 tableTextHtml.push('<tr>');
							 var value = obj[value_key];
							 var value_desc = obj[value_key+"_desc"];
							 value_desc=value_desc?value_desc:value;
							 if(value_desc  && value_desc.indexOf(",")>-1 && value_desc.length==1)
							 	continue;
							 me._addViewTd(tableTextHtml,cname,value_desc);
	                         tableTextHtml.push('</tr>');
						 }
					}
				}
				tableTextHtml.push('</table>');
			    tableTextHtml.push('</div>');
			    var html =tableTextHtml.join("");
			    me.getDivPanel().append(html);
			})
			
			
		},
		_addViewTd:function(tableTextHtml,cname,value_desc){
			 tableTextHtml.push(' <td width="17%" class="tdt l">'+cname+'</td>');
             tableTextHtml.push(' <td width="83%" class="tdt l">'+value_desc+'</td>');
             
		},
		//添加表单
		addTabCard:function(form_id,hide_card,title,addVertify){
			var pageForm = new PageForm(this.config);
			pageForm.form_id = form_id;
			pageForm.hide_card = hide_card;
			pageForm.p_title = title;
			pageForm.addVertify = addVertify;
			pageForm.getTwbCardDEF();
			var obj ={};
			obj.id = pageForm.id;
			obj['pageForm'] = pageForm;
			acpBeanFactory.getAcpBeanByServNo(this.config.serv_no).addPageForms(obj);
		},
		addTabCardCopy:function(form_id,parent_id){
			var p_config ={};
			CommonUtils.apply(p_config,this.config);
			var p_form_id =form_id+"_only_view";
			p_config.serv_no_only_view =p_config.serv_no+"_only_view";
			p_config.parent_id =parent_id;
			var pageForm = new PageForm(p_config);
			pageForm.form_id = p_form_id;
			pageForm.getTwbCardDEF();
			var obj ={};
			obj.id = pageForm.id;
			obj['pageForm'] = pageForm;
			acpBeanFactory.getAcpBeanByServNo(p_config.serv_no).addPageForms(obj);
		},
		getTabCard:function(form_id){
			return $("body").find("[id='"+this.config.serv_no+"_form_"+form_id+"']");
		},
		getTableViewId:function(form_id){ //获取显示的tabId
			this.id = this.config.serv_no+"_view_"+form_id;
			return this.id;
		},
		emptyTableView:function(form_id){
			var table_id = this.getTableViewId(form_id);
			var tablejQ = $("#"+table_id);
			if(tablejQ.length>0)
			{	
				tablejQ.parent().remove();
			}
		},
		addTableViewRecord:function(form_id,cname,value_desc,parent_id){
			var tdTextHtml = [];
			var table_id = this.getTableViewId(form_id);
			var tablejQ = $("#"+table_id);
			if(tablejQ.length ==0)
			{
				 tdTextHtml.push('<div class="Form_Body">');
			     tdTextHtml.push('<table width="100%" border="0" cellspacing="0" cellpadding="0" id='+table_id+'>');
			     tdTextHtml.push('<tr>');
			     this._addViewTd(tdTextHtml,cname,value_desc);	
			     tdTextHtml.push('</tr>');
			     tdTextHtml.push('</table>');
			     tdTextHtml.push('</div>');
			     if(parent_id)
			     	$("#"+parent_id).append(tdTextHtml.join(""));
			     else
			     	this.getDivPanel().append(tdTextHtml.join(""));
			}else
			{	
				this._addViewTd(tdTextHtml,cname,value_desc);
				tablejQ.append("<tr>"+tdTextHtml.join("")+"</tr>");
			}
		
		},
		addTableViewVerRecord:function(form_id,cname,value_desc,parent_id,title){
			var tdTextHtml = [];
			var table_id = this.getTableViewId(form_id);
			var tablejQ = $("#"+table_id);
			if(tablejQ.length ==0)
			{
				 tdTextHtml.push('<div class="mt10">');
				 tdTextHtml.push('<div class="sale_menu920">');
           		 tdTextHtml.push('<h5><span>'+title+':</span></h5>');
         		 tdTextHtml.push('</div>');
				 tdTextHtml.push('<div class="sale_box920" >');
			     tdTextHtml.push('<table width="100%" class="grayth" border="0" cellspacing="0" cellpadding="0" id='+table_id+'>');
			     tdTextHtml.push('<tr>');
			     this._addViewTd(tdTextHtml,cname,value_desc);	
			     tdTextHtml.push('</tr>');
			     tdTextHtml.push('</table>');
			     tdTextHtml.push('</div>');
			     tdTextHtml.push('</div>');
			     if(parent_id)
			     	$("#"+parent_id).append(tdTextHtml.join(""));
			     else
			     	this.getDivPanel().append(tdTextHtml.join(""));
			}else
			{	
				this._addViewTd(tdTextHtml,cname,value_desc);
				tablejQ.append("<tr>"+tdTextHtml.join("")+"</tr>");
			}
		},
		addTableViewHorRecord:function(form_id,cnames,values,title,parent_id){
			var tdTextHtml = [];
			var table_id = this.getTableViewId(form_id);
			var tablejQ = $("#"+table_id);
			if(tablejQ.length ==0)
			{	
				 tdTextHtml.push('<div class="mt10">');
				 tdTextHtml.push('<div class="sale_menu920">');
           		 tdTextHtml.push('<h5><span>'+title+':</span></h5>');
         		 tdTextHtml.push('</div>');
				 tdTextHtml.push('<div class="sale_box920" >');
			     tdTextHtml.push('<table width="100%" class="grayth" border="0" cellspacing="0" cellpadding="0" id='+table_id+'>');
			     tdTextHtml.push('<tbody>');
                 tdTextHtml.push('<tr>');
                 for(var i=0;i<cnames.length;i++){
                 	 tdTextHtml.push('<th>'+cnames[i]+'</th>');
                 }
                 tdTextHtml.push('</tr>');
			     tdTextHtml.push('<tr>');
			      for(var i=0;i<values.length;i++){
                 	 tdTextHtml.push('<td>'+values[i]+'</td>');
                 }
			     tdTextHtml.push('</tr>');
			     tdTextHtml.push('</tbody>');
			     tdTextHtml.push('</table>');
			     tdTextHtml.push('</div>');
			     tdTextHtml.push('</div>');
			     if(parent_id)
			     	$("#"+parent_id).append(tdTextHtml.join(""));
			     else
			     	this.getDivPanel().append(tdTextHtml.join(""));
			}
		},
		
		getDivPanel:function(){
			if(!this.config.div_id){
				panel = $("body");
				return panel;
			}
			var panel = $("#"+this.config.div_id);
			if(!panel || panel.length ==0){
				panel = $("body");
			}
			return panel;
		},
		getFormValue:function(field_name){ //获取卡片的值
			var elejQ=$("#"+this.config.serv_no+"_"+field_name);
			return elejQ.val();
		},
		getPageTable:function(table_id){
			var acpBean = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no);
			var pageTable = acpBean.getPageTableById(table_id);
			return pageTable;
		},
		getPageForm:function(){
			var acpBean = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no);
			var pageForm = acpBean.getPageForm();
			return pageForm;
		},
		getPageFormById:function(form_id){
			var acpBean = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no);
			var pageForm = acpBean.getPageFormById(form_id);
			return pageForm;
		},
		getPageSelect:function(select_id){
			var acpBean = acpBeanFactory.getAcpBeanByServNo(this.config.serv_no);
			var pageTable = acpBean.getPageSelectById(select_id);
			return pageTable;
		},
		showMsg:function(msg,level,tip_id){
			if(!tip_id)
				tip_id=this.config.div_id+'_show_img_id';
			tip_id && $("#"+tip_id).remove();
			var htmlArr = [];
			htmlArr.push("<div class='FromeBody'  id="+tip_id+">");
			htmlArr.push("	<div class='accepBox2 pd10'>");
			htmlArr.push(" 	<div class='accepImg2 fl''></div>");
			htmlArr.push("     <div class='accepTxt fl'>");
			htmlArr.push("      	<div class='pd10'>");
			htmlArr.push("        	<div class='accepOn'>");
			htmlArr.push(msg);
			htmlArr.push("             </div>");
			htmlArr.push("        </div>");
			htmlArr.push("     </div>");
			htmlArr.push("     <div class='clear'></div>");
			htmlArr.push("   </div>");
			htmlArr.push("</div>");
			this.getDivPanel().append($(htmlArr.join((""))));
		},
		showSuccTip:function(msg,level,tip_id){
			tip_id && $("#"+tip_id).remove();
			var htmlArr = [];
			htmlArr.push("<div class='FromeBody'  id="+tip_id+">");
			htmlArr.push("	<div class='accepBox2 pd10'>");
			htmlArr.push(" 	<div class='accepImg2 fl''></div>");
			htmlArr.push("     <div class='accepTxt fl'>");
			htmlArr.push("      	<div class='pd10'>");
			htmlArr.push("        	<div class='accepOn'>");
			htmlArr.push(msg);
			htmlArr.push("             </div>");
			htmlArr.push("        </div>");
			htmlArr.push("     </div>");
			htmlArr.push("     <div class='clear'></div>");
			htmlArr.push("   </div>");
			htmlArr.push("</div>");
			this.getDivPanel().append($(htmlArr.join((""))));
		},
		emptyMsg:function(tip_id){
			$("#"+tip_id).remove();
		},
		showSucc:function(tip_id,datas){ // 处理成功
			var htmlArr = [];
			tip_id && $("#"+tip_id).remove();
			htmlArr.push("<div class='FromeBody w720' id="+tip_id+">");
			htmlArr.push("<div class='accepBox2 pd10'>");//<!-- 组合样式，外层 宽度 边距 -->
	    	htmlArr.push("<div class='accepImg1 fl'></div>");
	        htmlArr.push(" <div class='accepTxt fl'>");
	        htmlArr.push("	<div class='pd10''>");
	        htmlArr.push("  	<div class='ser_tit'>处理成功</div>");
	        htmlArr.push("   <div class='ser_table'>");
	        htmlArr.push("  <table width='100%' border='0' cellspacing='0' cellpadding='0' class='FromTable01'>");
	        for(var i=0;i<datas.length;i++)
	        {
	        	var data= datas[i];
	        	var cname =data['cname'];
	        	var value = data['value'];
	        	htmlArr.push("<tr>");
		        htmlArr.push("<td width='30%' class='tdcs1'>"+cname+"</td>");
		        htmlArr.push("<td width='70%' class='tdcs1'>"+value+"</td>");
		        htmlArr.push("</tr>");
	        }
	        htmlArr.push("  </table>");
	        htmlArr.push("  </div>");
	        htmlArr.push(" </div>");
	        htmlArr.push(" </div>");
	        htmlArr.push("<div class='clear'></div>");
			htmlArr.push("</div>");
			htmlArr.push("</div>");
			this.getDivPanel().append(htmlArr.join(""))
		},
		addPayDiv:function(){
			var payHtml = [];
			payHtml.push('<table width="100%" height="150px" border="0" cellspacing="0" cellpadding="0" name="pay_ment_table">');
			payHtml.push('  <tr>' );
			payHtml.push('    <td width="10%" class="greenTT">' );
			payHtml.push('   <span style="display:block;">支</span>' );
			payHtml.push('    <span style="display:block;">付</span>' );
			payHtml.push('   <span style="display:block;">渠</span>' );
			payHtml.push('    <span style="display:block;">道</span>' );
			payHtml.push('    <td width="90%" class="greentTB"></td>' );
		    payHtml.push('  </tr>' );
			payHtml.push('</table>' );
			this.getDivPanel().append(payHtml.join(""))
		}
	})
	
	window.acpSplite = new AcpSplite();
	
}(window));