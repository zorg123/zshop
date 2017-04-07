package com.flyrui.dao.pojo.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbConfigCriteria() {
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

        public Criteria andCf_idIsNull() {
            addCriterion("cf_id is null");
            return (Criteria) this;
        }

        public Criteria andCf_idIsNotNull() {
            addCriterion("cf_id is not null");
            return (Criteria) this;
        }

        public Criteria andCf_idEqualTo(String value) {
            addCriterion("cf_id =", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idNotEqualTo(String value) {
            addCriterion("cf_id <>", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idGreaterThan(String value) {
            addCriterion("cf_id >", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idGreaterThanOrEqualTo(String value) {
            addCriterion("cf_id >=", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idLessThan(String value) {
            addCriterion("cf_id <", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idLessThanOrEqualTo(String value) {
            addCriterion("cf_id <=", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idLike(String value) {
            addCriterion("cf_id like", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idNotLike(String value) {
            addCriterion("cf_id not like", value, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idIn(List<String> values) {
            addCriterion("cf_id in", values, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idNotIn(List<String> values) {
            addCriterion("cf_id not in", values, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idBetween(String value1, String value2) {
            addCriterion("cf_id between", value1, value2, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_idNotBetween(String value1, String value2) {
            addCriterion("cf_id not between", value1, value2, "cf_id");
            return (Criteria) this;
        }

        public Criteria andCf_descIsNull() {
            addCriterion("cf_desc is null");
            return (Criteria) this;
        }

        public Criteria andCf_descIsNotNull() {
            addCriterion("cf_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCf_descEqualTo(String value) {
            addCriterion("cf_desc =", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descNotEqualTo(String value) {
            addCriterion("cf_desc <>", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descGreaterThan(String value) {
            addCriterion("cf_desc >", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descGreaterThanOrEqualTo(String value) {
            addCriterion("cf_desc >=", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descLessThan(String value) {
            addCriterion("cf_desc <", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descLessThanOrEqualTo(String value) {
            addCriterion("cf_desc <=", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descLike(String value) {
            addCriterion("cf_desc like", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descNotLike(String value) {
            addCriterion("cf_desc not like", value, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descIn(List<String> values) {
            addCriterion("cf_desc in", values, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descNotIn(List<String> values) {
            addCriterion("cf_desc not in", values, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descBetween(String value1, String value2) {
            addCriterion("cf_desc between", value1, value2, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_descNotBetween(String value1, String value2) {
            addCriterion("cf_desc not between", value1, value2, "cf_desc");
            return (Criteria) this;
        }

        public Criteria andCf_valueIsNull() {
            addCriterion("cf_value is null");
            return (Criteria) this;
        }

        public Criteria andCf_valueIsNotNull() {
            addCriterion("cf_value is not null");
            return (Criteria) this;
        }

        public Criteria andCf_valueEqualTo(String value) {
            addCriterion("cf_value =", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueNotEqualTo(String value) {
            addCriterion("cf_value <>", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueGreaterThan(String value) {
            addCriterion("cf_value >", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueGreaterThanOrEqualTo(String value) {
            addCriterion("cf_value >=", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueLessThan(String value) {
            addCriterion("cf_value <", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueLessThanOrEqualTo(String value) {
            addCriterion("cf_value <=", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueLike(String value) {
            addCriterion("cf_value like", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueNotLike(String value) {
            addCriterion("cf_value not like", value, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueIn(List<String> values) {
            addCriterion("cf_value in", values, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueNotIn(List<String> values) {
            addCriterion("cf_value not in", values, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueBetween(String value1, String value2) {
            addCriterion("cf_value between", value1, value2, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCf_valueNotBetween(String value1, String value2) {
            addCriterion("cf_value not between", value1, value2, "cf_value");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
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