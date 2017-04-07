package com.flyrui.dao.pojo.salary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusSalaryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusSalaryCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSalary_idIsNull() {
            addCriterion("salary_id is null");
            return (Criteria) this;
        }

        public Criteria andSalary_idIsNotNull() {
            addCriterion("salary_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalary_idEqualTo(String value) {
            addCriterion("salary_id =", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idNotEqualTo(String value) {
            addCriterion("salary_id <>", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idGreaterThan(String value) {
            addCriterion("salary_id >", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idGreaterThanOrEqualTo(String value) {
            addCriterion("salary_id >=", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idLessThan(String value) {
            addCriterion("salary_id <", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idLessThanOrEqualTo(String value) {
            addCriterion("salary_id <=", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idLike(String value) {
            addCriterion("salary_id like", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idNotLike(String value) {
            addCriterion("salary_id not like", value, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idIn(List<String> values) {
            addCriterion("salary_id in", values, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idNotIn(List<String> values) {
            addCriterion("salary_id not in", values, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idBetween(String value1, String value2) {
            addCriterion("salary_id between", value1, value2, "salary_id");
            return (Criteria) this;
        }

        public Criteria andSalary_idNotBetween(String value1, String value2) {
            addCriterion("salary_id not between", value1, value2, "salary_id");
            return (Criteria) this;
        }

        public Criteria andUser_codeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUser_codeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUser_codeEqualTo(String value) {
            addCriterion("user_code =", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeGreaterThan(String value) {
            addCriterion("user_code >", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeLessThan(String value) {
            addCriterion("user_code <", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeLike(String value) {
            addCriterion("user_code like", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeNotLike(String value) {
            addCriterion("user_code not like", value, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeIn(List<String> values) {
            addCriterion("user_code in", values, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_codeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "user_code");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("user_name =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("user_name >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("user_name <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("user_name like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("user_name not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("user_name in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleIsNull() {
            addCriterion("salary_schedule is null");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleIsNotNull() {
            addCriterion("salary_schedule is not null");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleEqualTo(String value) {
            addCriterion("salary_schedule =", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleNotEqualTo(String value) {
            addCriterion("salary_schedule <>", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleGreaterThan(String value) {
            addCriterion("salary_schedule >", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleGreaterThanOrEqualTo(String value) {
            addCriterion("salary_schedule >=", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleLessThan(String value) {
            addCriterion("salary_schedule <", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleLessThanOrEqualTo(String value) {
            addCriterion("salary_schedule <=", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleLike(String value) {
            addCriterion("salary_schedule like", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleNotLike(String value) {
            addCriterion("salary_schedule not like", value, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleIn(List<String> values) {
            addCriterion("salary_schedule in", values, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleNotIn(List<String> values) {
            addCriterion("salary_schedule not in", values, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleBetween(String value1, String value2) {
            addCriterion("salary_schedule between", value1, value2, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andSalary_scheduleNotBetween(String value1, String value2) {
            addCriterion("salary_schedule not between", value1, value2, "salary_schedule");
            return (Criteria) this;
        }

        public Criteria andOrg_nameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrg_nameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrg_nameEqualTo(String value) {
            addCriterion("org_name =", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameGreaterThan(String value) {
            addCriterion("org_name >", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameLessThan(String value) {
            addCriterion("org_name <", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameLike(String value) {
            addCriterion("org_name like", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameNotLike(String value) {
            addCriterion("org_name not like", value, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameIn(List<String> values) {
            addCriterion("org_name in", values, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "org_name");
            return (Criteria) this;
        }

        public Criteria andOrg_nameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "org_name");
            return (Criteria) this;
        }

        public Criteria andSalary_typeIsNull() {
            addCriterion("salary_type is null");
            return (Criteria) this;
        }

        public Criteria andSalary_typeIsNotNull() {
            addCriterion("salary_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalary_typeEqualTo(String value) {
            addCriterion("salary_type =", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeNotEqualTo(String value) {
            addCriterion("salary_type <>", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeGreaterThan(String value) {
            addCriterion("salary_type >", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeGreaterThanOrEqualTo(String value) {
            addCriterion("salary_type >=", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeLessThan(String value) {
            addCriterion("salary_type <", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeLessThanOrEqualTo(String value) {
            addCriterion("salary_type <=", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeLike(String value) {
            addCriterion("salary_type like", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeNotLike(String value) {
            addCriterion("salary_type not like", value, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeIn(List<String> values) {
            addCriterion("salary_type in", values, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeNotIn(List<String> values) {
            addCriterion("salary_type not in", values, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeBetween(String value1, String value2) {
            addCriterion("salary_type between", value1, value2, "salary_type");
            return (Criteria) this;
        }

        public Criteria andSalary_typeNotBetween(String value1, String value2) {
            addCriterion("salary_type not between", value1, value2, "salary_type");
            return (Criteria) this;
        }

        public Criteria andBase_salaryIsNull() {
            addCriterion("base_salary is null");
            return (Criteria) this;
        }

        public Criteria andBase_salaryIsNotNull() {
            addCriterion("base_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBase_salaryEqualTo(Float value) {
            addCriterion("base_salary =", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryNotEqualTo(Float value) {
            addCriterion("base_salary <>", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryGreaterThan(Float value) {
            addCriterion("base_salary >", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryGreaterThanOrEqualTo(Float value) {
            addCriterion("base_salary >=", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryLessThan(Float value) {
            addCriterion("base_salary <", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryLessThanOrEqualTo(Float value) {
            addCriterion("base_salary <=", value, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryIn(List<Float> values) {
            addCriterion("base_salary in", values, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryNotIn(List<Float> values) {
            addCriterion("base_salary not in", values, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryBetween(Float value1, Float value2) {
            addCriterion("base_salary between", value1, value2, "base_salary");
            return (Criteria) this;
        }

        public Criteria andBase_salaryNotBetween(Float value1, Float value2) {
            addCriterion("base_salary not between", value1, value2, "base_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryIsNull() {
            addCriterion("level_salary is null");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryIsNotNull() {
            addCriterion("level_salary is not null");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryEqualTo(Float value) {
            addCriterion("level_salary =", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryNotEqualTo(Float value) {
            addCriterion("level_salary <>", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryGreaterThan(Float value) {
            addCriterion("level_salary >", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryGreaterThanOrEqualTo(Float value) {
            addCriterion("level_salary >=", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryLessThan(Float value) {
            addCriterion("level_salary <", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryLessThanOrEqualTo(Float value) {
            addCriterion("level_salary <=", value, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryIn(List<Float> values) {
            addCriterion("level_salary in", values, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryNotIn(List<Float> values) {
            addCriterion("level_salary not in", values, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryBetween(Float value1, Float value2) {
            addCriterion("level_salary between", value1, value2, "level_salary");
            return (Criteria) this;
        }

        public Criteria andLevel_salaryNotBetween(Float value1, Float value2) {
            addCriterion("level_salary not between", value1, value2, "level_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryIsNull() {
            addCriterion("bus_salary is null");
            return (Criteria) this;
        }

        public Criteria andBus_salaryIsNotNull() {
            addCriterion("bus_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBus_salaryEqualTo(Float value) {
            addCriterion("bus_salary =", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryNotEqualTo(Float value) {
            addCriterion("bus_salary <>", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryGreaterThan(Float value) {
            addCriterion("bus_salary >", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryGreaterThanOrEqualTo(Float value) {
            addCriterion("bus_salary >=", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryLessThan(Float value) {
            addCriterion("bus_salary <", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryLessThanOrEqualTo(Float value) {
            addCriterion("bus_salary <=", value, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryIn(List<Float> values) {
            addCriterion("bus_salary in", values, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryNotIn(List<Float> values) {
            addCriterion("bus_salary not in", values, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryBetween(Float value1, Float value2) {
            addCriterion("bus_salary between", value1, value2, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andBus_salaryNotBetween(Float value1, Float value2) {
            addCriterion("bus_salary not between", value1, value2, "bus_salary");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceIsNull() {
            addCriterion("traffic_allowance is null");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceIsNotNull() {
            addCriterion("traffic_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceEqualTo(Float value) {
            addCriterion("traffic_allowance =", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceNotEqualTo(Float value) {
            addCriterion("traffic_allowance <>", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceGreaterThan(Float value) {
            addCriterion("traffic_allowance >", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("traffic_allowance >=", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceLessThan(Float value) {
            addCriterion("traffic_allowance <", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("traffic_allowance <=", value, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceIn(List<Float> values) {
            addCriterion("traffic_allowance in", values, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceNotIn(List<Float> values) {
            addCriterion("traffic_allowance not in", values, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceBetween(Float value1, Float value2) {
            addCriterion("traffic_allowance between", value1, value2, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andTraffic_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("traffic_allowance not between", value1, value2, "traffic_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceIsNull() {
            addCriterion("gas_allowance is null");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceIsNotNull() {
            addCriterion("gas_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceEqualTo(Float value) {
            addCriterion("gas_allowance =", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceNotEqualTo(Float value) {
            addCriterion("gas_allowance <>", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceGreaterThan(Float value) {
            addCriterion("gas_allowance >", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("gas_allowance >=", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceLessThan(Float value) {
            addCriterion("gas_allowance <", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("gas_allowance <=", value, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceIn(List<Float> values) {
            addCriterion("gas_allowance in", values, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceNotIn(List<Float> values) {
            addCriterion("gas_allowance not in", values, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceBetween(Float value1, Float value2) {
            addCriterion("gas_allowance between", value1, value2, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andGas_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("gas_allowance not between", value1, value2, "gas_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceIsNull() {
            addCriterion("life_allowance is null");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceIsNotNull() {
            addCriterion("life_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceEqualTo(Float value) {
            addCriterion("life_allowance =", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceNotEqualTo(Float value) {
            addCriterion("life_allowance <>", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceGreaterThan(Float value) {
            addCriterion("life_allowance >", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("life_allowance >=", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceLessThan(Float value) {
            addCriterion("life_allowance <", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("life_allowance <=", value, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceIn(List<Float> values) {
            addCriterion("life_allowance in", values, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceNotIn(List<Float> values) {
            addCriterion("life_allowance not in", values, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceBetween(Float value1, Float value2) {
            addCriterion("life_allowance between", value1, value2, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andLife_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("life_allowance not between", value1, value2, "life_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceIsNull() {
            addCriterion("dinner_allowance is null");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceIsNotNull() {
            addCriterion("dinner_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceEqualTo(Float value) {
            addCriterion("dinner_allowance =", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceNotEqualTo(Float value) {
            addCriterion("dinner_allowance <>", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceGreaterThan(Float value) {
            addCriterion("dinner_allowance >", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("dinner_allowance >=", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceLessThan(Float value) {
            addCriterion("dinner_allowance <", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("dinner_allowance <=", value, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceIn(List<Float> values) {
            addCriterion("dinner_allowance in", values, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceNotIn(List<Float> values) {
            addCriterion("dinner_allowance not in", values, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceBetween(Float value1, Float value2) {
            addCriterion("dinner_allowance between", value1, value2, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andDinner_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("dinner_allowance not between", value1, value2, "dinner_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceIsNull() {
            addCriterion("proper_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceIsNotNull() {
            addCriterion("proper_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceEqualTo(Float value) {
            addCriterion("proper_allowance =", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceNotEqualTo(Float value) {
            addCriterion("proper_allowance <>", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceGreaterThan(Float value) {
            addCriterion("proper_allowance >", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("proper_allowance >=", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceLessThan(Float value) {
            addCriterion("proper_allowance <", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("proper_allowance <=", value, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceIn(List<Float> values) {
            addCriterion("proper_allowance in", values, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceNotIn(List<Float> values) {
            addCriterion("proper_allowance not in", values, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceBetween(Float value1, Float value2) {
            addCriterion("proper_allowance between", value1, value2, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andProper_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("proper_allowance not between", value1, value2, "proper_allowance");
            return (Criteria) this;
        }

        public Criteria andWash_feeIsNull() {
            addCriterion("wash_fee is null");
            return (Criteria) this;
        }

        public Criteria andWash_feeIsNotNull() {
            addCriterion("wash_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWash_feeEqualTo(Float value) {
            addCriterion("wash_fee =", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeNotEqualTo(Float value) {
            addCriterion("wash_fee <>", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeGreaterThan(Float value) {
            addCriterion("wash_fee >", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("wash_fee >=", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeLessThan(Float value) {
            addCriterion("wash_fee <", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeLessThanOrEqualTo(Float value) {
            addCriterion("wash_fee <=", value, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeIn(List<Float> values) {
            addCriterion("wash_fee in", values, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeNotIn(List<Float> values) {
            addCriterion("wash_fee not in", values, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeBetween(Float value1, Float value2) {
            addCriterion("wash_fee between", value1, value2, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andWash_feeNotBetween(Float value1, Float value2) {
            addCriterion("wash_fee not between", value1, value2, "wash_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeIsNull() {
            addCriterion("book_fee is null");
            return (Criteria) this;
        }

        public Criteria andBook_feeIsNotNull() {
            addCriterion("book_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBook_feeEqualTo(Float value) {
            addCriterion("book_fee =", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeNotEqualTo(Float value) {
            addCriterion("book_fee <>", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeGreaterThan(Float value) {
            addCriterion("book_fee >", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("book_fee >=", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeLessThan(Float value) {
            addCriterion("book_fee <", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeLessThanOrEqualTo(Float value) {
            addCriterion("book_fee <=", value, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeIn(List<Float> values) {
            addCriterion("book_fee in", values, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeNotIn(List<Float> values) {
            addCriterion("book_fee not in", values, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeBetween(Float value1, Float value2) {
            addCriterion("book_fee between", value1, value2, "book_fee");
            return (Criteria) this;
        }

        public Criteria andBook_feeNotBetween(Float value1, Float value2) {
            addCriterion("book_fee not between", value1, value2, "book_fee");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceIsNull() {
            addCriterion("profession_allowance is null");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceIsNotNull() {
            addCriterion("profession_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceEqualTo(Float value) {
            addCriterion("profession_allowance =", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceNotEqualTo(Float value) {
            addCriterion("profession_allowance <>", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceGreaterThan(Float value) {
            addCriterion("profession_allowance >", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("profession_allowance >=", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceLessThan(Float value) {
            addCriterion("profession_allowance <", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("profession_allowance <=", value, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceIn(List<Float> values) {
            addCriterion("profession_allowance in", values, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceNotIn(List<Float> values) {
            addCriterion("profession_allowance not in", values, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceBetween(Float value1, Float value2) {
            addCriterion("profession_allowance between", value1, value2, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andProfession_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("profession_allowance not between", value1, value2, "profession_allowance");
            return (Criteria) this;
        }

        public Criteria andLeft_awardIsNull() {
            addCriterion("left_award is null");
            return (Criteria) this;
        }

        public Criteria andLeft_awardIsNotNull() {
            addCriterion("left_award is not null");
            return (Criteria) this;
        }

        public Criteria andLeft_awardEqualTo(Float value) {
            addCriterion("left_award =", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardNotEqualTo(Float value) {
            addCriterion("left_award <>", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardGreaterThan(Float value) {
            addCriterion("left_award >", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardGreaterThanOrEqualTo(Float value) {
            addCriterion("left_award >=", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardLessThan(Float value) {
            addCriterion("left_award <", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardLessThanOrEqualTo(Float value) {
            addCriterion("left_award <=", value, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardIn(List<Float> values) {
            addCriterion("left_award in", values, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardNotIn(List<Float> values) {
            addCriterion("left_award not in", values, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardBetween(Float value1, Float value2) {
            addCriterion("left_award between", value1, value2, "left_award");
            return (Criteria) this;
        }

        public Criteria andLeft_awardNotBetween(Float value1, Float value2) {
            addCriterion("left_award not between", value1, value2, "left_award");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumIsNull() {
            addCriterion("allowance_sum is null");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumIsNotNull() {
            addCriterion("allowance_sum is not null");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumEqualTo(Float value) {
            addCriterion("allowance_sum =", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumNotEqualTo(Float value) {
            addCriterion("allowance_sum <>", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumGreaterThan(Float value) {
            addCriterion("allowance_sum >", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("allowance_sum >=", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumLessThan(Float value) {
            addCriterion("allowance_sum <", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumLessThanOrEqualTo(Float value) {
            addCriterion("allowance_sum <=", value, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumIn(List<Float> values) {
            addCriterion("allowance_sum in", values, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumNotIn(List<Float> values) {
            addCriterion("allowance_sum not in", values, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumBetween(Float value1, Float value2) {
            addCriterion("allowance_sum between", value1, value2, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andAllowance_sumNotBetween(Float value1, Float value2) {
            addCriterion("allowance_sum not between", value1, value2, "allowance_sum");
            return (Criteria) this;
        }

        public Criteria andCivi_awardIsNull() {
            addCriterion("civi_award is null");
            return (Criteria) this;
        }

        public Criteria andCivi_awardIsNotNull() {
            addCriterion("civi_award is not null");
            return (Criteria) this;
        }

        public Criteria andCivi_awardEqualTo(Float value) {
            addCriterion("civi_award =", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardNotEqualTo(Float value) {
            addCriterion("civi_award <>", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardGreaterThan(Float value) {
            addCriterion("civi_award >", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardGreaterThanOrEqualTo(Float value) {
            addCriterion("civi_award >=", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardLessThan(Float value) {
            addCriterion("civi_award <", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardLessThanOrEqualTo(Float value) {
            addCriterion("civi_award <=", value, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardIn(List<Float> values) {
            addCriterion("civi_award in", values, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardNotIn(List<Float> values) {
            addCriterion("civi_award not in", values, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardBetween(Float value1, Float value2) {
            addCriterion("civi_award between", value1, value2, "civi_award");
            return (Criteria) this;
        }

        public Criteria andCivi_awardNotBetween(Float value1, Float value2) {
            addCriterion("civi_award not between", value1, value2, "civi_award");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceIsNull() {
            addCriterion("energy_allowance is null");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceIsNotNull() {
            addCriterion("energy_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceEqualTo(Float value) {
            addCriterion("energy_allowance =", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceNotEqualTo(Float value) {
            addCriterion("energy_allowance <>", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceGreaterThan(Float value) {
            addCriterion("energy_allowance >", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("energy_allowance >=", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceLessThan(Float value) {
            addCriterion("energy_allowance <", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("energy_allowance <=", value, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceIn(List<Float> values) {
            addCriterion("energy_allowance in", values, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceNotIn(List<Float> values) {
            addCriterion("energy_allowance not in", values, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceBetween(Float value1, Float value2) {
            addCriterion("energy_allowance between", value1, value2, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andEnergy_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("energy_allowance not between", value1, value2, "energy_allowance");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeIsNull() {
            addCriterion("one_child_fee is null");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeIsNotNull() {
            addCriterion("one_child_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeEqualTo(Float value) {
            addCriterion("one_child_fee =", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeNotEqualTo(Float value) {
            addCriterion("one_child_fee <>", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeGreaterThan(Float value) {
            addCriterion("one_child_fee >", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("one_child_fee >=", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeLessThan(Float value) {
            addCriterion("one_child_fee <", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeLessThanOrEqualTo(Float value) {
            addCriterion("one_child_fee <=", value, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeIn(List<Float> values) {
            addCriterion("one_child_fee in", values, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeNotIn(List<Float> values) {
            addCriterion("one_child_fee not in", values, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeBetween(Float value1, Float value2) {
            addCriterion("one_child_fee between", value1, value2, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andOne_child_feeNotBetween(Float value1, Float value2) {
            addCriterion("one_child_fee not between", value1, value2, "one_child_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceIsNull() {
            addCriterion("house_allownace is null");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceIsNotNull() {
            addCriterion("house_allownace is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceEqualTo(Float value) {
            addCriterion("house_allownace =", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceNotEqualTo(Float value) {
            addCriterion("house_allownace <>", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceGreaterThan(Float value) {
            addCriterion("house_allownace >", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceGreaterThanOrEqualTo(Float value) {
            addCriterion("house_allownace >=", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceLessThan(Float value) {
            addCriterion("house_allownace <", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceLessThanOrEqualTo(Float value) {
            addCriterion("house_allownace <=", value, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceIn(List<Float> values) {
            addCriterion("house_allownace in", values, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceNotIn(List<Float> values) {
            addCriterion("house_allownace not in", values, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceBetween(Float value1, Float value2) {
            addCriterion("house_allownace between", value1, value2, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andHouse_allownaceNotBetween(Float value1, Float value2) {
            addCriterion("house_allownace not between", value1, value2, "house_allownace");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceIsNull() {
            addCriterion("pre_allowance is null");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceIsNotNull() {
            addCriterion("pre_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceEqualTo(Float value) {
            addCriterion("pre_allowance =", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceNotEqualTo(Float value) {
            addCriterion("pre_allowance <>", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceGreaterThan(Float value) {
            addCriterion("pre_allowance >", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("pre_allowance >=", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceLessThan(Float value) {
            addCriterion("pre_allowance <", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("pre_allowance <=", value, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceIn(List<Float> values) {
            addCriterion("pre_allowance in", values, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceNotIn(List<Float> values) {
            addCriterion("pre_allowance not in", values, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceBetween(Float value1, Float value2) {
            addCriterion("pre_allowance between", value1, value2, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andPre_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("pre_allowance not between", value1, value2, "pre_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceIsNull() {
            addCriterion("other_allowance is null");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceIsNotNull() {
            addCriterion("other_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceEqualTo(Float value) {
            addCriterion("other_allowance =", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceNotEqualTo(Float value) {
            addCriterion("other_allowance <>", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceGreaterThan(Float value) {
            addCriterion("other_allowance >", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("other_allowance >=", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceLessThan(Float value) {
            addCriterion("other_allowance <", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("other_allowance <=", value, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceIn(List<Float> values) {
            addCriterion("other_allowance in", values, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceNotIn(List<Float> values) {
            addCriterion("other_allowance not in", values, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceBetween(Float value1, Float value2) {
            addCriterion("other_allowance between", value1, value2, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andOther_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("other_allowance not between", value1, value2, "other_allowance");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumIsNull() {
            addCriterion("salary_little_sum is null");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumIsNotNull() {
            addCriterion("salary_little_sum is not null");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumEqualTo(Float value) {
            addCriterion("salary_little_sum =", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumNotEqualTo(Float value) {
            addCriterion("salary_little_sum <>", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumGreaterThan(Float value) {
            addCriterion("salary_little_sum >", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("salary_little_sum >=", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumLessThan(Float value) {
            addCriterion("salary_little_sum <", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumLessThanOrEqualTo(Float value) {
            addCriterion("salary_little_sum <=", value, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumIn(List<Float> values) {
            addCriterion("salary_little_sum in", values, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumNotIn(List<Float> values) {
            addCriterion("salary_little_sum not in", values, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumBetween(Float value1, Float value2) {
            addCriterion("salary_little_sum between", value1, value2, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_little_sumNotBetween(Float value1, Float value2) {
            addCriterion("salary_little_sum not between", value1, value2, "salary_little_sum");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceIsNull() {
            addCriterion("job_allowance is null");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceIsNotNull() {
            addCriterion("job_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceEqualTo(Float value) {
            addCriterion("job_allowance =", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceNotEqualTo(Float value) {
            addCriterion("job_allowance <>", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceGreaterThan(Float value) {
            addCriterion("job_allowance >", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("job_allowance >=", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceLessThan(Float value) {
            addCriterion("job_allowance <", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("job_allowance <=", value, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceIn(List<Float> values) {
            addCriterion("job_allowance in", values, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceNotIn(List<Float> values) {
            addCriterion("job_allowance not in", values, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceBetween(Float value1, Float value2) {
            addCriterion("job_allowance between", value1, value2, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andJob_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("job_allowance not between", value1, value2, "job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceIsNull() {
            addCriterion("re_job_allowance is null");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceIsNotNull() {
            addCriterion("re_job_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceEqualTo(Float value) {
            addCriterion("re_job_allowance =", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceNotEqualTo(Float value) {
            addCriterion("re_job_allowance <>", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceGreaterThan(Float value) {
            addCriterion("re_job_allowance >", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("re_job_allowance >=", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceLessThan(Float value) {
            addCriterion("re_job_allowance <", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("re_job_allowance <=", value, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceIn(List<Float> values) {
            addCriterion("re_job_allowance in", values, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceNotIn(List<Float> values) {
            addCriterion("re_job_allowance not in", values, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceBetween(Float value1, Float value2) {
            addCriterion("re_job_allowance between", value1, value2, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andRe_job_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("re_job_allowance not between", value1, value2, "re_job_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceIsNull() {
            addCriterion("oil_allowance is null");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceIsNotNull() {
            addCriterion("oil_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceEqualTo(Float value) {
            addCriterion("oil_allowance =", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceNotEqualTo(Float value) {
            addCriterion("oil_allowance <>", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceGreaterThan(Float value) {
            addCriterion("oil_allowance >", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("oil_allowance >=", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceLessThan(Float value) {
            addCriterion("oil_allowance <", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("oil_allowance <=", value, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceIn(List<Float> values) {
            addCriterion("oil_allowance in", values, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceNotIn(List<Float> values) {
            addCriterion("oil_allowance not in", values, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceBetween(Float value1, Float value2) {
            addCriterion("oil_allowance between", value1, value2, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andOil_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("oil_allowance not between", value1, value2, "oil_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceIsNull() {
            addCriterion("mobile_allowance is null");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceIsNotNull() {
            addCriterion("mobile_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceEqualTo(Float value) {
            addCriterion("mobile_allowance =", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceNotEqualTo(Float value) {
            addCriterion("mobile_allowance <>", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceGreaterThan(Float value) {
            addCriterion("mobile_allowance >", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("mobile_allowance >=", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceLessThan(Float value) {
            addCriterion("mobile_allowance <", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("mobile_allowance <=", value, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceIn(List<Float> values) {
            addCriterion("mobile_allowance in", values, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceNotIn(List<Float> values) {
            addCriterion("mobile_allowance not in", values, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceBetween(Float value1, Float value2) {
            addCriterion("mobile_allowance between", value1, value2, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andMobile_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("mobile_allowance not between", value1, value2, "mobile_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceIsNull() {
            addCriterion("buy_house_allowance is null");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceIsNotNull() {
            addCriterion("buy_house_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceEqualTo(Float value) {
            addCriterion("buy_house_allowance =", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceNotEqualTo(Float value) {
            addCriterion("buy_house_allowance <>", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceGreaterThan(Float value) {
            addCriterion("buy_house_allowance >", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("buy_house_allowance >=", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceLessThan(Float value) {
            addCriterion("buy_house_allowance <", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("buy_house_allowance <=", value, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceIn(List<Float> values) {
            addCriterion("buy_house_allowance in", values, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceNotIn(List<Float> values) {
            addCriterion("buy_house_allowance not in", values, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceBetween(Float value1, Float value2) {
            addCriterion("buy_house_allowance between", value1, value2, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andBuy_house_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("buy_house_allowance not between", value1, value2, "buy_house_allowance");
            return (Criteria) this;
        }

        public Criteria andSalary_sumIsNull() {
            addCriterion("salary_sum is null");
            return (Criteria) this;
        }

        public Criteria andSalary_sumIsNotNull() {
            addCriterion("salary_sum is not null");
            return (Criteria) this;
        }

        public Criteria andSalary_sumEqualTo(Float value) {
            addCriterion("salary_sum =", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumNotEqualTo(Float value) {
            addCriterion("salary_sum <>", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumGreaterThan(Float value) {
            addCriterion("salary_sum >", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("salary_sum >=", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumLessThan(Float value) {
            addCriterion("salary_sum <", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumLessThanOrEqualTo(Float value) {
            addCriterion("salary_sum <=", value, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumIn(List<Float> values) {
            addCriterion("salary_sum in", values, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumNotIn(List<Float> values) {
            addCriterion("salary_sum not in", values, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumBetween(Float value1, Float value2) {
            addCriterion("salary_sum between", value1, value2, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andSalary_sumNotBetween(Float value1, Float value2) {
            addCriterion("salary_sum not between", value1, value2, "salary_sum");
            return (Criteria) this;
        }

        public Criteria andHouse_feeIsNull() {
            addCriterion("house_fee is null");
            return (Criteria) this;
        }

        public Criteria andHouse_feeIsNotNull() {
            addCriterion("house_fee is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_feeEqualTo(Float value) {
            addCriterion("house_fee =", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeNotEqualTo(Float value) {
            addCriterion("house_fee <>", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeGreaterThan(Float value) {
            addCriterion("house_fee >", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("house_fee >=", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeLessThan(Float value) {
            addCriterion("house_fee <", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeLessThanOrEqualTo(Float value) {
            addCriterion("house_fee <=", value, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeIn(List<Float> values) {
            addCriterion("house_fee in", values, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeNotIn(List<Float> values) {
            addCriterion("house_fee not in", values, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeBetween(Float value1, Float value2) {
            addCriterion("house_fee between", value1, value2, "house_fee");
            return (Criteria) this;
        }

        public Criteria andHouse_feeNotBetween(Float value1, Float value2) {
            addCriterion("house_fee not between", value1, value2, "house_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeIsNull() {
            addCriterion("warm_fee is null");
            return (Criteria) this;
        }

        public Criteria andWarm_feeIsNotNull() {
            addCriterion("warm_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWarm_feeEqualTo(Float value) {
            addCriterion("warm_fee =", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeNotEqualTo(Float value) {
            addCriterion("warm_fee <>", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeGreaterThan(Float value) {
            addCriterion("warm_fee >", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("warm_fee >=", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeLessThan(Float value) {
            addCriterion("warm_fee <", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeLessThanOrEqualTo(Float value) {
            addCriterion("warm_fee <=", value, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeIn(List<Float> values) {
            addCriterion("warm_fee in", values, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeNotIn(List<Float> values) {
            addCriterion("warm_fee not in", values, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeBetween(Float value1, Float value2) {
            addCriterion("warm_fee between", value1, value2, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWarm_feeNotBetween(Float value1, Float value2) {
            addCriterion("warm_fee not between", value1, value2, "warm_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeIsNull() {
            addCriterion("water_fee is null");
            return (Criteria) this;
        }

        public Criteria andWater_feeIsNotNull() {
            addCriterion("water_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWater_feeEqualTo(Float value) {
            addCriterion("water_fee =", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeNotEqualTo(Float value) {
            addCriterion("water_fee <>", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeGreaterThan(Float value) {
            addCriterion("water_fee >", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("water_fee >=", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeLessThan(Float value) {
            addCriterion("water_fee <", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeLessThanOrEqualTo(Float value) {
            addCriterion("water_fee <=", value, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeIn(List<Float> values) {
            addCriterion("water_fee in", values, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeNotIn(List<Float> values) {
            addCriterion("water_fee not in", values, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeBetween(Float value1, Float value2) {
            addCriterion("water_fee between", value1, value2, "water_fee");
            return (Criteria) this;
        }

        public Criteria andWater_feeNotBetween(Float value1, Float value2) {
            addCriterion("water_fee not between", value1, value2, "water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeIsNull() {
            addCriterion("pure_water_fee is null");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeIsNotNull() {
            addCriterion("pure_water_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeEqualTo(Float value) {
            addCriterion("pure_water_fee =", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeNotEqualTo(Float value) {
            addCriterion("pure_water_fee <>", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeGreaterThan(Float value) {
            addCriterion("pure_water_fee >", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("pure_water_fee >=", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeLessThan(Float value) {
            addCriterion("pure_water_fee <", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeLessThanOrEqualTo(Float value) {
            addCriterion("pure_water_fee <=", value, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeIn(List<Float> values) {
            addCriterion("pure_water_fee in", values, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeNotIn(List<Float> values) {
            addCriterion("pure_water_fee not in", values, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeBetween(Float value1, Float value2) {
            addCriterion("pure_water_fee between", value1, value2, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andPure_water_feeNotBetween(Float value1, Float value2) {
            addCriterion("pure_water_fee not between", value1, value2, "pure_water_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeIsNull() {
            addCriterion("gas_fee is null");
            return (Criteria) this;
        }

        public Criteria andGas_feeIsNotNull() {
            addCriterion("gas_fee is not null");
            return (Criteria) this;
        }

        public Criteria andGas_feeEqualTo(Float value) {
            addCriterion("gas_fee =", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeNotEqualTo(Float value) {
            addCriterion("gas_fee <>", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeGreaterThan(Float value) {
            addCriterion("gas_fee >", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("gas_fee >=", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeLessThan(Float value) {
            addCriterion("gas_fee <", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeLessThanOrEqualTo(Float value) {
            addCriterion("gas_fee <=", value, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeIn(List<Float> values) {
            addCriterion("gas_fee in", values, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeNotIn(List<Float> values) {
            addCriterion("gas_fee not in", values, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeBetween(Float value1, Float value2) {
            addCriterion("gas_fee between", value1, value2, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andGas_feeNotBetween(Float value1, Float value2) {
            addCriterion("gas_fee not between", value1, value2, "gas_fee");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceIsNull() {
            addCriterion("endowment_insurance is null");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceIsNotNull() {
            addCriterion("endowment_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceEqualTo(Float value) {
            addCriterion("endowment_insurance =", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceNotEqualTo(Float value) {
            addCriterion("endowment_insurance <>", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceGreaterThan(Float value) {
            addCriterion("endowment_insurance >", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("endowment_insurance >=", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceLessThan(Float value) {
            addCriterion("endowment_insurance <", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceLessThanOrEqualTo(Float value) {
            addCriterion("endowment_insurance <=", value, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceIn(List<Float> values) {
            addCriterion("endowment_insurance in", values, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceNotIn(List<Float> values) {
            addCriterion("endowment_insurance not in", values, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceBetween(Float value1, Float value2) {
            addCriterion("endowment_insurance between", value1, value2, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andEndowment_insuranceNotBetween(Float value1, Float value2) {
            addCriterion("endowment_insurance not between", value1, value2, "endowment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceIsNull() {
            addCriterion("unemployment_insurance is null");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceIsNotNull() {
            addCriterion("unemployment_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceEqualTo(Float value) {
            addCriterion("unemployment_insurance =", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceNotEqualTo(Float value) {
            addCriterion("unemployment_insurance <>", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceGreaterThan(Float value) {
            addCriterion("unemployment_insurance >", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("unemployment_insurance >=", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceLessThan(Float value) {
            addCriterion("unemployment_insurance <", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceLessThanOrEqualTo(Float value) {
            addCriterion("unemployment_insurance <=", value, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceIn(List<Float> values) {
            addCriterion("unemployment_insurance in", values, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceNotIn(List<Float> values) {
            addCriterion("unemployment_insurance not in", values, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceBetween(Float value1, Float value2) {
            addCriterion("unemployment_insurance between", value1, value2, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andUnemployment_insuranceNotBetween(Float value1, Float value2) {
            addCriterion("unemployment_insurance not between", value1, value2, "unemployment_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceIsNull() {
            addCriterion("medical_insurance is null");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceIsNotNull() {
            addCriterion("medical_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceEqualTo(Float value) {
            addCriterion("medical_insurance =", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceNotEqualTo(Float value) {
            addCriterion("medical_insurance <>", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceGreaterThan(Float value) {
            addCriterion("medical_insurance >", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("medical_insurance >=", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceLessThan(Float value) {
            addCriterion("medical_insurance <", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceLessThanOrEqualTo(Float value) {
            addCriterion("medical_insurance <=", value, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceIn(List<Float> values) {
            addCriterion("medical_insurance in", values, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceNotIn(List<Float> values) {
            addCriterion("medical_insurance not in", values, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceBetween(Float value1, Float value2) {
            addCriterion("medical_insurance between", value1, value2, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andMedical_insuranceNotBetween(Float value1, Float value2) {
            addCriterion("medical_insurance not between", value1, value2, "medical_insurance");
            return (Criteria) this;
        }

        public Criteria andHouse_fundIsNull() {
            addCriterion("house_fund is null");
            return (Criteria) this;
        }

        public Criteria andHouse_fundIsNotNull() {
            addCriterion("house_fund is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_fundEqualTo(Float value) {
            addCriterion("house_fund =", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundNotEqualTo(Float value) {
            addCriterion("house_fund <>", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundGreaterThan(Float value) {
            addCriterion("house_fund >", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundGreaterThanOrEqualTo(Float value) {
            addCriterion("house_fund >=", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundLessThan(Float value) {
            addCriterion("house_fund <", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundLessThanOrEqualTo(Float value) {
            addCriterion("house_fund <=", value, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundIn(List<Float> values) {
            addCriterion("house_fund in", values, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundNotIn(List<Float> values) {
            addCriterion("house_fund not in", values, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundBetween(Float value1, Float value2) {
            addCriterion("house_fund between", value1, value2, "house_fund");
            return (Criteria) this;
        }

        public Criteria andHouse_fundNotBetween(Float value1, Float value2) {
            addCriterion("house_fund not between", value1, value2, "house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundIsNull() {
            addCriterion("re_house_fund is null");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundIsNotNull() {
            addCriterion("re_house_fund is not null");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundEqualTo(Float value) {
            addCriterion("re_house_fund =", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundNotEqualTo(Float value) {
            addCriterion("re_house_fund <>", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundGreaterThan(Float value) {
            addCriterion("re_house_fund >", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundGreaterThanOrEqualTo(Float value) {
            addCriterion("re_house_fund >=", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundLessThan(Float value) {
            addCriterion("re_house_fund <", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundLessThanOrEqualTo(Float value) {
            addCriterion("re_house_fund <=", value, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundIn(List<Float> values) {
            addCriterion("re_house_fund in", values, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundNotIn(List<Float> values) {
            addCriterion("re_house_fund not in", values, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundBetween(Float value1, Float value2) {
            addCriterion("re_house_fund between", value1, value2, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andRe_house_fundNotBetween(Float value1, Float value2) {
            addCriterion("re_house_fund not between", value1, value2, "re_house_fund");
            return (Criteria) this;
        }

        public Criteria andLoan_feeIsNull() {
            addCriterion("loan_fee is null");
            return (Criteria) this;
        }

        public Criteria andLoan_feeIsNotNull() {
            addCriterion("loan_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLoan_feeEqualTo(Float value) {
            addCriterion("loan_fee =", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeNotEqualTo(Float value) {
            addCriterion("loan_fee <>", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeGreaterThan(Float value) {
            addCriterion("loan_fee >", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("loan_fee >=", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeLessThan(Float value) {
            addCriterion("loan_fee <", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeLessThanOrEqualTo(Float value) {
            addCriterion("loan_fee <=", value, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeIn(List<Float> values) {
            addCriterion("loan_fee in", values, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeNotIn(List<Float> values) {
            addCriterion("loan_fee not in", values, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeBetween(Float value1, Float value2) {
            addCriterion("loan_fee between", value1, value2, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andLoan_feeNotBetween(Float value1, Float value2) {
            addCriterion("loan_fee not between", value1, value2, "loan_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeIsNull() {
            addCriterion("tax_fee is null");
            return (Criteria) this;
        }

        public Criteria andTax_feeIsNotNull() {
            addCriterion("tax_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTax_feeEqualTo(Float value) {
            addCriterion("tax_fee =", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeNotEqualTo(Float value) {
            addCriterion("tax_fee <>", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeGreaterThan(Float value) {
            addCriterion("tax_fee >", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("tax_fee >=", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeLessThan(Float value) {
            addCriterion("tax_fee <", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeLessThanOrEqualTo(Float value) {
            addCriterion("tax_fee <=", value, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeIn(List<Float> values) {
            addCriterion("tax_fee in", values, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeNotIn(List<Float> values) {
            addCriterion("tax_fee not in", values, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeBetween(Float value1, Float value2) {
            addCriterion("tax_fee between", value1, value2, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andTax_feeNotBetween(Float value1, Float value2) {
            addCriterion("tax_fee not between", value1, value2, "tax_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeIsNull() {
            addCriterion("kmq_fee is null");
            return (Criteria) this;
        }

        public Criteria andKmq_feeIsNotNull() {
            addCriterion("kmq_fee is not null");
            return (Criteria) this;
        }

        public Criteria andKmq_feeEqualTo(Float value) {
            addCriterion("kmq_fee =", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeNotEqualTo(Float value) {
            addCriterion("kmq_fee <>", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeGreaterThan(Float value) {
            addCriterion("kmq_fee >", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("kmq_fee >=", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeLessThan(Float value) {
            addCriterion("kmq_fee <", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeLessThanOrEqualTo(Float value) {
            addCriterion("kmq_fee <=", value, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeIn(List<Float> values) {
            addCriterion("kmq_fee in", values, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeNotIn(List<Float> values) {
            addCriterion("kmq_fee not in", values, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeBetween(Float value1, Float value2) {
            addCriterion("kmq_fee between", value1, value2, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKmq_feeNotBetween(Float value1, Float value2) {
            addCriterion("kmq_fee not between", value1, value2, "kmq_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeIsNull() {
            addCriterion("kds_fee is null");
            return (Criteria) this;
        }

        public Criteria andKds_feeIsNotNull() {
            addCriterion("kds_fee is not null");
            return (Criteria) this;
        }

        public Criteria andKds_feeEqualTo(Float value) {
            addCriterion("kds_fee =", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeNotEqualTo(Float value) {
            addCriterion("kds_fee <>", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeGreaterThan(Float value) {
            addCriterion("kds_fee >", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("kds_fee >=", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeLessThan(Float value) {
            addCriterion("kds_fee <", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeLessThanOrEqualTo(Float value) {
            addCriterion("kds_fee <=", value, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeIn(List<Float> values) {
            addCriterion("kds_fee in", values, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeNotIn(List<Float> values) {
            addCriterion("kds_fee not in", values, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeBetween(Float value1, Float value2) {
            addCriterion("kds_fee between", value1, value2, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andKds_feeNotBetween(Float value1, Float value2) {
            addCriterion("kds_fee not between", value1, value2, "kds_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeIsNull() {
            addCriterion("other_fee is null");
            return (Criteria) this;
        }

        public Criteria andOther_feeIsNotNull() {
            addCriterion("other_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOther_feeEqualTo(Float value) {
            addCriterion("other_fee =", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeNotEqualTo(Float value) {
            addCriterion("other_fee <>", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeGreaterThan(Float value) {
            addCriterion("other_fee >", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeGreaterThanOrEqualTo(Float value) {
            addCriterion("other_fee >=", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeLessThan(Float value) {
            addCriterion("other_fee <", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeLessThanOrEqualTo(Float value) {
            addCriterion("other_fee <=", value, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeIn(List<Float> values) {
            addCriterion("other_fee in", values, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeNotIn(List<Float> values) {
            addCriterion("other_fee not in", values, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeBetween(Float value1, Float value2) {
            addCriterion("other_fee between", value1, value2, "other_fee");
            return (Criteria) this;
        }

        public Criteria andOther_feeNotBetween(Float value1, Float value2) {
            addCriterion("other_fee not between", value1, value2, "other_fee");
            return (Criteria) this;
        }

        public Criteria andKk_sumIsNull() {
            addCriterion("kk_sum is null");
            return (Criteria) this;
        }

        public Criteria andKk_sumIsNotNull() {
            addCriterion("kk_sum is not null");
            return (Criteria) this;
        }

        public Criteria andKk_sumEqualTo(Float value) {
            addCriterion("kk_sum =", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumNotEqualTo(Float value) {
            addCriterion("kk_sum <>", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumGreaterThan(Float value) {
            addCriterion("kk_sum >", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("kk_sum >=", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumLessThan(Float value) {
            addCriterion("kk_sum <", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumLessThanOrEqualTo(Float value) {
            addCriterion("kk_sum <=", value, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumIn(List<Float> values) {
            addCriterion("kk_sum in", values, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumNotIn(List<Float> values) {
            addCriterion("kk_sum not in", values, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumBetween(Float value1, Float value2) {
            addCriterion("kk_sum between", value1, value2, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andKk_sumNotBetween(Float value1, Float value2) {
            addCriterion("kk_sum not between", value1, value2, "kk_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumIsNull() {
            addCriterion("real_salary_sum is null");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumIsNotNull() {
            addCriterion("real_salary_sum is not null");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumEqualTo(Float value) {
            addCriterion("real_salary_sum =", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumNotEqualTo(Float value) {
            addCriterion("real_salary_sum <>", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumGreaterThan(Float value) {
            addCriterion("real_salary_sum >", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("real_salary_sum >=", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumLessThan(Float value) {
            addCriterion("real_salary_sum <", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumLessThanOrEqualTo(Float value) {
            addCriterion("real_salary_sum <=", value, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumIn(List<Float> values) {
            addCriterion("real_salary_sum in", values, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumNotIn(List<Float> values) {
            addCriterion("real_salary_sum not in", values, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumBetween(Float value1, Float value2) {
            addCriterion("real_salary_sum between", value1, value2, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andReal_salary_sumNotBetween(Float value1, Float value2) {
            addCriterion("real_salary_sum not between", value1, value2, "real_salary_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumIsNull() {
            addCriterion("tax_sum is null");
            return (Criteria) this;
        }

        public Criteria andTax_sumIsNotNull() {
            addCriterion("tax_sum is not null");
            return (Criteria) this;
        }

        public Criteria andTax_sumEqualTo(Float value) {
            addCriterion("tax_sum =", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumNotEqualTo(Float value) {
            addCriterion("tax_sum <>", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumGreaterThan(Float value) {
            addCriterion("tax_sum >", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumGreaterThanOrEqualTo(Float value) {
            addCriterion("tax_sum >=", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumLessThan(Float value) {
            addCriterion("tax_sum <", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumLessThanOrEqualTo(Float value) {
            addCriterion("tax_sum <=", value, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumIn(List<Float> values) {
            addCriterion("tax_sum in", values, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumNotIn(List<Float> values) {
            addCriterion("tax_sum not in", values, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumBetween(Float value1, Float value2) {
            addCriterion("tax_sum between", value1, value2, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andTax_sumNotBetween(Float value1, Float value2) {
            addCriterion("tax_sum not between", value1, value2, "tax_sum");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceIsNull() {
            addCriterion("fx_allowance is null");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceIsNotNull() {
            addCriterion("fx_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceEqualTo(Float value) {
            addCriterion("fx_allowance =", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceNotEqualTo(Float value) {
            addCriterion("fx_allowance <>", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceGreaterThan(Float value) {
            addCriterion("fx_allowance >", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("fx_allowance >=", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceLessThan(Float value) {
            addCriterion("fx_allowance <", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("fx_allowance <=", value, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceIn(List<Float> values) {
            addCriterion("fx_allowance in", values, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceNotIn(List<Float> values) {
            addCriterion("fx_allowance not in", values, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceBetween(Float value1, Float value2) {
            addCriterion("fx_allowance between", value1, value2, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andFx_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("fx_allowance not between", value1, value2, "fx_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceIsNull() {
            addCriterion("yd_allowance is null");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceIsNotNull() {
            addCriterion("yd_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceEqualTo(Float value) {
            addCriterion("yd_allowance =", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceNotEqualTo(Float value) {
            addCriterion("yd_allowance <>", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceGreaterThan(Float value) {
            addCriterion("yd_allowance >", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("yd_allowance >=", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceLessThan(Float value) {
            addCriterion("yd_allowance <", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceLessThanOrEqualTo(Float value) {
            addCriterion("yd_allowance <=", value, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceIn(List<Float> values) {
            addCriterion("yd_allowance in", values, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceNotIn(List<Float> values) {
            addCriterion("yd_allowance not in", values, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceBetween(Float value1, Float value2) {
            addCriterion("yd_allowance between", value1, value2, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andYd_allowanceNotBetween(Float value1, Float value2) {
            addCriterion("yd_allowance not between", value1, value2, "yd_allowance");
            return (Criteria) this;
        }

        public Criteria andGqzqIsNull() {
            addCriterion("gqzq is null");
            return (Criteria) this;
        }

        public Criteria andGqzqIsNotNull() {
            addCriterion("gqzq is not null");
            return (Criteria) this;
        }

        public Criteria andGqzqEqualTo(Float value) {
            addCriterion("gqzq =", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqNotEqualTo(Float value) {
            addCriterion("gqzq <>", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqGreaterThan(Float value) {
            addCriterion("gqzq >", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqGreaterThanOrEqualTo(Float value) {
            addCriterion("gqzq >=", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqLessThan(Float value) {
            addCriterion("gqzq <", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqLessThanOrEqualTo(Float value) {
            addCriterion("gqzq <=", value, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqIn(List<Float> values) {
            addCriterion("gqzq in", values, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqNotIn(List<Float> values) {
            addCriterion("gqzq not in", values, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqBetween(Float value1, Float value2) {
            addCriterion("gqzq between", value1, value2, "gqzq");
            return (Criteria) this;
        }

        public Criteria andGqzqNotBetween(Float value1, Float value2) {
            addCriterion("gqzq not between", value1, value2, "gqzq");
            return (Criteria) this;
        }

        public Criteria andSj_awardIsNull() {
            addCriterion("sj_award is null");
            return (Criteria) this;
        }

        public Criteria andSj_awardIsNotNull() {
            addCriterion("sj_award is not null");
            return (Criteria) this;
        }

        public Criteria andSj_awardEqualTo(Float value) {
            addCriterion("sj_award =", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardNotEqualTo(Float value) {
            addCriterion("sj_award <>", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardGreaterThan(Float value) {
            addCriterion("sj_award >", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardGreaterThanOrEqualTo(Float value) {
            addCriterion("sj_award >=", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardLessThan(Float value) {
            addCriterion("sj_award <", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardLessThanOrEqualTo(Float value) {
            addCriterion("sj_award <=", value, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardIn(List<Float> values) {
            addCriterion("sj_award in", values, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardNotIn(List<Float> values) {
            addCriterion("sj_award not in", values, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardBetween(Float value1, Float value2) {
            addCriterion("sj_award between", value1, value2, "sj_award");
            return (Criteria) this;
        }

        public Criteria andSj_awardNotBetween(Float value1, Float value2) {
            addCriterion("sj_award not between", value1, value2, "sj_award");
            return (Criteria) this;
        }

        public Criteria andZfygyzgIsNull() {
            addCriterion("zfygyzg is null");
            return (Criteria) this;
        }

        public Criteria andZfygyzgIsNotNull() {
            addCriterion("zfygyzg is not null");
            return (Criteria) this;
        }

        public Criteria andZfygyzgEqualTo(Float value) {
            addCriterion("zfygyzg =", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgNotEqualTo(Float value) {
            addCriterion("zfygyzg <>", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgGreaterThan(Float value) {
            addCriterion("zfygyzg >", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgGreaterThanOrEqualTo(Float value) {
            addCriterion("zfygyzg >=", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgLessThan(Float value) {
            addCriterion("zfygyzg <", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgLessThanOrEqualTo(Float value) {
            addCriterion("zfygyzg <=", value, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgIn(List<Float> values) {
            addCriterion("zfygyzg in", values, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgNotIn(List<Float> values) {
            addCriterion("zfygyzg not in", values, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgBetween(Float value1, Float value2) {
            addCriterion("zfygyzg between", value1, value2, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andZfygyzgNotBetween(Float value1, Float value2) {
            addCriterion("zfygyzg not between", value1, value2, "zfygyzg");
            return (Criteria) this;
        }

        public Criteria andCqjIsNull() {
            addCriterion("cqj is null");
            return (Criteria) this;
        }

        public Criteria andCqjIsNotNull() {
            addCriterion("cqj is not null");
            return (Criteria) this;
        }

        public Criteria andCqjEqualTo(Float value) {
            addCriterion("cqj =", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjNotEqualTo(Float value) {
            addCriterion("cqj <>", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjGreaterThan(Float value) {
            addCriterion("cqj >", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjGreaterThanOrEqualTo(Float value) {
            addCriterion("cqj >=", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjLessThan(Float value) {
            addCriterion("cqj <", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjLessThanOrEqualTo(Float value) {
            addCriterion("cqj <=", value, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjIn(List<Float> values) {
            addCriterion("cqj in", values, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjNotIn(List<Float> values) {
            addCriterion("cqj not in", values, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjBetween(Float value1, Float value2) {
            addCriterion("cqj between", value1, value2, "cqj");
            return (Criteria) this;
        }

        public Criteria andCqjNotBetween(Float value1, Float value2) {
            addCriterion("cqj not between", value1, value2, "cqj");
            return (Criteria) this;
        }

        public Criteria andJxjIsNull() {
            addCriterion("jxj is null");
            return (Criteria) this;
        }

        public Criteria andJxjIsNotNull() {
            addCriterion("jxj is not null");
            return (Criteria) this;
        }

        public Criteria andJxjEqualTo(Float value) {
            addCriterion("jxj =", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotEqualTo(Float value) {
            addCriterion("jxj <>", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjGreaterThan(Float value) {
            addCriterion("jxj >", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjGreaterThanOrEqualTo(Float value) {
            addCriterion("jxj >=", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjLessThan(Float value) {
            addCriterion("jxj <", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjLessThanOrEqualTo(Float value) {
            addCriterion("jxj <=", value, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjIn(List<Float> values) {
            addCriterion("jxj in", values, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotIn(List<Float> values) {
            addCriterion("jxj not in", values, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjBetween(Float value1, Float value2) {
            addCriterion("jxj between", value1, value2, "jxj");
            return (Criteria) this;
        }

        public Criteria andJxjNotBetween(Float value1, Float value2) {
            addCriterion("jxj not between", value1, value2, "jxj");
            return (Criteria) this;
        }

        public Criteria andJwfIsNull() {
            addCriterion("jwf is null");
            return (Criteria) this;
        }

        public Criteria andJwfIsNotNull() {
            addCriterion("jwf is not null");
            return (Criteria) this;
        }

        public Criteria andJwfEqualTo(Float value) {
            addCriterion("jwf =", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfNotEqualTo(Float value) {
            addCriterion("jwf <>", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfGreaterThan(Float value) {
            addCriterion("jwf >", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfGreaterThanOrEqualTo(Float value) {
            addCriterion("jwf >=", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfLessThan(Float value) {
            addCriterion("jwf <", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfLessThanOrEqualTo(Float value) {
            addCriterion("jwf <=", value, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfIn(List<Float> values) {
            addCriterion("jwf in", values, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfNotIn(List<Float> values) {
            addCriterion("jwf not in", values, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfBetween(Float value1, Float value2) {
            addCriterion("jwf between", value1, value2, "jwf");
            return (Criteria) this;
        }

        public Criteria andJwfNotBetween(Float value1, Float value2) {
            addCriterion("jwf not between", value1, value2, "jwf");
            return (Criteria) this;
        }

        public Criteria andGwbtIsNull() {
            addCriterion("gwbt is null");
            return (Criteria) this;
        }

        public Criteria andGwbtIsNotNull() {
            addCriterion("gwbt is not null");
            return (Criteria) this;
        }

        public Criteria andGwbtEqualTo(Float value) {
            addCriterion("gwbt =", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtNotEqualTo(Float value) {
            addCriterion("gwbt <>", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtGreaterThan(Float value) {
            addCriterion("gwbt >", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtGreaterThanOrEqualTo(Float value) {
            addCriterion("gwbt >=", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtLessThan(Float value) {
            addCriterion("gwbt <", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtLessThanOrEqualTo(Float value) {
            addCriterion("gwbt <=", value, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtIn(List<Float> values) {
            addCriterion("gwbt in", values, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtNotIn(List<Float> values) {
            addCriterion("gwbt not in", values, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtBetween(Float value1, Float value2) {
            addCriterion("gwbt between", value1, value2, "gwbt");
            return (Criteria) this;
        }

        public Criteria andGwbtNotBetween(Float value1, Float value2) {
            addCriterion("gwbt not between", value1, value2, "gwbt");
            return (Criteria) this;
        }

        public Criteria andDhbIsNull() {
            addCriterion("dhb is null");
            return (Criteria) this;
        }

        public Criteria andDhbIsNotNull() {
            addCriterion("dhb is not null");
            return (Criteria) this;
        }

        public Criteria andDhbEqualTo(Float value) {
            addCriterion("dhb =", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbNotEqualTo(Float value) {
            addCriterion("dhb <>", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbGreaterThan(Float value) {
            addCriterion("dhb >", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbGreaterThanOrEqualTo(Float value) {
            addCriterion("dhb >=", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbLessThan(Float value) {
            addCriterion("dhb <", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbLessThanOrEqualTo(Float value) {
            addCriterion("dhb <=", value, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbIn(List<Float> values) {
            addCriterion("dhb in", values, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbNotIn(List<Float> values) {
            addCriterion("dhb not in", values, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbBetween(Float value1, Float value2) {
            addCriterion("dhb between", value1, value2, "dhb");
            return (Criteria) this;
        }

        public Criteria andDhbNotBetween(Float value1, Float value2) {
            addCriterion("dhb not between", value1, value2, "dhb");
            return (Criteria) this;
        }

        public Criteria andBjrcjtIsNull() {
            addCriterion("bjrcjt is null");
            return (Criteria) this;
        }

        public Criteria andBjrcjtIsNotNull() {
            addCriterion("bjrcjt is not null");
            return (Criteria) this;
        }

        public Criteria andBjrcjtEqualTo(Float value) {
            addCriterion("bjrcjt =", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtNotEqualTo(Float value) {
            addCriterion("bjrcjt <>", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtGreaterThan(Float value) {
            addCriterion("bjrcjt >", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtGreaterThanOrEqualTo(Float value) {
            addCriterion("bjrcjt >=", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtLessThan(Float value) {
            addCriterion("bjrcjt <", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtLessThanOrEqualTo(Float value) {
            addCriterion("bjrcjt <=", value, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtIn(List<Float> values) {
            addCriterion("bjrcjt in", values, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtNotIn(List<Float> values) {
            addCriterion("bjrcjt not in", values, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtBetween(Float value1, Float value2) {
            addCriterion("bjrcjt between", value1, value2, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andBjrcjtNotBetween(Float value1, Float value2) {
            addCriterion("bjrcjt not between", value1, value2, "bjrcjt");
            return (Criteria) this;
        }

        public Criteria andMbkhjIsNull() {
            addCriterion("mbkhj is null");
            return (Criteria) this;
        }

        public Criteria andMbkhjIsNotNull() {
            addCriterion("mbkhj is not null");
            return (Criteria) this;
        }

        public Criteria andMbkhjEqualTo(Float value) {
            addCriterion("mbkhj =", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjNotEqualTo(Float value) {
            addCriterion("mbkhj <>", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjGreaterThan(Float value) {
            addCriterion("mbkhj >", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjGreaterThanOrEqualTo(Float value) {
            addCriterion("mbkhj >=", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjLessThan(Float value) {
            addCriterion("mbkhj <", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjLessThanOrEqualTo(Float value) {
            addCriterion("mbkhj <=", value, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjIn(List<Float> values) {
            addCriterion("mbkhj in", values, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjNotIn(List<Float> values) {
            addCriterion("mbkhj not in", values, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjBetween(Float value1, Float value2) {
            addCriterion("mbkhj between", value1, value2, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andMbkhjNotBetween(Float value1, Float value2) {
            addCriterion("mbkhj not between", value1, value2, "mbkhj");
            return (Criteria) this;
        }

        public Criteria andOther6IsNull() {
            addCriterion("other6 is null");
            return (Criteria) this;
        }

        public Criteria andOther6IsNotNull() {
            addCriterion("other6 is not null");
            return (Criteria) this;
        }

        public Criteria andOther6EqualTo(Float value) {
            addCriterion("other6 =", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotEqualTo(Float value) {
            addCriterion("other6 <>", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6GreaterThan(Float value) {
            addCriterion("other6 >", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6GreaterThanOrEqualTo(Float value) {
            addCriterion("other6 >=", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6LessThan(Float value) {
            addCriterion("other6 <", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6LessThanOrEqualTo(Float value) {
            addCriterion("other6 <=", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6In(List<Float> values) {
            addCriterion("other6 in", values, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotIn(List<Float> values) {
            addCriterion("other6 not in", values, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6Between(Float value1, Float value2) {
            addCriterion("other6 between", value1, value2, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotBetween(Float value1, Float value2) {
            addCriterion("other6 not between", value1, value2, "other6");
            return (Criteria) this;
        }

        public Criteria andOther5IsNull() {
            addCriterion("other5 is null");
            return (Criteria) this;
        }

        public Criteria andOther5IsNotNull() {
            addCriterion("other5 is not null");
            return (Criteria) this;
        }

        public Criteria andOther5EqualTo(Float value) {
            addCriterion("other5 =", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotEqualTo(Float value) {
            addCriterion("other5 <>", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThan(Float value) {
            addCriterion("other5 >", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThanOrEqualTo(Float value) {
            addCriterion("other5 >=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThan(Float value) {
            addCriterion("other5 <", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThanOrEqualTo(Float value) {
            addCriterion("other5 <=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5In(List<Float> values) {
            addCriterion("other5 in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotIn(List<Float> values) {
            addCriterion("other5 not in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5Between(Float value1, Float value2) {
            addCriterion("other5 between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotBetween(Float value1, Float value2) {
            addCriterion("other5 not between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andOther4IsNull() {
            addCriterion("other4 is null");
            return (Criteria) this;
        }

        public Criteria andOther4IsNotNull() {
            addCriterion("other4 is not null");
            return (Criteria) this;
        }

        public Criteria andOther4EqualTo(Float value) {
            addCriterion("other4 =", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotEqualTo(Float value) {
            addCriterion("other4 <>", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThan(Float value) {
            addCriterion("other4 >", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThanOrEqualTo(Float value) {
            addCriterion("other4 >=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThan(Float value) {
            addCriterion("other4 <", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThanOrEqualTo(Float value) {
            addCriterion("other4 <=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4In(List<Float> values) {
            addCriterion("other4 in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotIn(List<Float> values) {
            addCriterion("other4 not in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Between(Float value1, Float value2) {
            addCriterion("other4 between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotBetween(Float value1, Float value2) {
            addCriterion("other4 not between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther3IsNull() {
            addCriterion("other3 is null");
            return (Criteria) this;
        }

        public Criteria andOther3IsNotNull() {
            addCriterion("other3 is not null");
            return (Criteria) this;
        }

        public Criteria andOther3EqualTo(Float value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(Float value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(Float value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(Float value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(Float value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(Float value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<Float> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<Float> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(Float value1, Float value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(Float value1, Float value2) {
            addCriterion("other3 not between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(Float value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(Float value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(Float value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(Float value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(Float value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(Float value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<Float> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<Float> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(Float value1, Float value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(Float value1, Float value2) {
            addCriterion("other2 not between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(Float value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(Float value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(Float value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(Float value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(Float value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(Float value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<Float> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<Float> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(Float value1, Float value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(Float value1, Float value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIn(List<Date> values) {
            addCriterion("create_date in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andOper_user_idIsNull() {
            addCriterion("oper_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOper_user_idIsNotNull() {
            addCriterion("oper_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOper_user_idEqualTo(String value) {
            addCriterion("oper_user_id =", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idNotEqualTo(String value) {
            addCriterion("oper_user_id <>", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idGreaterThan(String value) {
            addCriterion("oper_user_id >", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idGreaterThanOrEqualTo(String value) {
            addCriterion("oper_user_id >=", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idLessThan(String value) {
            addCriterion("oper_user_id <", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idLessThanOrEqualTo(String value) {
            addCriterion("oper_user_id <=", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idLike(String value) {
            addCriterion("oper_user_id like", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idNotLike(String value) {
            addCriterion("oper_user_id not like", value, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idIn(List<String> values) {
            addCriterion("oper_user_id in", values, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idNotIn(List<String> values) {
            addCriterion("oper_user_id not in", values, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idBetween(String value1, String value2) {
            addCriterion("oper_user_id between", value1, value2, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andOper_user_idNotBetween(String value1, String value2) {
            addCriterion("oper_user_id not between", value1, value2, "oper_user_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatch_idIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatch_idEqualTo(String value) {
            addCriterion("batch_id =", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idGreaterThan(String value) {
            addCriterion("batch_id >", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLessThan(String value) {
            addCriterion("batch_id <", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idLike(String value) {
            addCriterion("batch_id like", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotLike(String value) {
            addCriterion("batch_id not like", value, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idIn(List<String> values) {
            addCriterion("batch_id in", values, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batch_id");
            return (Criteria) this;
        }

        public Criteria andBatch_idNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batch_id");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}