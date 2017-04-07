package com.flyrui.salary.dto;

import java.io.Serializable;

import com.flyrui.common.excel.ExcelAnnotation;

public class SalaryDto implements Serializable {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L;
	
	@ExcelAnnotation(exportName = "账号")
	private String user_code;
	
	@ExcelAnnotation(exportName = "姓名")
	private String user_name;
	
	@ExcelAnnotation(exportName = "发放时间")
	private String salary_schedule;	
	
	@ExcelAnnotation(exportName = "部门")
	private String org_name;	
	
	@ExcelAnnotation(exportName = "项目")
	private String salary_type;
	
	@ExcelAnnotation(exportName = "岗位工资")
	private String base_salary;
	
	@ExcelAnnotation(exportName = "薪级工资")
	private String level_salary;	
	
	@ExcelAnnotation(exportName = "绩效工资")
	private String bus_salary;
	
	@ExcelAnnotation(exportName = "交通补")
	private String traffic_allowance;
	
	@ExcelAnnotation(exportName = "煤气补")
	private String gas_allowance;
	
	@ExcelAnnotation(exportName = "生活补")
	private String life_allowance;
	
	@ExcelAnnotation(exportName = "误餐补")
	private String dinner_allowance;
	
	@ExcelAnnotation(exportName = "各项补贴")
	private String proper_allowance;
	
	@ExcelAnnotation(exportName = "洗理费")
	private String wash_fee;
	
	@ExcelAnnotation(exportName = "书报费")
	private String book_fee;
	
	@ExcelAnnotation(exportName = "职务津贴")
	private String profession_allowance;
	
	@ExcelAnnotation(exportName = "保留奖金")
	private String left_award;
	
	@ExcelAnnotation(exportName = "补贴小计")
	private String allowance_sum;
	
	@ExcelAnnotation(exportName = "文明奖")
	private String civi_award;
	
	@ExcelAnnotation(exportName = "能源补")
	private String energy_allowance;
	
	@ExcelAnnotation(exportName = "独子费")
	private String one_child_fee;
	
	@ExcelAnnotation(exportName = "住房补贴")
	private String house_allownace;
	
	@ExcelAnnotation(exportName = "预增津补贴")
	private String pre_allowance;
	
	@ExcelAnnotation(exportName = "其他补贴")
	private String other_allowance;
	
	@ExcelAnnotation(exportName = "工资小计")
	private String salary_little_sum;
	
	@ExcelAnnotation(exportName = "岗位津贴")
	private String job_allowance;
	
	@ExcelAnnotation(exportName = "补发岗位津贴")
	private String re_job_allowance;
	
	@ExcelAnnotation(exportName = "粮油蛋补")
	private String oil_allowance;
	
	@ExcelAnnotation(exportName = "移动通讯费")
	private String mobile_allowance;
	
	@ExcelAnnotation(exportName = "购房补")
	private String buy_house_allowance;
	
	@ExcelAnnotation(exportName = "应发合计")
	private String salary_sum;
	
	@ExcelAnnotation(exportName = "房费")
	private String house_fee;
	
	@ExcelAnnotation(exportName = "取暖费")
	private String warm_fee;
	
	@ExcelAnnotation(exportName = "水费")
	private String water_fee;
	
	@ExcelAnnotation(exportName = "纯水费")
	private String pure_water_fee;
	
	@ExcelAnnotation(exportName = "扣煤气")
	private String gas_fee;
	
	@ExcelAnnotation(exportName = "养老保险")
	private String endowment_insurance;
	
	@ExcelAnnotation(exportName = "失业保险")
	private String unemployment_insurance;
	
	@ExcelAnnotation(exportName = "医疗保险")
	private String medical_insurance;
	
	@ExcelAnnotation(exportName = "住房公积金")
	private String house_fund;
	
	@ExcelAnnotation(exportName = "补扣公积金")
	private String re_house_fund;
	
	@ExcelAnnotation(exportName = "扣借款")
	private String loan_fee;
	
	@ExcelAnnotation(exportName = "代扣税")
	private String tax_fee;
	
	@ExcelAnnotation(exportName = "扣煤气管网费")
	private String kmq_fee;
	
	@ExcelAnnotation(exportName = "扣电视收视费")
	private String kds_fee;
	
	@ExcelAnnotation(exportName = "其他扣款")
	private String other_fee;
	
	@ExcelAnnotation(exportName = "扣款合计")
	private String kk_sum;
	
	@ExcelAnnotation(exportName = "实发合计")
	private String real_salary_sum;
	
	@ExcelAnnotation(exportName = "应纳税所得")
	private String tax_sum;
	
	@ExcelAnnotation(exportName = "防汛津贴")
	private String fx_allowance;
	
	@ExcelAnnotation(exportName = "福利")
	private String yd_allowance;
	
	@ExcelAnnotation(exportName = "国庆中秋福利")
	private String gqzq;
	
	@ExcelAnnotation(exportName = "省级文明奖")
	private String sj_award;
	
	@ExcelAnnotation(exportName = "增发一个月工资")
	private String zfygyzg;
	
	@ExcelAnnotation(exportName = "出勤奖")
	private String cqj;
	
	@ExcelAnnotation(exportName = "平安建设奖")
	private String jxj;
	
	@ExcelAnnotation(exportName = "降温费")
	private String jwf;
	
	@ExcelAnnotation(exportName = "高温补贴")
	private String gwbt;
	
	@ExcelAnnotation(exportName = "电话补")
	private String dhb;
	
	@ExcelAnnotation(exportName = "拔尖人才津贴")
	private String bjrcjt;
	
	@ExcelAnnotation(exportName = "目标考核及匹配奖")
	private String mbkhj;
	
	@ExcelAnnotation(exportName = "其他金额")
	private String other6;
	
	@ExcelAnnotation(exportName = "年终一次性奖金")
	private String other5;
	
	@ExcelAnnotation(exportName = "其他3")
	private String other4;
	
	@ExcelAnnotation(exportName = "人员编号")
	private String other3;
	
	@ExcelAnnotation(exportName = "劳务酬金及奖金")
	private String other2;
	
	@ExcelAnnotation(exportName = "备注")
	private String notes;
	
	@ExcelAnnotation(exportName = "其他")
	private String other;
	
	@ExcelAnnotation(exportName="津补贴扣款额度")
	private String other11;
	    
	@ExcelAnnotation(exportName="预扣养老保险")
	private String other12;
	    
	@ExcelAnnotation(exportName="预扣职业年金")
	private String other13;
	
	@ExcelAnnotation(exportName = "补发工资")
	private String other14;
	
	@ExcelAnnotation(exportName = "郑州市文明奖")
	private String other15;
	
	@ExcelAnnotation(exportName = "其他6")
	private String other16;
	
	@ExcelAnnotation(exportName = "其他7")
	private String other17;
	
	@ExcelAnnotation(exportName = "其他8")
	private String other18;


	public String getSalary_type() {
		return salary_type;
	}

	public void setSalary_type(String salaryType) {
		salary_type = salaryType;
	}
	
	public String getSalary_schedule() {
		return salary_schedule;
	}

	public void setSalary_schedule(String salarySchedule) {
		salary_schedule = salarySchedule;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String userCode) {
		user_code = userCode;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String orgName) {
		org_name = orgName;
	}

	public String getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(String baseSalary) {
		base_salary = baseSalary;
	}

	public String getLevel_salary() {
		return level_salary;
	}

	public void setLevel_salary(String levelSalary) {
		level_salary = levelSalary;
	}

	public String getBus_salary() {
		return bus_salary;
	}

	public void setBus_salary(String busSalary) {
		bus_salary = busSalary;
	}

	public String getTraffic_allowance() {
		return traffic_allowance;
	}

	public void setTraffic_allowance(String trafficAllowance) {
		traffic_allowance = trafficAllowance;
	}

	public String getGas_allowance() {
		return gas_allowance;
	}

	public void setGas_allowance(String gasAllowance) {
		gas_allowance = gasAllowance;
	}

	public String getLife_allowance() {
		return life_allowance;
	}

	public void setLife_allowance(String lifeAllowance) {
		life_allowance = lifeAllowance;
	}

	public String getDinner_allowance() {
		return dinner_allowance;
	}

	public void setDinner_allowance(String dinnerAllowance) {
		dinner_allowance = dinnerAllowance;
	}

	public String getProper_allowance() {
		return proper_allowance;
	}

	public void setProper_allowance(String properAllowance) {
		proper_allowance = properAllowance;
	}

	public String getWash_fee() {
		return wash_fee;
	}

	public void setWash_fee(String washFee) {
		wash_fee = washFee;
	}

	public String getBook_fee() {
		return book_fee;
	}

	public void setBook_fee(String bookFee) {
		book_fee = bookFee;
	}

	public String getProfession_allowance() {
		return profession_allowance;
	}

	public void setProfession_allowance(String professionAllowance) {
		profession_allowance = professionAllowance;
	}

	public String getLeft_award() {
		return left_award;
	}

	public void setLeft_award(String leftAward) {
		left_award = leftAward;
	}

	public String getAllowance_sum() {
		return allowance_sum;
	}

	public void setAllowance_sum(String allowanceSum) {
		allowance_sum = allowanceSum;
	}

	public String getCivi_award() {
		return civi_award;
	}

	public void setCivi_award(String civiAward) {
		civi_award = civiAward;
	}

	public String getEnergy_allowance() {
		return energy_allowance;
	}

	public void setEnergy_allowance(String energyAllowance) {
		energy_allowance = energyAllowance;
	}

	public String getOne_child_fee() {
		return one_child_fee;
	}

	public void setOne_child_fee(String oneChildFee) {
		one_child_fee = oneChildFee;
	}

	public String getHouse_allownace() {
		return house_allownace;
	}

	public void setHouse_allownace(String houseAllownace) {
		house_allownace = houseAllownace;
	}

	public String getPre_allowance() {
		return pre_allowance;
	}

	public void setPre_allowance(String preAllowance) {
		pre_allowance = preAllowance;
	}

	public String getOther_allowance() {
		return other_allowance;
	}

	public void setOther_allowance(String otherAllowance) {
		other_allowance = otherAllowance;
	}

	public String getSalary_little_sum() {
		return salary_little_sum;
	}

	public void setSalary_little_sum(String salaryLittleSum) {
		salary_little_sum = salaryLittleSum;
	}

	public String getJob_allowance() {
		return job_allowance;
	}

	public void setJob_allowance(String jobAllowance) {
		job_allowance = jobAllowance;
	}

	public String getRe_job_allowance() {
		return re_job_allowance;
	}

	public void setRe_job_allowance(String reJobAllowance) {
		re_job_allowance = reJobAllowance;
	}

	public String getOil_allowance() {
		return oil_allowance;
	}

	public void setOil_allowance(String oilAllowance) {
		oil_allowance = oilAllowance;
	}

	public String getMobile_allowance() {
		return mobile_allowance;
	}

	public void setMobile_allowance(String mobileAllowance) {
		mobile_allowance = mobileAllowance;
	}

	public String getBuy_house_allowance() {
		return buy_house_allowance;
	}

	public void setBuy_house_allowance(String buyHouseAllowance) {
		buy_house_allowance = buyHouseAllowance;
	}

	public String getSalary_sum() {
		return salary_sum;
	}

	public void setSalary_sum(String salarySum) {
		salary_sum = salarySum;
	}

	public String getHouse_fee() {
		return house_fee;
	}

	public void setHouse_fee(String houseFee) {
		house_fee = houseFee;
	}

	public String getWarm_fee() {
		return warm_fee;
	}

	public void setWarm_fee(String warmFee) {
		warm_fee = warmFee;
	}

	public String getWater_fee() {
		return water_fee;
	}

	public void setWater_fee(String waterFee) {
		water_fee = waterFee;
	}

	public String getPure_water_fee() {
		return pure_water_fee;
	}

	public void setPure_water_fee(String pureWaterFee) {
		pure_water_fee = pureWaterFee;
	}

	public String getGas_fee() {
		return gas_fee;
	}

	public void setGas_fee(String gasFee) {
		gas_fee = gasFee;
	}

	public String getEndowment_insurance() {
		return endowment_insurance;
	}

	public void setEndowment_insurance(String endowmentInsurance) {
		endowment_insurance = endowmentInsurance;
	}

	public String getUnemployment_insurance() {
		return unemployment_insurance;
	}

	public void setUnemployment_insurance(String unemploymentInsurance) {
		unemployment_insurance = unemploymentInsurance;
	}

	public String getMedical_insurance() {
		return medical_insurance;
	}

	public void setMedical_insurance(String medicalInsurance) {
		medical_insurance = medicalInsurance;
	}

	public String getHouse_fund() {
		return house_fund;
	}

	public void setHouse_fund(String houseFund) {
		house_fund = houseFund;
	}

	public String getRe_house_fund() {
		return re_house_fund;
	}

	public void setRe_house_fund(String reHouseFund) {
		re_house_fund = reHouseFund;
	}

	public String getLoan_fee() {
		return loan_fee;
	}

	public void setLoan_fee(String loanFee) {
		loan_fee = loanFee;
	}

	public String getTax_fee() {
		return tax_fee;
	}

	public void setTax_fee(String taxFee) {
		tax_fee = taxFee;
	}

	public String getKmq_fee() {
		return kmq_fee;
	}

	public void setKmq_fee(String kmqFee) {
		kmq_fee = kmqFee;
	}

	public String getKds_fee() {
		return kds_fee;
	}

	public void setKds_fee(String kdsFee) {
		kds_fee = kdsFee;
	}

	public String getKk_sum() {
		return kk_sum;
	}

	public void setKk_sum(String kkSum) {
		kk_sum = kkSum;
	}

	public String getReal_salary_sum() {
		return real_salary_sum;
	}

	public void setReal_salary_sum(String realSalarySum) {
		real_salary_sum = realSalarySum;
	}

	public String getTax_sum() {
		return tax_sum;
	}

	public void setTax_sum(String taxSum) {
		tax_sum = taxSum;
	}

	public String getFx_allowance() {
		return fx_allowance;
	}

	public void setFx_allowance(String fxAllowance) {
		fx_allowance = fxAllowance;
	}

	public String getYd_allowance() {
		return yd_allowance;
	}

	public void setYd_allowance(String ydAllowance) {
		yd_allowance = ydAllowance;
	}

	public String getSj_award() {
		return sj_award;
	}

	public void setSj_award(String sjAward) {
		sj_award = sjAward;
	}

	public String getZfygyzg() {
		return zfygyzg;
	}

	public void setZfygyzg(String zfygyzg) {
		this.zfygyzg = zfygyzg;
	}

	public String getCqj() {
		return cqj;
	}

	public void setCqj(String cqj) {
		this.cqj = cqj;
	}

	public String getJxj() {
		return jxj;
	}

	public void setJxj(String jxj) {
		this.jxj = jxj;
	}

	public String getJwf() {
		return jwf;
	}

	public void setJwf(String jwf) {
		this.jwf = jwf;
	}

	public String getGwbt() {
		return gwbt;
	}

	public void setGwbt(String gwbt) {
		this.gwbt = gwbt;
	}

	public String getDhb() {
		return dhb;
	}

	public void setDhb(String dhb) {
		this.dhb = dhb;
	}

	public String getBjrcjt() {
		return bjrcjt;
	}

	public void setBjrcjt(String bjrcjt) {
		this.bjrcjt = bjrcjt;
	}

	public String getMbkhj() {
		return mbkhj;
	}

	public void setMbkhj(String mbkhj) {
		this.mbkhj = mbkhj;
	}

	public String getOther6() {
		return other6;
	}

	public void setOther6(String other6) {
		this.other6 = other6;
	}

	public String getOther5() {
		return other5;
	}

	public void setOther5(String other5) {
		this.other5 = other5;
	}

	public String getOther4() {
		return other4;
	}

	public void setOther4(String other4) {
		this.other4 = other4;
	}

	public String getOther3() {
		return other3;
	}

	public void setOther3(String other3) {
		this.other3 = other3;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOther_fee() {
		return other_fee;
	}

	public void setOther_fee(String otherFee) {
		other_fee = otherFee;
	}

	public String getGqzq() {
		return gqzq;
	}

	public void setGqzq(String gqzq) {
		this.gqzq = gqzq;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getOther11() {
		return other11;
	}

	public void setOther11(String other11) {
		this.other11 = other11;
	}

	public String getOther12() {
		return other12;
	}

	public void setOther12(String other12) {
		this.other12 = other12;
	}

	public String getOther13() {
		return other13;
	}

	public void setOther13(String other13) {
		this.other13 = other13;
	}

	public String getOther14() {
		return other14;
	}

	public void setOther14(String other14) {
		this.other14 = other14;
	}

	public String getOther15() {
		return other15;
	}

	public void setOther15(String other15) {
		this.other15 = other15;
	}

	public String getOther16() {
		return other16;
	}

	public void setOther16(String other16) {
		this.other16 = other16;
	}

	public String getOther17() {
		return other17;
	}

	public void setOther17(String other17) {
		this.other17 = other17;
	}

	public String getOther18() {
		return other18;
	}

	public void setOther18(String other18) {
		this.other18 = other18;
	}
	
}
