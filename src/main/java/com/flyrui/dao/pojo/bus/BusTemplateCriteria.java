package com.flyrui.dao.pojo.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusTemplateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusTemplateCriteria() {
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

        public Criteria andTemplate_nameIsNull() {
            addCriterion("template_name is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameIsNotNull() {
            addCriterion("template_name is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameEqualTo(String value) {
            addCriterion("template_name =", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotEqualTo(String value) {
            addCriterion("template_name <>", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameGreaterThan(String value) {
            addCriterion("template_name >", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameGreaterThanOrEqualTo(String value) {
            addCriterion("template_name >=", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLessThan(String value) {
            addCriterion("template_name <", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLessThanOrEqualTo(String value) {
            addCriterion("template_name <=", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLike(String value) {
            addCriterion("template_name like", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotLike(String value) {
            addCriterion("template_name not like", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameIn(List<String> values) {
            addCriterion("template_name in", values, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotIn(List<String> values) {
            addCriterion("template_name not in", values, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameBetween(String value1, String value2) {
            addCriterion("template_name between", value1, value2, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotBetween(String value1, String value2) {
            addCriterion("template_name not between", value1, value2, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeIsNull() {
            addCriterion("template_type is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeIsNotNull() {
            addCriterion("template_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeEqualTo(String value) {
            addCriterion("template_type =", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeNotEqualTo(String value) {
            addCriterion("template_type <>", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeGreaterThan(String value) {
            addCriterion("template_type >", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeGreaterThanOrEqualTo(String value) {
            addCriterion("template_type >=", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeLessThan(String value) {
            addCriterion("template_type <", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeLessThanOrEqualTo(String value) {
            addCriterion("template_type <=", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeLike(String value) {
            addCriterion("template_type like", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeNotLike(String value) {
            addCriterion("template_type not like", value, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeIn(List<String> values) {
            addCriterion("template_type in", values, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeNotIn(List<String> values) {
            addCriterion("template_type not in", values, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeBetween(String value1, String value2) {
            addCriterion("template_type between", value1, value2, "template_type");
            return (Criteria) this;
        }

        public Criteria andTemplate_typeNotBetween(String value1, String value2) {
            addCriterion("template_type not between", value1, value2, "template_type");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andData_typeEqualTo(String value) {
            addCriterion("data_type =", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThan(String value) {
            addCriterion("data_type >", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThan(String value) {
            addCriterion("data_type <", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLike(String value) {
            addCriterion("data_type like", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotLike(String value) {
            addCriterion("data_type not like", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeIn(List<String> values) {
            addCriterion("data_type in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andSheet_numberIsNull() {
            addCriterion("sheet_number is null");
            return (Criteria) this;
        }

        public Criteria andSheet_numberIsNotNull() {
            addCriterion("sheet_number is not null");
            return (Criteria) this;
        }

        public Criteria andSheet_numberEqualTo(Integer value) {
            addCriterion("sheet_number =", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberNotEqualTo(Integer value) {
            addCriterion("sheet_number <>", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberGreaterThan(Integer value) {
            addCriterion("sheet_number >", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sheet_number >=", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberLessThan(Integer value) {
            addCriterion("sheet_number <", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberLessThanOrEqualTo(Integer value) {
            addCriterion("sheet_number <=", value, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberIn(List<Integer> values) {
            addCriterion("sheet_number in", values, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberNotIn(List<Integer> values) {
            addCriterion("sheet_number not in", values, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberBetween(Integer value1, Integer value2) {
            addCriterion("sheet_number between", value1, value2, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andSheet_numberNotBetween(Integer value1, Integer value2) {
            addCriterion("sheet_number not between", value1, value2, "sheet_number");
            return (Criteria) this;
        }

        public Criteria andStart_rowIsNull() {
            addCriterion("start_row is null");
            return (Criteria) this;
        }

        public Criteria andStart_rowIsNotNull() {
            addCriterion("start_row is not null");
            return (Criteria) this;
        }

        public Criteria andStart_rowEqualTo(Integer value) {
            addCriterion("start_row =", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowNotEqualTo(Integer value) {
            addCriterion("start_row <>", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowGreaterThan(Integer value) {
            addCriterion("start_row >", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_row >=", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowLessThan(Integer value) {
            addCriterion("start_row <", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowLessThanOrEqualTo(Integer value) {
            addCriterion("start_row <=", value, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowIn(List<Integer> values) {
            addCriterion("start_row in", values, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowNotIn(List<Integer> values) {
            addCriterion("start_row not in", values, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowBetween(Integer value1, Integer value2) {
            addCriterion("start_row between", value1, value2, "start_row");
            return (Criteria) this;
        }

        public Criteria andStart_rowNotBetween(Integer value1, Integer value2) {
            addCriterion("start_row not between", value1, value2, "start_row");
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