<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/public/infoShare/head.jsp"></jsp:include>
<jsp:include page="/public/infoShare/website-head.jsp"></jsp:include>
<div class="easyui-layout" style="height:500px;width:90%;margin:0 auto">
<div region="center" class="easyui-layout" style="border:0">
    <div region="north" style="height:80px;border:0;padding-top:5px;" id="search">
    	<div region="center" style="margin-top: 5px;margin-left: 5px;">
    	<fieldset>
	    <legend>员工工资查询</legend> 	        
	            <div style="display:none">
	            <label>工资类型：</label>
	            <select class="easyui-combobox" name="s_salary_type" style="width:80px;">
	                <option value="-1">--请选择--</option>
	                <option value="月工资">月工资</option>
	                <option value="年终奖">年终奖</option>               
	            </select>
	            </div>
	            <label>发放开始时间：</label><input type="text" name="s_salary_schedule_start" class="easyui-datebox" />
	            <label>发放结束时间：</label><input type="text" name="s_salary_schedule_end" class="easyui-datebox" />
	            <!--  
	            <label>员工工号：</label><input type="text" name="s_user_code">
	            <label>员工名称：</label><input type="text" name="s_user_name">     
	            -->       
	            <a href="javascript:void(0);" class="easyui-linkbutton" id="search_btn" iconCls="icon-search">搜索</a>
	        
        	</fieldset>
        </div>
    </div>

    <div region="center" title="员工工资列表" style="padding:2px;">
        <table id="salaryList"  class="easyui-datagrid"  data-options="rownumbers:true,pagination:true,fitColumns:false,nowrap:false,showFooter:true,singleSelect:true,fit:true,autoRowHeight:false" style="height:500px">
           <thead>
           <tr>
               
			<th field="ck" checkbox="true"></th>
			<th field="other3" width="60px">人员编号</th>
        		<th field="user_code" width="130px">银行账号</th>
				<th field="user_name" width="100px">姓名</th>
				<th field="org_name" width="120px">部门</th>
				<th field="salary_schedule" width="60px">发放时间</th>				
				<th field="salary_type" width="80px">项目</th>
				<th field="all_total" width="80px">合计</th>
				<th field="base_salary" width="60px">岗位工资</th>
				<th field="level_salary" width="60px">薪级工资</th>
				<th field="bus_salary" width="60px">绩效工资</th>
				<!--  
				<th field="traffic_allowance" >交通补</th>
				<th field="gas_allowance" >煤气补</th>
				<th field="life_allowance" >生活补</th>
				<th field="dinner_allowance" >误餐补</th>
				-->
				<th field="proper_allowance" width="60px">各项补贴</th>
				<th field="wash_fee" width="60px">洗理费</th>
				<th field="book_fee" width="60px">书报费</th>
				<th field="profession_allowance" width="60px">职务津贴</th>
				<th field="pre_allowance" width="60px">预增津补贴</th>
				<th field="left_award" width="60px">保留奖金</th>	
				<th field="other11" width="80px">津补贴扣款额度</th>				
				<th field="allowance_sum" width="60px">补贴小计</th>
				<th field="civi_award" width="50px">文明奖</th>
				<th field="one_child_fee" width="50px">独子费</th>
				<th field="energy_allowance" width="50px">能源补</th>				
				<th field="house_allownace" width="60px">住房补贴</th>
				<th field="other_allowance" width="60px">其他补贴</th>
				<th field="salary_little_sum" width="60px">工资小计</th>
				<th field="other14" width="60px">补发工资</th>
				<th field="job_allowance" width="60px">岗位津贴</th>
				<!--  <th field="re_job_allowance" >补发岗位津贴</th> -->
				<th field="oil_allowance" width="60px">粮油蛋补</th>
				<th field="mobile_allowance" width="60px">移动通讯费</th>
				<th field="buy_house_allowance" width="60px">购房补</th>
				<th field="cqj" width="50px">出勤奖</th>
				<th field="jxj" width="60px">平安建设奖</th>
				<th field="fx_allowance" width="60px">防汛津贴</th>
				<th field="other15" width="60px">郑州市文明奖</th>
				<th field="jwf" width="60px">降温费</th>
				<th field="yd_allowance" width="50px">福利</th>
				<th field="other2" width="90px">劳务酬金及奖金</th>
				<th field="mbkhj" width="100px">目标考核及匹配奖</th>
				<th field="sj_award" width="100px">省级文明奖</th>
				<th field="other5" width="100px">年终一次性奖金</th>
				<th field="gwbt" width="100px">高温补贴</th>
				<th field="other6" width="60px">其他金额</th>
				<th field="salary_sum" width="60px">应发合计</th>
				<th field="warm_fee" width="50px">取暖费</th>
				<th field="house_fee" width="40px">房费</th>				
				<th field="water_fee" width="40px">水费</th>
				<th field="pure_water_fee" width="50px">纯水费</th>
				<th field="kmq_fee" width="80px">扣煤气管网费</th>
				<th field="kds_fee" width="80px">扣电视收视费</th>
				<th field="gas_fee" width="50px">扣煤气</th>
				<th field="endowment_insurance" width="60px">养老保险</th>
				<th field="unemployment_insurance" width="60px">失业保险</th>
				<th field="medical_insurance" width="60px">医疗保险</th>
				<th field="house_fund" width="70px">住房公积金</th>
				<th field="re_house_fund" width="70px">补扣公积金</th>	
				<th field="other12" width="80px">预扣养老保险</th>
				<th field="other13" width="80px">预扣职业年金</th>			
				<th field="tax_fee" width="50px">代扣税</th>
				<th field="loan_fee" width="50px">扣借款</th>
				<th field="other_fee" width="60px">其他扣款</th>
				<th field="kk_sum" width="60px">扣款合计</th>
				<th field="real_salary_sum" width="60px">实发合计</th>
				<th field="other" width="60px">其他</th>
				<!--  
				<th field="tax_sum" >应纳税所得</th>
				
				
				<th field="gqzq" >国庆中秋福利</th>
				<th field="sj_award" >省级文明奖</th>
				<th field="zfygyzg" >增发一个月工资</th>
				
				<th field="jxj" >绩效奖</th>
				<th field="jwf" >降温费</th>
				<th field="gwbt" >高温补贴</th>
				<th field="dhb" >电话补</th>
				<th field="bjrcjt" >拔尖人才津贴</th>
				<th field="mbkhj" >目标考核奖</th>
				-->
				
				<!--  
				<th field="other5" >其他2</th>
				<th field="other4" >其他3</th>
				<th field="other3" >其他4</th>
				<th field="other2" >其他5</th>
				<th field="notes" >备注</th>   
				-->					              
            </tr>
          
           	</thead>
        </table>
    </div>
</div>

</div>

<script type="text/javascript" src="js/salaryQuery.js"></script>
<jsp:include page="/public/infoShare/website-foot.jsp"></jsp:include>
