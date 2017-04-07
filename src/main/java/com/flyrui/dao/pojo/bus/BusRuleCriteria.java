package com.flyrui.dao.pojo.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusRuleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusRuleCriteria() {
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

        public Criteria andRule_idIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRule_idIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRule_idEqualTo(Integer value) {
            addCriterion("rule_id =", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idNotEqualTo(Integer value) {
            addCriterion("rule_id <>", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idGreaterThan(Integer value) {
            addCriterion("rule_id >", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_id >=", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idLessThan(Integer value) {
            addCriterion("rule_id <", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idLessThanOrEqualTo(Integer value) {
            addCriterion("rule_id <=", value, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idIn(List<Integer> values) {
            addCriterion("rule_id in", values, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idNotIn(List<Integer> values) {
            addCriterion("rule_id not in", values, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idBetween(Integer value1, Integer value2) {
            addCriterion("rule_id between", value1, value2, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_idNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_id not between", value1, value2, "rule_id");
            return (Criteria) this;
        }

        public Criteria andRule_nameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRule_nameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRule_nameEqualTo(String value) {
            addCriterion("rule_name =", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameGreaterThan(String value) {
            addCriterion("rule_name >", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLessThan(String value) {
            addCriterion("rule_name <", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameLike(String value) {
            addCriterion("rule_name like", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotLike(String value) {
            addCriterion("rule_name not like", value, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameIn(List<String> values) {
            addCriterion("rule_name in", values, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_nameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "rule_name");
            return (Criteria) this;
        }

        public Criteria andRule_typeIsNull() {
            addCriterion("rule_type is null");
            return (Criteria) this;
        }

        public Criteria andRule_typeIsNotNull() {
            addCriterion("rule_type is not null");
            return (Criteria) this;
        }

        public Criteria andRule_typeEqualTo(String value) {
            addCriterion("rule_type =", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeNotEqualTo(String value) {
            addCriterion("rule_type <>", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeGreaterThan(String value) {
            addCriterion("rule_type >", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_type >=", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeLessThan(String value) {
            addCriterion("rule_type <", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeLessThanOrEqualTo(String value) {
            addCriterion("rule_type <=", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeLike(String value) {
            addCriterion("rule_type like", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeNotLike(String value) {
            addCriterion("rule_type not like", value, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeIn(List<String> values) {
            addCriterion("rule_type in", values, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeNotIn(List<String> values) {
            addCriterion("rule_type not in", values, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeBetween(String value1, String value2) {
            addCriterion("rule_type between", value1, value2, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_typeNotBetween(String value1, String value2) {
            addCriterion("rule_type not between", value1, value2, "rule_type");
            return (Criteria) this;
        }

        public Criteria andRule_contentIsNull() {
            addCriterion("rule_content is null");
            return (Criteria) this;
        }

        public Criteria andRule_contentIsNotNull() {
            addCriterion("rule_content is not null");
            return (Criteria) this;
        }

        public Criteria andRule_contentEqualTo(String value) {
            addCriterion("rule_content =", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentNotEqualTo(String value) {
            addCriterion("rule_content <>", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentGreaterThan(String value) {
            addCriterion("rule_content >", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentGreaterThanOrEqualTo(String value) {
            addCriterion("rule_content >=", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentLessThan(String value) {
            addCriterion("rule_content <", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentLessThanOrEqualTo(String value) {
            addCriterion("rule_content <=", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentLike(String value) {
            addCriterion("rule_content like", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentNotLike(String value) {
            addCriterion("rule_content not like", value, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentIn(List<String> values) {
            addCriterion("rule_content in", values, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentNotIn(List<String> values) {
            addCriterion("rule_content not in", values, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentBetween(String value1, String value2) {
            addCriterion("rule_content between", value1, value2, "rule_content");
            return (Criteria) this;
        }

        public Criteria andRule_contentNotBetween(String value1, String value2) {
            addCriterion("rule_content not between", value1, value2, "rule_content");
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