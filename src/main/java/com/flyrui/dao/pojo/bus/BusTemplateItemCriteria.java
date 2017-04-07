package com.flyrui.dao.pojo.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTemplateItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusTemplateItemCriteria() {
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

        public Criteria andItem_idIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItem_idIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItem_idEqualTo(Integer value) {
            addCriterion("item_id =", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idGreaterThan(Integer value) {
            addCriterion("item_id >", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idLessThan(Integer value) {
            addCriterion("item_id <", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idIn(List<Integer> values) {
            addCriterion("item_id in", values, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "item_id");
            return (Criteria) this;
        }

        public Criteria andItem_idNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "item_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idEqualTo(String value) {
            addCriterion("template_id =", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotEqualTo(String value) {
            addCriterion("template_id <>", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThan(String value) {
            addCriterion("template_id >", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThan(String value) {
            addCriterion("template_id <", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLike(String value) {
            addCriterion("template_id like", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotLike(String value) {
            addCriterion("template_id not like", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIn(List<String> values) {
            addCriterion("template_id in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotIn(List<String> values) {
            addCriterion("template_id not in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andItem_nameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItem_nameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItem_nameEqualTo(String value) {
            addCriterion("item_name =", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameGreaterThan(String value) {
            addCriterion("item_name >", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameLessThan(String value) {
            addCriterion("item_name <", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameLike(String value) {
            addCriterion("item_name like", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameNotLike(String value) {
            addCriterion("item_name not like", value, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameIn(List<String> values) {
            addCriterion("item_name in", values, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_nameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "item_name");
            return (Criteria) this;
        }

        public Criteria andItem_typeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItem_typeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItem_typeEqualTo(String value) {
            addCriterion("item_type =", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeGreaterThan(String value) {
            addCriterion("item_type >", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeLessThan(String value) {
            addCriterion("item_type <", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeLike(String value) {
            addCriterion("item_type like", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeNotLike(String value) {
            addCriterion("item_type not like", value, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeIn(List<String> values) {
            addCriterion("item_type in", values, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "item_type");
            return (Criteria) this;
        }

        public Criteria andItem_typeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "item_type");
            return (Criteria) this;
        }

        public Criteria andData_colIsNull() {
            addCriterion("data_col is null");
            return (Criteria) this;
        }

        public Criteria andData_colIsNotNull() {
            addCriterion("data_col is not null");
            return (Criteria) this;
        }

        public Criteria andData_colEqualTo(String value) {
            addCriterion("data_col =", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colNotEqualTo(String value) {
            addCriterion("data_col <>", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colGreaterThan(String value) {
            addCriterion("data_col >", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colGreaterThanOrEqualTo(String value) {
            addCriterion("data_col >=", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colLessThan(String value) {
            addCriterion("data_col <", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colLessThanOrEqualTo(String value) {
            addCriterion("data_col <=", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colLike(String value) {
            addCriterion("data_col like", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colNotLike(String value) {
            addCriterion("data_col not like", value, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colIn(List<String> values) {
            addCriterion("data_col in", values, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colNotIn(List<String> values) {
            addCriterion("data_col not in", values, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colBetween(String value1, String value2) {
            addCriterion("data_col between", value1, value2, "data_col");
            return (Criteria) this;
        }

        public Criteria andData_colNotBetween(String value1, String value2) {
            addCriterion("data_col not between", value1, value2, "data_col");
            return (Criteria) this;
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

        public Criteria andOrder_idIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Integer value) {
            addCriterion("order_id =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Integer value) {
            addCriterion("order_id >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Integer value) {
            addCriterion("order_id <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Integer> values) {
            addCriterion("order_id in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "order_id");
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