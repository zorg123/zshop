package com.flyrui.dao.pojo.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusInfoCriteria() {
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

        public Criteria andBus_idIsNull() {
            addCriterion("bus_id is null");
            return (Criteria) this;
        }

        public Criteria andBus_idIsNotNull() {
            addCriterion("bus_id is not null");
            return (Criteria) this;
        }

        public Criteria andBus_idEqualTo(Integer value) {
            addCriterion("bus_id =", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idNotEqualTo(Integer value) {
            addCriterion("bus_id <>", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idGreaterThan(Integer value) {
            addCriterion("bus_id >", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("bus_id >=", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idLessThan(Integer value) {
            addCriterion("bus_id <", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idLessThanOrEqualTo(Integer value) {
            addCriterion("bus_id <=", value, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idIn(List<Integer> values) {
            addCriterion("bus_id in", values, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idNotIn(List<Integer> values) {
            addCriterion("bus_id not in", values, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idBetween(Integer value1, Integer value2) {
            addCriterion("bus_id between", value1, value2, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_idNotBetween(Integer value1, Integer value2) {
            addCriterion("bus_id not between", value1, value2, "bus_id");
            return (Criteria) this;
        }

        public Criteria andBus_nameIsNull() {
            addCriterion("bus_name is null");
            return (Criteria) this;
        }

        public Criteria andBus_nameIsNotNull() {
            addCriterion("bus_name is not null");
            return (Criteria) this;
        }

        public Criteria andBus_nameEqualTo(String value) {
            addCriterion("bus_name =", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameNotEqualTo(String value) {
            addCriterion("bus_name <>", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameGreaterThan(String value) {
            addCriterion("bus_name >", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameGreaterThanOrEqualTo(String value) {
            addCriterion("bus_name >=", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameLessThan(String value) {
            addCriterion("bus_name <", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameLessThanOrEqualTo(String value) {
            addCriterion("bus_name <=", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameLike(String value) {
            addCriterion("bus_name like", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameNotLike(String value) {
            addCriterion("bus_name not like", value, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameIn(List<String> values) {
            addCriterion("bus_name in", values, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameNotIn(List<String> values) {
            addCriterion("bus_name not in", values, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameBetween(String value1, String value2) {
            addCriterion("bus_name between", value1, value2, "bus_name");
            return (Criteria) this;
        }

        public Criteria andBus_nameNotBetween(String value1, String value2) {
            addCriterion("bus_name not between", value1, value2, "bus_name");
            return (Criteria) this;
        }

        public Criteria andImp_tmpIsNull() {
            addCriterion("imp_tmp is null");
            return (Criteria) this;
        }

        public Criteria andImp_tmpIsNotNull() {
            addCriterion("imp_tmp is not null");
            return (Criteria) this;
        }

        public Criteria andImp_tmpEqualTo(String value) {
            addCriterion("imp_tmp =", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpNotEqualTo(String value) {
            addCriterion("imp_tmp <>", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpGreaterThan(String value) {
            addCriterion("imp_tmp >", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpGreaterThanOrEqualTo(String value) {
            addCriterion("imp_tmp >=", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpLessThan(String value) {
            addCriterion("imp_tmp <", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpLessThanOrEqualTo(String value) {
            addCriterion("imp_tmp <=", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpLike(String value) {
            addCriterion("imp_tmp like", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpNotLike(String value) {
            addCriterion("imp_tmp not like", value, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpIn(List<String> values) {
            addCriterion("imp_tmp in", values, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpNotIn(List<String> values) {
            addCriterion("imp_tmp not in", values, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpBetween(String value1, String value2) {
            addCriterion("imp_tmp between", value1, value2, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andImp_tmpNotBetween(String value1, String value2) {
            addCriterion("imp_tmp not between", value1, value2, "imp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpIsNull() {
            addCriterion("exp_tmp is null");
            return (Criteria) this;
        }

        public Criteria andExp_tmpIsNotNull() {
            addCriterion("exp_tmp is not null");
            return (Criteria) this;
        }

        public Criteria andExp_tmpEqualTo(String value) {
            addCriterion("exp_tmp =", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpNotEqualTo(String value) {
            addCriterion("exp_tmp <>", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpGreaterThan(String value) {
            addCriterion("exp_tmp >", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpGreaterThanOrEqualTo(String value) {
            addCriterion("exp_tmp >=", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpLessThan(String value) {
            addCriterion("exp_tmp <", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpLessThanOrEqualTo(String value) {
            addCriterion("exp_tmp <=", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpLike(String value) {
            addCriterion("exp_tmp like", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpNotLike(String value) {
            addCriterion("exp_tmp not like", value, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpIn(List<String> values) {
            addCriterion("exp_tmp in", values, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpNotIn(List<String> values) {
            addCriterion("exp_tmp not in", values, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpBetween(String value1, String value2) {
            addCriterion("exp_tmp between", value1, value2, "exp_tmp");
            return (Criteria) this;
        }

        public Criteria andExp_tmpNotBetween(String value1, String value2) {
            addCriterion("exp_tmp not between", value1, value2, "exp_tmp");
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