package com.flyrui.dao.pojo.salary;

import java.io.Serializable;
import java.util.Date;

import com.flyrui.common.excel.ExcelAnnotation;

public class BusSalaryLevel implements Serializable {
    private String salary_id;
    
    private String other3;
    
    @ExcelAnnotation(exportName="账号")
    private String user_code;

    @ExcelAnnotation(exportName="姓名")
    private String user_name;    
    
    private String salary_schedule;    
    
    private String salary_type;
    
    private String org_name;   

    @ExcelAnnotation(exportName="合计")
    private Float all_total;
    
    @ExcelAnnotation(exportName="岗位工资")
    private Float base_salary;

    @ExcelAnnotation(exportName="薪级工资")
    private Float level_salary;

    @ExcelAnnotation(exportName="绩效工资")
    private Float bus_salary;
    
    private Float traffic_allowance;
    
    private Float gas_allowance;
    
    private Float life_allowance;
    
    private Float dinner_allowance;
    
    @ExcelAnnotation(exportName="各项补贴")
    private Float proper_allowance;
    
    @ExcelAnnotation(exportName="洗理费")
    private Float wash_fee;
    
    @ExcelAnnotation(exportName="书报费")
    private Float book_fee;

    @ExcelAnnotation(exportName="职务津贴")
    private Float profession_allowance;
    
    @ExcelAnnotation(exportName="预增津补贴")
    private Float pre_allowance;
    
    @ExcelAnnotation(exportName="保留奖金")
    private Float left_award;
    
    @ExcelAnnotation(exportName="津补贴扣款额度")
    private Float other11;
    
    @ExcelAnnotation(exportName="补贴小计")
    private Float allowance_sum;
    
    @ExcelAnnotation(exportName="文明奖")
    private Float civi_award;
    
    @ExcelAnnotation(exportName="独子费")
    private Float one_child_fee;
    
    @ExcelAnnotation(exportName="能源补")
    private Float energy_allowance;  
    
    @ExcelAnnotation(exportName="住房补贴")
    private Float house_allownace; 
    
    @ExcelAnnotation(exportName="其他补贴")
    private Float other_allowance;
    
    @ExcelAnnotation(exportName="工资小计")
    private Float salary_little_sum;
    
    @ExcelAnnotation(exportName="补发工资")
    private Float other14;
    
    @ExcelAnnotation(exportName="岗位津贴")
    private Float job_allowance;    
   
    private Float re_job_allowance;
    
    @ExcelAnnotation(exportName="粮油蛋补")
    private Float oil_allowance;
    
    @ExcelAnnotation(exportName="移动通讯费")
    private Float mobile_allowance;
    
    @ExcelAnnotation(exportName="购房补")    
    private Float buy_house_allowance;
    
    @ExcelAnnotation(exportName = "出勤奖")
    private Float cqj;
    
    @ExcelAnnotation(exportName="平安建设奖")
    private Float jxj; 
    
    @ExcelAnnotation(exportName = "防汛津贴")
    private Float fx_allowance;
    
    @ExcelAnnotation(exportName = "郑州市文明奖")
    private Float other15;
    
    @ExcelAnnotation(exportName="降温费")
    private Float jwf;
    
    @ExcelAnnotation(exportName = "福利")
    private Float yd_allowance;
    
    @ExcelAnnotation(exportName = "劳务酬金及奖金")
    private Float other2;
    
    @ExcelAnnotation(exportName = "目标考核及匹配奖")
    private Float mbkhj; 
    
    @ExcelAnnotation(exportName = "省级文明奖")
	private Float sj_award;
    
    @ExcelAnnotation(exportName = "年终一次性奖金")
    private Float other5;
    
    @ExcelAnnotation(exportName = "高温补贴")
    private Float gwbt;
    
    @ExcelAnnotation(exportName="其他金额")
    private Float other6;
    
    @ExcelAnnotation(exportName="应发合计")
    private Float salary_sum;
    
    @ExcelAnnotation(exportName="取暖费")
    private Float warm_fee;
    
    @ExcelAnnotation(exportName="房费")
    private Float house_fee;
    
    @ExcelAnnotation(exportName="水费")
    private Float water_fee;
    
    @ExcelAnnotation(exportName="纯水费")
    private Float pure_water_fee;
    
    @ExcelAnnotation(exportName="扣煤气管网费")
    private Float kmq_fee;
    
    @ExcelAnnotation(exportName="扣电视收视费")
    private Float kds_fee;
    
    @ExcelAnnotation(exportName="扣煤气")
    private Float gas_fee;
    
    @ExcelAnnotation(exportName="养老保险")
    private Float endowment_insurance;
    
    @ExcelAnnotation(exportName="失业保险")
    private Float unemployment_insurance;
    
    @ExcelAnnotation(exportName="医疗保险")
    private Float medical_insurance;
    
    @ExcelAnnotation(exportName="住房公积金")
    private Float house_fund;
    
    @ExcelAnnotation(exportName="预扣养老保险")
    private Float other12;
    
    @ExcelAnnotation(exportName="预扣职业年金")
    private Float other13;
    
    @ExcelAnnotation(exportName="代扣税")
    private Float tax_fee;    
    
    private Float re_house_fund;
    
    @ExcelAnnotation(exportName="扣借款")
    private Float loan_fee;    
    
    @ExcelAnnotation(exportName="其他扣款")
    private Float other_fee;
    
    @ExcelAnnotation(exportName="扣款合计")
    private Float kk_sum;
    
    @ExcelAnnotation(exportName="实发合计")
    private Float real_salary_sum;
    
    @ExcelAnnotation(exportName="其他")
    private Float other;
    
    private Float tax_sum; 
    
    private Float gqzq;
    
    private Float zfygyzg; 
    
    private Float dhb;
   
    private Float bjrcjt;     
    

    private Float other4;
    
    private Float notes;

    private Date create_date;

    private String oper_user_id;
    
    private String batch_id;
    
    private String salary_schedule_start;
    
    private String salary_schedule_end;
    
    private String position_level;
    
   
    
   
    
    
    
    
    
    private String other16;
    
    private String other17;
    
    private String other18;
    
    private static final long serialVersionUID = 1L;

    public String getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(String salary_id) {
        this.salary_id = salary_id == null ? null : salary_id.trim();
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getSalary_schedule() {
        return salary_schedule;
    }

    public void setSalary_schedule(String salary_schedule) {
        this.salary_schedule = salary_schedule == null ? null : salary_schedule.trim();
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name == null ? null : org_name.trim();
    }

    public String getSalary_type() {
        return salary_type;
    }

    public void setSalary_type(String salary_type) {
        this.salary_type = salary_type == null ? null : salary_type.trim();
    }

    public Float getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(Float base_salary) {
        this.base_salary = base_salary;
    }

    public Float getLevel_salary() {
        return level_salary;
    }

    public void setLevel_salary(Float level_salary) {
        this.level_salary = level_salary;
    }

    public Float getBus_salary() {
        return bus_salary;
    }

    public void setBus_salary(Float bus_salary) {
        this.bus_salary = bus_salary;
    }

    public Float getTraffic_allowance() {
        return traffic_allowance;
    }

    public void setTraffic_allowance(Float traffic_allowance) {
        this.traffic_allowance = traffic_allowance;
    }

    public Float getGas_allowance() {
        return gas_allowance;
    }

    public void setGas_allowance(Float gas_allowance) {
        this.gas_allowance = gas_allowance;
    }

    public Float getLife_allowance() {
        return life_allowance;
    }

    public void setLife_allowance(Float life_allowance) {
        this.life_allowance = life_allowance;
    }

    public Float getDinner_allowance() {
        return dinner_allowance;
    }

    public void setDinner_allowance(Float dinner_allowance) {
        this.dinner_allowance = dinner_allowance;
    }

    public Float getProper_allowance() {
        return proper_allowance;
    }

    public void setProper_allowance(Float proper_allowance) {
        this.proper_allowance = proper_allowance;
    }

    public Float getWash_fee() {
        return wash_fee;
    }

    public void setWash_fee(Float wash_fee) {
        this.wash_fee = wash_fee;
    }

    public Float getBook_fee() {
        return book_fee;
    }

    public void setBook_fee(Float book_fee) {
        this.book_fee = book_fee;
    }

    public Float getProfession_allowance() {
        return profession_allowance;
    }

    public void setProfession_allowance(Float profession_allowance) {
        this.profession_allowance = profession_allowance;
    }

    public Float getLeft_award() {
        return left_award;
    }

    public void setLeft_award(Float left_award) {
        this.left_award = left_award;
    }

    public Float getAllowance_sum() {
        return allowance_sum;
    }

    public void setAllowance_sum(Float allowance_sum) {
        this.allowance_sum = allowance_sum;
    }

    public Float getCivi_award() {
        return civi_award;
    }

    public void setCivi_award(Float civi_award) {
        this.civi_award = civi_award;
    }

    public Float getEnergy_allowance() {
        return energy_allowance;
    }

    public void setEnergy_allowance(Float energy_allowance) {
        this.energy_allowance = energy_allowance;
    }

    public Float getOne_child_fee() {
        return one_child_fee;
    }

    public void setOne_child_fee(Float one_child_fee) {
        this.one_child_fee = one_child_fee;
    }

    public Float getHouse_allownace() {
        return house_allownace;
    }

    public void setHouse_allownace(Float house_allownace) {
        this.house_allownace = house_allownace;
    }

    public Float getPre_allowance() {
        return pre_allowance;
    }

    public void setPre_allowance(Float pre_allowance) {
        this.pre_allowance = pre_allowance;
    }

    public Float getOther_allowance() {
        return other_allowance;
    }

    public void setOther_allowance(Float other_allowance) {
        this.other_allowance = other_allowance;
    }

    public Float getSalary_little_sum() {
        return salary_little_sum;
    }

    public void setSalary_little_sum(Float salary_little_sum) {
        this.salary_little_sum = salary_little_sum;
    }

    public Float getJob_allowance() {
        return job_allowance;
    }

    public void setJob_allowance(Float job_allowance) {
        this.job_allowance = job_allowance;
    }

    public Float getRe_job_allowance() {
        return re_job_allowance;
    }

    public void setRe_job_allowance(Float re_job_allowance) {
        this.re_job_allowance = re_job_allowance;
    }

    public Float getOil_allowance() {
        return oil_allowance;
    }

    public void setOil_allowance(Float oil_allowance) {
        this.oil_allowance = oil_allowance;
    }

    public Float getMobile_allowance() {
        return mobile_allowance;
    }

    public void setMobile_allowance(Float mobile_allowance) {
        this.mobile_allowance = mobile_allowance;
    }

    public Float getBuy_house_allowance() {
        return buy_house_allowance;
    }

    public void setBuy_house_allowance(Float buy_house_allowance) {
        this.buy_house_allowance = buy_house_allowance;
    }

    public Float getSalary_sum() {
        return salary_sum;
    }

    public void setSalary_sum(Float salary_sum) {
        this.salary_sum = salary_sum;
    }

    public Float getHouse_fee() {
        return house_fee;
    }

    public void setHouse_fee(Float house_fee) {
        this.house_fee = house_fee;
    }

    public Float getWarm_fee() {
        return warm_fee;
    }

    public void setWarm_fee(Float warm_fee) {
        this.warm_fee = warm_fee;
    }

    public Float getWater_fee() {
        return water_fee;
    }

    public void setWater_fee(Float water_fee) {
        this.water_fee = water_fee;
    }

    public Float getPure_water_fee() {
        return pure_water_fee;
    }

    public void setPure_water_fee(Float pure_water_fee) {
        this.pure_water_fee = pure_water_fee;
    }

    public Float getGas_fee() {
        return gas_fee;
    }

    public void setGas_fee(Float gas_fee) {
        this.gas_fee = gas_fee;
    }

    public Float getEndowment_insurance() {
        return endowment_insurance;
    }

    public void setEndowment_insurance(Float endowment_insurance) {
        this.endowment_insurance = endowment_insurance;
    }

    public Float getUnemployment_insurance() {
        return unemployment_insurance;
    }

    public void setUnemployment_insurance(Float unemployment_insurance) {
        this.unemployment_insurance = unemployment_insurance;
    }

    public Float getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(Float medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public Float getHouse_fund() {
        return house_fund;
    }

    public void setHouse_fund(Float house_fund) {
        this.house_fund = house_fund;
    }

    public Float getRe_house_fund() {
        return re_house_fund;
    }

    public void setRe_house_fund(Float re_house_fund) {
        this.re_house_fund = re_house_fund;
    }

    public Float getLoan_fee() {
        return loan_fee;
    }

    public void setLoan_fee(Float loan_fee) {
        this.loan_fee = loan_fee;
    }

    public Float getTax_fee() {
        return tax_fee;
    }

    public void setTax_fee(Float tax_fee) {
        this.tax_fee = tax_fee;
    }

    public Float getKmq_fee() {
        return kmq_fee;
    }

    public void setKmq_fee(Float kmq_fee) {
        this.kmq_fee = kmq_fee;
    }

    public Float getKds_fee() {
        return kds_fee;
    }

    public void setKds_fee(Float kds_fee) {
        this.kds_fee = kds_fee;
    }

    public Float getOther_fee() {
        return other_fee;
    }

    public void setOther_fee(Float other_fee) {
        this.other_fee = other_fee;
    }

    public Float getKk_sum() {
        return kk_sum;
    }

    public void setKk_sum(Float kk_sum) {
        this.kk_sum = kk_sum;
    }

    public Float getReal_salary_sum() {
        return real_salary_sum;
    }

    public void setReal_salary_sum(Float real_salary_sum) {
        this.real_salary_sum = real_salary_sum;
    }

    public Float getTax_sum() {
        return tax_sum;
    }

    public void setTax_sum(Float tax_sum) {
        this.tax_sum = tax_sum;
    }

    public Float getFx_allowance() {
        return fx_allowance;
    }

    public void setFx_allowance(Float fx_allowance) {
        this.fx_allowance = fx_allowance;
    }

    public Float getYd_allowance() {
        return yd_allowance;
    }

    public void setYd_allowance(Float yd_allowance) {
        this.yd_allowance = yd_allowance;
    }

    public Float getGqzq() {
        return gqzq;
    }

    public void setGqzq(Float gqzq) {
        this.gqzq = gqzq;
    }

    public Float getSj_award() {
        return sj_award;
    }

    public void setSj_award(Float sj_award) {
        this.sj_award = sj_award;
    }

    public Float getZfygyzg() {
        return zfygyzg;
    }

    public void setZfygyzg(Float zfygyzg) {
        this.zfygyzg = zfygyzg;
    }

    public Float getCqj() {
        return cqj;
    }

    public void setCqj(Float cqj) {
        this.cqj = cqj;
    }

    public Float getJxj() {
        return jxj;
    }

    public void setJxj(Float jxj) {
        this.jxj = jxj;
    }

    public Float getJwf() {
        return jwf;
    }

    public void setJwf(Float jwf) {
        this.jwf = jwf;
    }

    public Float getGwbt() {
        return gwbt;
    }

    public void setGwbt(Float gwbt) {
        this.gwbt = gwbt;
    }

    public Float getDhb() {
        return dhb;
    }

    public void setDhb(Float dhb) {
        this.dhb = dhb;
    }

    public Float getBjrcjt() {
        return bjrcjt;
    }

    public void setBjrcjt(Float bjrcjt) {
        this.bjrcjt = bjrcjt;
    }

    public Float getMbkhj() {
        return mbkhj;
    }

    public void setMbkhj(Float mbkhj) {
        this.mbkhj = mbkhj;
    }

    public Float getOther6() {
        return other6;
    }

    public void setOther6(Float other6) {
        this.other6 = other6;
    }

    public Float getOther5() {
        return other5;
    }

    public void setOther5(Float other5) {
        this.other5 = other5;
    }

    public Float getOther4() {
        return other4;
    }

    public void setOther4(Float other4) {
        this.other4 = other4;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public Float getOther2() {
        return other2;
    }

    public void setOther2(Float other2) {
        this.other2 = other2;
    }

    public Float getNotes() {
        return notes;
    }

    public void setNotes(Float notes) {
        this.notes = notes;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getOper_user_id() {
        return oper_user_id;
    }

    public void setOper_user_id(String oper_user_id) {
        this.oper_user_id = oper_user_id == null ? null : oper_user_id.trim();
    }

	public String getBatch_id() {
		return batch_id;
	}

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id == null ? null : batch_id.trim();
    }

	public String getSalary_schedule_start() {
		return salary_schedule_start;
	}

	public void setSalary_schedule_start(String salaryScheduleStart) {
		salary_schedule_start = salaryScheduleStart;
	}

	public String getSalary_schedule_end() {
		return salary_schedule_end;
	}

	public void setSalary_schedule_end(String salaryScheduleEnd) {
		salary_schedule_end = salaryScheduleEnd;
	}

	public Float getAll_total() {
		return all_total;
	}

	public void setAll_total(Float allTotal) {
		all_total = allTotal;
	}

	public String getPosition_level() {
		return position_level;
	}

	public void setPosition_level(String positionLevel) {
		position_level = positionLevel;
	}

	public Float getOther() {
		return other;
	}

	public void setOther(Float other) {
		this.other = other;
	}

	public Float getOther11() {
		return other11;
	}

	public void setOther11(Float other11) {
		this.other11 = other11;
	}

	public Float getOther12() {
		return other12;
	}

	public void setOther12(Float other12) {
		this.other12 = other12;
	}

	public Float getOther13() {
		return other13;
	}

	public void setOther13(Float other13) {
		this.other13 = other13;
	}

	public Float getOther14() {
		return other14;
	}

	public void setOther14(Float other14) {
		this.other14 = other14;
	}

	public Float getOther15() {
		return other15;
	}

	public void setOther15(Float other15) {
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