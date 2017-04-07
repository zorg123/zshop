package com.flyrui.dao.pojo.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbNoticeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbNoticeCriteria() {
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

        public Criteria andNotice_idIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNotice_idIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotice_idEqualTo(Integer value) {
            addCriterion("notice_id =", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idNotEqualTo(Integer value) {
            addCriterion("notice_id <>", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idGreaterThan(Integer value) {
            addCriterion("notice_id >", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_id >=", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idLessThan(Integer value) {
            addCriterion("notice_id <", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idLessThanOrEqualTo(Integer value) {
            addCriterion("notice_id <=", value, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idIn(List<Integer> values) {
            addCriterion("notice_id in", values, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idNotIn(List<Integer> values) {
            addCriterion("notice_id not in", values, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idBetween(Integer value1, Integer value2) {
            addCriterion("notice_id between", value1, value2, "notice_id");
            return (Criteria) this;
        }

        public Criteria andNotice_idNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_id not between", value1, value2, "notice_id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContent_idIsNull() {
            addCriterion("content_id is null");
            return (Criteria) this;
        }

        public Criteria andContent_idIsNotNull() {
            addCriterion("content_id is not null");
            return (Criteria) this;
        }

        public Criteria andContent_idEqualTo(Integer value) {
            addCriterion("content_id =", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idNotEqualTo(Integer value) {
            addCriterion("content_id <>", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idGreaterThan(Integer value) {
            addCriterion("content_id >", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("content_id >=", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idLessThan(Integer value) {
            addCriterion("content_id <", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idLessThanOrEqualTo(Integer value) {
            addCriterion("content_id <=", value, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idIn(List<Integer> values) {
            addCriterion("content_id in", values, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idNotIn(List<Integer> values) {
            addCriterion("content_id not in", values, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idBetween(Integer value1, Integer value2) {
            addCriterion("content_id between", value1, value2, "content_id");
            return (Criteria) this;
        }

        public Criteria andContent_idNotBetween(Integer value1, Integer value2) {
            addCriterion("content_id not between", value1, value2, "content_id");
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

        public Criteria andEff_dateIsNull() {
            addCriterion("eff_date is null");
            return (Criteria) this;
        }

        public Criteria andEff_dateIsNotNull() {
            addCriterion("eff_date is not null");
            return (Criteria) this;
        }

        public Criteria andEff_dateEqualTo(Date value) {
            addCriterion("eff_date =", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateNotEqualTo(Date value) {
            addCriterion("eff_date <>", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateGreaterThan(Date value) {
            addCriterion("eff_date >", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("eff_date >=", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateLessThan(Date value) {
            addCriterion("eff_date <", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateLessThanOrEqualTo(Date value) {
            addCriterion("eff_date <=", value, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateIn(List<Date> values) {
            addCriterion("eff_date in", values, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateNotIn(List<Date> values) {
            addCriterion("eff_date not in", values, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateBetween(Date value1, Date value2) {
            addCriterion("eff_date between", value1, value2, "eff_date");
            return (Criteria) this;
        }

        public Criteria andEff_dateNotBetween(Date value1, Date value2) {
            addCriterion("eff_date not between", value1, value2, "eff_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateIsNull() {
            addCriterion("exp_date is null");
            return (Criteria) this;
        }

        public Criteria andExp_dateIsNotNull() {
            addCriterion("exp_date is not null");
            return (Criteria) this;
        }

        public Criteria andExp_dateEqualTo(Date value) {
            addCriterion("exp_date =", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateNotEqualTo(Date value) {
            addCriterion("exp_date <>", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateGreaterThan(Date value) {
            addCriterion("exp_date >", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("exp_date >=", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateLessThan(Date value) {
            addCriterion("exp_date <", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateLessThanOrEqualTo(Date value) {
            addCriterion("exp_date <=", value, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateIn(List<Date> values) {
            addCriterion("exp_date in", values, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateNotIn(List<Date> values) {
            addCriterion("exp_date not in", values, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateBetween(Date value1, Date value2) {
            addCriterion("exp_date between", value1, value2, "exp_date");
            return (Criteria) this;
        }

        public Criteria andExp_dateNotBetween(Date value1, Date value2) {
            addCriterion("exp_date not between", value1, value2, "exp_date");
            return (Criteria) this;
        }

        public Criteria andOper_staffIsNull() {
            addCriterion("oper_staff is null");
            return (Criteria) this;
        }

        public Criteria andOper_staffIsNotNull() {
            addCriterion("oper_staff is not null");
            return (Criteria) this;
        }

        public Criteria andOper_staffEqualTo(Integer value) {
            addCriterion("oper_staff =", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffNotEqualTo(Integer value) {
            addCriterion("oper_staff <>", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffGreaterThan(Integer value) {
            addCriterion("oper_staff >", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffGreaterThanOrEqualTo(Integer value) {
            addCriterion("oper_staff >=", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffLessThan(Integer value) {
            addCriterion("oper_staff <", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffLessThanOrEqualTo(Integer value) {
            addCriterion("oper_staff <=", value, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffIn(List<Integer> values) {
            addCriterion("oper_staff in", values, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffNotIn(List<Integer> values) {
            addCriterion("oper_staff not in", values, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffBetween(Integer value1, Integer value2) {
            addCriterion("oper_staff between", value1, value2, "oper_staff");
            return (Criteria) this;
        }

        public Criteria andOper_staffNotBetween(Integer value1, Integer value2) {
            addCriterion("oper_staff not between", value1, value2, "oper_staff");
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