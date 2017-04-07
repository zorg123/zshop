package com.flyrui.dao.pojo.bus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusDataCriteria() {
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

        public Criteria andData_idIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andData_idIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andData_idEqualTo(String value) {
            addCriterion("data_id =", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotEqualTo(String value) {
            addCriterion("data_id <>", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idGreaterThan(String value) {
            addCriterion("data_id >", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idLessThan(String value) {
            addCriterion("data_id <", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idLike(String value) {
            addCriterion("data_id like", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotLike(String value) {
            addCriterion("data_id not like", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idIn(List<String> values) {
            addCriterion("data_id in", values, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotIn(List<String> values) {
            addCriterion("data_id not in", values, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "data_id");
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

        public Criteria andCol1IsNull() {
            addCriterion("col1 is null");
            return (Criteria) this;
        }

        public Criteria andCol1IsNotNull() {
            addCriterion("col1 is not null");
            return (Criteria) this;
        }

        public Criteria andCol1EqualTo(String value) {
            addCriterion("col1 =", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotEqualTo(String value) {
            addCriterion("col1 <>", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1GreaterThan(String value) {
            addCriterion("col1 >", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1GreaterThanOrEqualTo(String value) {
            addCriterion("col1 >=", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1LessThan(String value) {
            addCriterion("col1 <", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1LessThanOrEqualTo(String value) {
            addCriterion("col1 <=", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1Like(String value) {
            addCriterion("col1 like", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotLike(String value) {
            addCriterion("col1 not like", value, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1In(List<String> values) {
            addCriterion("col1 in", values, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotIn(List<String> values) {
            addCriterion("col1 not in", values, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1Between(String value1, String value2) {
            addCriterion("col1 between", value1, value2, "col1");
            return (Criteria) this;
        }

        public Criteria andCol1NotBetween(String value1, String value2) {
            addCriterion("col1 not between", value1, value2, "col1");
            return (Criteria) this;
        }

        public Criteria andCol2IsNull() {
            addCriterion("col2 is null");
            return (Criteria) this;
        }

        public Criteria andCol2IsNotNull() {
            addCriterion("col2 is not null");
            return (Criteria) this;
        }

        public Criteria andCol2EqualTo(String value) {
            addCriterion("col2 =", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotEqualTo(String value) {
            addCriterion("col2 <>", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2GreaterThan(String value) {
            addCriterion("col2 >", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2GreaterThanOrEqualTo(String value) {
            addCriterion("col2 >=", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2LessThan(String value) {
            addCriterion("col2 <", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2LessThanOrEqualTo(String value) {
            addCriterion("col2 <=", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2Like(String value) {
            addCriterion("col2 like", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotLike(String value) {
            addCriterion("col2 not like", value, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2In(List<String> values) {
            addCriterion("col2 in", values, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotIn(List<String> values) {
            addCriterion("col2 not in", values, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2Between(String value1, String value2) {
            addCriterion("col2 between", value1, value2, "col2");
            return (Criteria) this;
        }

        public Criteria andCol2NotBetween(String value1, String value2) {
            addCriterion("col2 not between", value1, value2, "col2");
            return (Criteria) this;
        }

        public Criteria andCol3IsNull() {
            addCriterion("col3 is null");
            return (Criteria) this;
        }

        public Criteria andCol3IsNotNull() {
            addCriterion("col3 is not null");
            return (Criteria) this;
        }

        public Criteria andCol3EqualTo(String value) {
            addCriterion("col3 =", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotEqualTo(String value) {
            addCriterion("col3 <>", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3GreaterThan(String value) {
            addCriterion("col3 >", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3GreaterThanOrEqualTo(String value) {
            addCriterion("col3 >=", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3LessThan(String value) {
            addCriterion("col3 <", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3LessThanOrEqualTo(String value) {
            addCriterion("col3 <=", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3Like(String value) {
            addCriterion("col3 like", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotLike(String value) {
            addCriterion("col3 not like", value, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3In(List<String> values) {
            addCriterion("col3 in", values, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotIn(List<String> values) {
            addCriterion("col3 not in", values, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3Between(String value1, String value2) {
            addCriterion("col3 between", value1, value2, "col3");
            return (Criteria) this;
        }

        public Criteria andCol3NotBetween(String value1, String value2) {
            addCriterion("col3 not between", value1, value2, "col3");
            return (Criteria) this;
        }

        public Criteria andCol4IsNull() {
            addCriterion("col4 is null");
            return (Criteria) this;
        }

        public Criteria andCol4IsNotNull() {
            addCriterion("col4 is not null");
            return (Criteria) this;
        }

        public Criteria andCol4EqualTo(String value) {
            addCriterion("col4 =", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotEqualTo(String value) {
            addCriterion("col4 <>", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4GreaterThan(String value) {
            addCriterion("col4 >", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4GreaterThanOrEqualTo(String value) {
            addCriterion("col4 >=", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4LessThan(String value) {
            addCriterion("col4 <", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4LessThanOrEqualTo(String value) {
            addCriterion("col4 <=", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4Like(String value) {
            addCriterion("col4 like", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotLike(String value) {
            addCriterion("col4 not like", value, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4In(List<String> values) {
            addCriterion("col4 in", values, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotIn(List<String> values) {
            addCriterion("col4 not in", values, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4Between(String value1, String value2) {
            addCriterion("col4 between", value1, value2, "col4");
            return (Criteria) this;
        }

        public Criteria andCol4NotBetween(String value1, String value2) {
            addCriterion("col4 not between", value1, value2, "col4");
            return (Criteria) this;
        }

        public Criteria andCol5IsNull() {
            addCriterion("col5 is null");
            return (Criteria) this;
        }

        public Criteria andCol5IsNotNull() {
            addCriterion("col5 is not null");
            return (Criteria) this;
        }

        public Criteria andCol5EqualTo(String value) {
            addCriterion("col5 =", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotEqualTo(String value) {
            addCriterion("col5 <>", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5GreaterThan(String value) {
            addCriterion("col5 >", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5GreaterThanOrEqualTo(String value) {
            addCriterion("col5 >=", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5LessThan(String value) {
            addCriterion("col5 <", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5LessThanOrEqualTo(String value) {
            addCriterion("col5 <=", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5Like(String value) {
            addCriterion("col5 like", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotLike(String value) {
            addCriterion("col5 not like", value, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5In(List<String> values) {
            addCriterion("col5 in", values, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotIn(List<String> values) {
            addCriterion("col5 not in", values, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5Between(String value1, String value2) {
            addCriterion("col5 between", value1, value2, "col5");
            return (Criteria) this;
        }

        public Criteria andCol5NotBetween(String value1, String value2) {
            addCriterion("col5 not between", value1, value2, "col5");
            return (Criteria) this;
        }

        public Criteria andCol6IsNull() {
            addCriterion("col6 is null");
            return (Criteria) this;
        }

        public Criteria andCol6IsNotNull() {
            addCriterion("col6 is not null");
            return (Criteria) this;
        }

        public Criteria andCol6EqualTo(String value) {
            addCriterion("col6 =", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotEqualTo(String value) {
            addCriterion("col6 <>", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6GreaterThan(String value) {
            addCriterion("col6 >", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6GreaterThanOrEqualTo(String value) {
            addCriterion("col6 >=", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6LessThan(String value) {
            addCriterion("col6 <", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6LessThanOrEqualTo(String value) {
            addCriterion("col6 <=", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6Like(String value) {
            addCriterion("col6 like", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotLike(String value) {
            addCriterion("col6 not like", value, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6In(List<String> values) {
            addCriterion("col6 in", values, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotIn(List<String> values) {
            addCriterion("col6 not in", values, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6Between(String value1, String value2) {
            addCriterion("col6 between", value1, value2, "col6");
            return (Criteria) this;
        }

        public Criteria andCol6NotBetween(String value1, String value2) {
            addCriterion("col6 not between", value1, value2, "col6");
            return (Criteria) this;
        }

        public Criteria andCol7IsNull() {
            addCriterion("col7 is null");
            return (Criteria) this;
        }

        public Criteria andCol7IsNotNull() {
            addCriterion("col7 is not null");
            return (Criteria) this;
        }

        public Criteria andCol7EqualTo(String value) {
            addCriterion("col7 =", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7NotEqualTo(String value) {
            addCriterion("col7 <>", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7GreaterThan(String value) {
            addCriterion("col7 >", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7GreaterThanOrEqualTo(String value) {
            addCriterion("col7 >=", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7LessThan(String value) {
            addCriterion("col7 <", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7LessThanOrEqualTo(String value) {
            addCriterion("col7 <=", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7Like(String value) {
            addCriterion("col7 like", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7NotLike(String value) {
            addCriterion("col7 not like", value, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7In(List<String> values) {
            addCriterion("col7 in", values, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7NotIn(List<String> values) {
            addCriterion("col7 not in", values, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7Between(String value1, String value2) {
            addCriterion("col7 between", value1, value2, "col7");
            return (Criteria) this;
        }

        public Criteria andCol7NotBetween(String value1, String value2) {
            addCriterion("col7 not between", value1, value2, "col7");
            return (Criteria) this;
        }

        public Criteria andCol8IsNull() {
            addCriterion("col8 is null");
            return (Criteria) this;
        }

        public Criteria andCol8IsNotNull() {
            addCriterion("col8 is not null");
            return (Criteria) this;
        }

        public Criteria andCol8EqualTo(String value) {
            addCriterion("col8 =", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8NotEqualTo(String value) {
            addCriterion("col8 <>", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8GreaterThan(String value) {
            addCriterion("col8 >", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8GreaterThanOrEqualTo(String value) {
            addCriterion("col8 >=", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8LessThan(String value) {
            addCriterion("col8 <", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8LessThanOrEqualTo(String value) {
            addCriterion("col8 <=", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8Like(String value) {
            addCriterion("col8 like", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8NotLike(String value) {
            addCriterion("col8 not like", value, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8In(List<String> values) {
            addCriterion("col8 in", values, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8NotIn(List<String> values) {
            addCriterion("col8 not in", values, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8Between(String value1, String value2) {
            addCriterion("col8 between", value1, value2, "col8");
            return (Criteria) this;
        }

        public Criteria andCol8NotBetween(String value1, String value2) {
            addCriterion("col8 not between", value1, value2, "col8");
            return (Criteria) this;
        }

        public Criteria andCol9IsNull() {
            addCriterion("col9 is null");
            return (Criteria) this;
        }

        public Criteria andCol9IsNotNull() {
            addCriterion("col9 is not null");
            return (Criteria) this;
        }

        public Criteria andCol9EqualTo(String value) {
            addCriterion("col9 =", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9NotEqualTo(String value) {
            addCriterion("col9 <>", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9GreaterThan(String value) {
            addCriterion("col9 >", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9GreaterThanOrEqualTo(String value) {
            addCriterion("col9 >=", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9LessThan(String value) {
            addCriterion("col9 <", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9LessThanOrEqualTo(String value) {
            addCriterion("col9 <=", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9Like(String value) {
            addCriterion("col9 like", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9NotLike(String value) {
            addCriterion("col9 not like", value, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9In(List<String> values) {
            addCriterion("col9 in", values, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9NotIn(List<String> values) {
            addCriterion("col9 not in", values, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9Between(String value1, String value2) {
            addCriterion("col9 between", value1, value2, "col9");
            return (Criteria) this;
        }

        public Criteria andCol9NotBetween(String value1, String value2) {
            addCriterion("col9 not between", value1, value2, "col9");
            return (Criteria) this;
        }

        public Criteria andCol10IsNull() {
            addCriterion("col10 is null");
            return (Criteria) this;
        }

        public Criteria andCol10IsNotNull() {
            addCriterion("col10 is not null");
            return (Criteria) this;
        }

        public Criteria andCol10EqualTo(String value) {
            addCriterion("col10 =", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10NotEqualTo(String value) {
            addCriterion("col10 <>", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10GreaterThan(String value) {
            addCriterion("col10 >", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10GreaterThanOrEqualTo(String value) {
            addCriterion("col10 >=", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10LessThan(String value) {
            addCriterion("col10 <", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10LessThanOrEqualTo(String value) {
            addCriterion("col10 <=", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10Like(String value) {
            addCriterion("col10 like", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10NotLike(String value) {
            addCriterion("col10 not like", value, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10In(List<String> values) {
            addCriterion("col10 in", values, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10NotIn(List<String> values) {
            addCriterion("col10 not in", values, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10Between(String value1, String value2) {
            addCriterion("col10 between", value1, value2, "col10");
            return (Criteria) this;
        }

        public Criteria andCol10NotBetween(String value1, String value2) {
            addCriterion("col10 not between", value1, value2, "col10");
            return (Criteria) this;
        }

        public Criteria andCol11IsNull() {
            addCriterion("col11 is null");
            return (Criteria) this;
        }

        public Criteria andCol11IsNotNull() {
            addCriterion("col11 is not null");
            return (Criteria) this;
        }

        public Criteria andCol11EqualTo(String value) {
            addCriterion("col11 =", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11NotEqualTo(String value) {
            addCriterion("col11 <>", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11GreaterThan(String value) {
            addCriterion("col11 >", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11GreaterThanOrEqualTo(String value) {
            addCriterion("col11 >=", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11LessThan(String value) {
            addCriterion("col11 <", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11LessThanOrEqualTo(String value) {
            addCriterion("col11 <=", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11Like(String value) {
            addCriterion("col11 like", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11NotLike(String value) {
            addCriterion("col11 not like", value, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11In(List<String> values) {
            addCriterion("col11 in", values, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11NotIn(List<String> values) {
            addCriterion("col11 not in", values, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11Between(String value1, String value2) {
            addCriterion("col11 between", value1, value2, "col11");
            return (Criteria) this;
        }

        public Criteria andCol11NotBetween(String value1, String value2) {
            addCriterion("col11 not between", value1, value2, "col11");
            return (Criteria) this;
        }

        public Criteria andCol12IsNull() {
            addCriterion("col12 is null");
            return (Criteria) this;
        }

        public Criteria andCol12IsNotNull() {
            addCriterion("col12 is not null");
            return (Criteria) this;
        }

        public Criteria andCol12EqualTo(String value) {
            addCriterion("col12 =", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12NotEqualTo(String value) {
            addCriterion("col12 <>", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12GreaterThan(String value) {
            addCriterion("col12 >", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12GreaterThanOrEqualTo(String value) {
            addCriterion("col12 >=", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12LessThan(String value) {
            addCriterion("col12 <", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12LessThanOrEqualTo(String value) {
            addCriterion("col12 <=", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12Like(String value) {
            addCriterion("col12 like", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12NotLike(String value) {
            addCriterion("col12 not like", value, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12In(List<String> values) {
            addCriterion("col12 in", values, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12NotIn(List<String> values) {
            addCriterion("col12 not in", values, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12Between(String value1, String value2) {
            addCriterion("col12 between", value1, value2, "col12");
            return (Criteria) this;
        }

        public Criteria andCol12NotBetween(String value1, String value2) {
            addCriterion("col12 not between", value1, value2, "col12");
            return (Criteria) this;
        }

        public Criteria andCol13IsNull() {
            addCriterion("col13 is null");
            return (Criteria) this;
        }

        public Criteria andCol13IsNotNull() {
            addCriterion("col13 is not null");
            return (Criteria) this;
        }

        public Criteria andCol13EqualTo(String value) {
            addCriterion("col13 =", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13NotEqualTo(String value) {
            addCriterion("col13 <>", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13GreaterThan(String value) {
            addCriterion("col13 >", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13GreaterThanOrEqualTo(String value) {
            addCriterion("col13 >=", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13LessThan(String value) {
            addCriterion("col13 <", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13LessThanOrEqualTo(String value) {
            addCriterion("col13 <=", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13Like(String value) {
            addCriterion("col13 like", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13NotLike(String value) {
            addCriterion("col13 not like", value, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13In(List<String> values) {
            addCriterion("col13 in", values, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13NotIn(List<String> values) {
            addCriterion("col13 not in", values, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13Between(String value1, String value2) {
            addCriterion("col13 between", value1, value2, "col13");
            return (Criteria) this;
        }

        public Criteria andCol13NotBetween(String value1, String value2) {
            addCriterion("col13 not between", value1, value2, "col13");
            return (Criteria) this;
        }

        public Criteria andCol14IsNull() {
            addCriterion("col14 is null");
            return (Criteria) this;
        }

        public Criteria andCol14IsNotNull() {
            addCriterion("col14 is not null");
            return (Criteria) this;
        }

        public Criteria andCol14EqualTo(String value) {
            addCriterion("col14 =", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14NotEqualTo(String value) {
            addCriterion("col14 <>", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14GreaterThan(String value) {
            addCriterion("col14 >", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14GreaterThanOrEqualTo(String value) {
            addCriterion("col14 >=", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14LessThan(String value) {
            addCriterion("col14 <", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14LessThanOrEqualTo(String value) {
            addCriterion("col14 <=", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14Like(String value) {
            addCriterion("col14 like", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14NotLike(String value) {
            addCriterion("col14 not like", value, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14In(List<String> values) {
            addCriterion("col14 in", values, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14NotIn(List<String> values) {
            addCriterion("col14 not in", values, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14Between(String value1, String value2) {
            addCriterion("col14 between", value1, value2, "col14");
            return (Criteria) this;
        }

        public Criteria andCol14NotBetween(String value1, String value2) {
            addCriterion("col14 not between", value1, value2, "col14");
            return (Criteria) this;
        }

        public Criteria andCol15IsNull() {
            addCriterion("col15 is null");
            return (Criteria) this;
        }

        public Criteria andCol15IsNotNull() {
            addCriterion("col15 is not null");
            return (Criteria) this;
        }

        public Criteria andCol15EqualTo(String value) {
            addCriterion("col15 =", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15NotEqualTo(String value) {
            addCriterion("col15 <>", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15GreaterThan(String value) {
            addCriterion("col15 >", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15GreaterThanOrEqualTo(String value) {
            addCriterion("col15 >=", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15LessThan(String value) {
            addCriterion("col15 <", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15LessThanOrEqualTo(String value) {
            addCriterion("col15 <=", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15Like(String value) {
            addCriterion("col15 like", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15NotLike(String value) {
            addCriterion("col15 not like", value, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15In(List<String> values) {
            addCriterion("col15 in", values, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15NotIn(List<String> values) {
            addCriterion("col15 not in", values, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15Between(String value1, String value2) {
            addCriterion("col15 between", value1, value2, "col15");
            return (Criteria) this;
        }

        public Criteria andCol15NotBetween(String value1, String value2) {
            addCriterion("col15 not between", value1, value2, "col15");
            return (Criteria) this;
        }

        public Criteria andCol16IsNull() {
            addCriterion("col16 is null");
            return (Criteria) this;
        }

        public Criteria andCol16IsNotNull() {
            addCriterion("col16 is not null");
            return (Criteria) this;
        }

        public Criteria andCol16EqualTo(String value) {
            addCriterion("col16 =", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16NotEqualTo(String value) {
            addCriterion("col16 <>", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16GreaterThan(String value) {
            addCriterion("col16 >", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16GreaterThanOrEqualTo(String value) {
            addCriterion("col16 >=", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16LessThan(String value) {
            addCriterion("col16 <", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16LessThanOrEqualTo(String value) {
            addCriterion("col16 <=", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16Like(String value) {
            addCriterion("col16 like", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16NotLike(String value) {
            addCriterion("col16 not like", value, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16In(List<String> values) {
            addCriterion("col16 in", values, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16NotIn(List<String> values) {
            addCriterion("col16 not in", values, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16Between(String value1, String value2) {
            addCriterion("col16 between", value1, value2, "col16");
            return (Criteria) this;
        }

        public Criteria andCol16NotBetween(String value1, String value2) {
            addCriterion("col16 not between", value1, value2, "col16");
            return (Criteria) this;
        }

        public Criteria andCol17IsNull() {
            addCriterion("col17 is null");
            return (Criteria) this;
        }

        public Criteria andCol17IsNotNull() {
            addCriterion("col17 is not null");
            return (Criteria) this;
        }

        public Criteria andCol17EqualTo(String value) {
            addCriterion("col17 =", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17NotEqualTo(String value) {
            addCriterion("col17 <>", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17GreaterThan(String value) {
            addCriterion("col17 >", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17GreaterThanOrEqualTo(String value) {
            addCriterion("col17 >=", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17LessThan(String value) {
            addCriterion("col17 <", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17LessThanOrEqualTo(String value) {
            addCriterion("col17 <=", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17Like(String value) {
            addCriterion("col17 like", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17NotLike(String value) {
            addCriterion("col17 not like", value, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17In(List<String> values) {
            addCriterion("col17 in", values, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17NotIn(List<String> values) {
            addCriterion("col17 not in", values, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17Between(String value1, String value2) {
            addCriterion("col17 between", value1, value2, "col17");
            return (Criteria) this;
        }

        public Criteria andCol17NotBetween(String value1, String value2) {
            addCriterion("col17 not between", value1, value2, "col17");
            return (Criteria) this;
        }

        public Criteria andCol18IsNull() {
            addCriterion("col18 is null");
            return (Criteria) this;
        }

        public Criteria andCol18IsNotNull() {
            addCriterion("col18 is not null");
            return (Criteria) this;
        }

        public Criteria andCol18EqualTo(String value) {
            addCriterion("col18 =", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18NotEqualTo(String value) {
            addCriterion("col18 <>", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18GreaterThan(String value) {
            addCriterion("col18 >", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18GreaterThanOrEqualTo(String value) {
            addCriterion("col18 >=", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18LessThan(String value) {
            addCriterion("col18 <", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18LessThanOrEqualTo(String value) {
            addCriterion("col18 <=", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18Like(String value) {
            addCriterion("col18 like", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18NotLike(String value) {
            addCriterion("col18 not like", value, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18In(List<String> values) {
            addCriterion("col18 in", values, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18NotIn(List<String> values) {
            addCriterion("col18 not in", values, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18Between(String value1, String value2) {
            addCriterion("col18 between", value1, value2, "col18");
            return (Criteria) this;
        }

        public Criteria andCol18NotBetween(String value1, String value2) {
            addCriterion("col18 not between", value1, value2, "col18");
            return (Criteria) this;
        }

        public Criteria andCol19IsNull() {
            addCriterion("col19 is null");
            return (Criteria) this;
        }

        public Criteria andCol19IsNotNull() {
            addCriterion("col19 is not null");
            return (Criteria) this;
        }

        public Criteria andCol19EqualTo(String value) {
            addCriterion("col19 =", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19NotEqualTo(String value) {
            addCriterion("col19 <>", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19GreaterThan(String value) {
            addCriterion("col19 >", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19GreaterThanOrEqualTo(String value) {
            addCriterion("col19 >=", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19LessThan(String value) {
            addCriterion("col19 <", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19LessThanOrEqualTo(String value) {
            addCriterion("col19 <=", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19Like(String value) {
            addCriterion("col19 like", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19NotLike(String value) {
            addCriterion("col19 not like", value, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19In(List<String> values) {
            addCriterion("col19 in", values, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19NotIn(List<String> values) {
            addCriterion("col19 not in", values, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19Between(String value1, String value2) {
            addCriterion("col19 between", value1, value2, "col19");
            return (Criteria) this;
        }

        public Criteria andCol19NotBetween(String value1, String value2) {
            addCriterion("col19 not between", value1, value2, "col19");
            return (Criteria) this;
        }

        public Criteria andCol20IsNull() {
            addCriterion("col20 is null");
            return (Criteria) this;
        }

        public Criteria andCol20IsNotNull() {
            addCriterion("col20 is not null");
            return (Criteria) this;
        }

        public Criteria andCol20EqualTo(String value) {
            addCriterion("col20 =", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20NotEqualTo(String value) {
            addCriterion("col20 <>", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20GreaterThan(String value) {
            addCriterion("col20 >", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20GreaterThanOrEqualTo(String value) {
            addCriterion("col20 >=", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20LessThan(String value) {
            addCriterion("col20 <", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20LessThanOrEqualTo(String value) {
            addCriterion("col20 <=", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20Like(String value) {
            addCriterion("col20 like", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20NotLike(String value) {
            addCriterion("col20 not like", value, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20In(List<String> values) {
            addCriterion("col20 in", values, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20NotIn(List<String> values) {
            addCriterion("col20 not in", values, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20Between(String value1, String value2) {
            addCriterion("col20 between", value1, value2, "col20");
            return (Criteria) this;
        }

        public Criteria andCol20NotBetween(String value1, String value2) {
            addCriterion("col20 not between", value1, value2, "col20");
            return (Criteria) this;
        }

        public Criteria andCol21IsNull() {
            addCriterion("col21 is null");
            return (Criteria) this;
        }

        public Criteria andCol21IsNotNull() {
            addCriterion("col21 is not null");
            return (Criteria) this;
        }

        public Criteria andCol21EqualTo(String value) {
            addCriterion("col21 =", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21NotEqualTo(String value) {
            addCriterion("col21 <>", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21GreaterThan(String value) {
            addCriterion("col21 >", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21GreaterThanOrEqualTo(String value) {
            addCriterion("col21 >=", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21LessThan(String value) {
            addCriterion("col21 <", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21LessThanOrEqualTo(String value) {
            addCriterion("col21 <=", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21Like(String value) {
            addCriterion("col21 like", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21NotLike(String value) {
            addCriterion("col21 not like", value, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21In(List<String> values) {
            addCriterion("col21 in", values, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21NotIn(List<String> values) {
            addCriterion("col21 not in", values, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21Between(String value1, String value2) {
            addCriterion("col21 between", value1, value2, "col21");
            return (Criteria) this;
        }

        public Criteria andCol21NotBetween(String value1, String value2) {
            addCriterion("col21 not between", value1, value2, "col21");
            return (Criteria) this;
        }

        public Criteria andCol22IsNull() {
            addCriterion("col22 is null");
            return (Criteria) this;
        }

        public Criteria andCol22IsNotNull() {
            addCriterion("col22 is not null");
            return (Criteria) this;
        }

        public Criteria andCol22EqualTo(String value) {
            addCriterion("col22 =", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22NotEqualTo(String value) {
            addCriterion("col22 <>", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22GreaterThan(String value) {
            addCriterion("col22 >", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22GreaterThanOrEqualTo(String value) {
            addCriterion("col22 >=", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22LessThan(String value) {
            addCriterion("col22 <", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22LessThanOrEqualTo(String value) {
            addCriterion("col22 <=", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22Like(String value) {
            addCriterion("col22 like", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22NotLike(String value) {
            addCriterion("col22 not like", value, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22In(List<String> values) {
            addCriterion("col22 in", values, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22NotIn(List<String> values) {
            addCriterion("col22 not in", values, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22Between(String value1, String value2) {
            addCriterion("col22 between", value1, value2, "col22");
            return (Criteria) this;
        }

        public Criteria andCol22NotBetween(String value1, String value2) {
            addCriterion("col22 not between", value1, value2, "col22");
            return (Criteria) this;
        }

        public Criteria andCol23IsNull() {
            addCriterion("col23 is null");
            return (Criteria) this;
        }

        public Criteria andCol23IsNotNull() {
            addCriterion("col23 is not null");
            return (Criteria) this;
        }

        public Criteria andCol23EqualTo(String value) {
            addCriterion("col23 =", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23NotEqualTo(String value) {
            addCriterion("col23 <>", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23GreaterThan(String value) {
            addCriterion("col23 >", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23GreaterThanOrEqualTo(String value) {
            addCriterion("col23 >=", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23LessThan(String value) {
            addCriterion("col23 <", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23LessThanOrEqualTo(String value) {
            addCriterion("col23 <=", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23Like(String value) {
            addCriterion("col23 like", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23NotLike(String value) {
            addCriterion("col23 not like", value, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23In(List<String> values) {
            addCriterion("col23 in", values, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23NotIn(List<String> values) {
            addCriterion("col23 not in", values, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23Between(String value1, String value2) {
            addCriterion("col23 between", value1, value2, "col23");
            return (Criteria) this;
        }

        public Criteria andCol23NotBetween(String value1, String value2) {
            addCriterion("col23 not between", value1, value2, "col23");
            return (Criteria) this;
        }

        public Criteria andCol24IsNull() {
            addCriterion("col24 is null");
            return (Criteria) this;
        }

        public Criteria andCol24IsNotNull() {
            addCriterion("col24 is not null");
            return (Criteria) this;
        }

        public Criteria andCol24EqualTo(String value) {
            addCriterion("col24 =", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24NotEqualTo(String value) {
            addCriterion("col24 <>", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24GreaterThan(String value) {
            addCriterion("col24 >", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24GreaterThanOrEqualTo(String value) {
            addCriterion("col24 >=", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24LessThan(String value) {
            addCriterion("col24 <", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24LessThanOrEqualTo(String value) {
            addCriterion("col24 <=", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24Like(String value) {
            addCriterion("col24 like", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24NotLike(String value) {
            addCriterion("col24 not like", value, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24In(List<String> values) {
            addCriterion("col24 in", values, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24NotIn(List<String> values) {
            addCriterion("col24 not in", values, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24Between(String value1, String value2) {
            addCriterion("col24 between", value1, value2, "col24");
            return (Criteria) this;
        }

        public Criteria andCol24NotBetween(String value1, String value2) {
            addCriterion("col24 not between", value1, value2, "col24");
            return (Criteria) this;
        }

        public Criteria andCol25IsNull() {
            addCriterion("col25 is null");
            return (Criteria) this;
        }

        public Criteria andCol25IsNotNull() {
            addCriterion("col25 is not null");
            return (Criteria) this;
        }

        public Criteria andCol25EqualTo(String value) {
            addCriterion("col25 =", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25NotEqualTo(String value) {
            addCriterion("col25 <>", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25GreaterThan(String value) {
            addCriterion("col25 >", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25GreaterThanOrEqualTo(String value) {
            addCriterion("col25 >=", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25LessThan(String value) {
            addCriterion("col25 <", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25LessThanOrEqualTo(String value) {
            addCriterion("col25 <=", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25Like(String value) {
            addCriterion("col25 like", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25NotLike(String value) {
            addCriterion("col25 not like", value, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25In(List<String> values) {
            addCriterion("col25 in", values, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25NotIn(List<String> values) {
            addCriterion("col25 not in", values, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25Between(String value1, String value2) {
            addCriterion("col25 between", value1, value2, "col25");
            return (Criteria) this;
        }

        public Criteria andCol25NotBetween(String value1, String value2) {
            addCriterion("col25 not between", value1, value2, "col25");
            return (Criteria) this;
        }

        public Criteria andCol26IsNull() {
            addCriterion("col26 is null");
            return (Criteria) this;
        }

        public Criteria andCol26IsNotNull() {
            addCriterion("col26 is not null");
            return (Criteria) this;
        }

        public Criteria andCol26EqualTo(String value) {
            addCriterion("col26 =", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26NotEqualTo(String value) {
            addCriterion("col26 <>", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26GreaterThan(String value) {
            addCriterion("col26 >", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26GreaterThanOrEqualTo(String value) {
            addCriterion("col26 >=", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26LessThan(String value) {
            addCriterion("col26 <", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26LessThanOrEqualTo(String value) {
            addCriterion("col26 <=", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26Like(String value) {
            addCriterion("col26 like", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26NotLike(String value) {
            addCriterion("col26 not like", value, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26In(List<String> values) {
            addCriterion("col26 in", values, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26NotIn(List<String> values) {
            addCriterion("col26 not in", values, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26Between(String value1, String value2) {
            addCriterion("col26 between", value1, value2, "col26");
            return (Criteria) this;
        }

        public Criteria andCol26NotBetween(String value1, String value2) {
            addCriterion("col26 not between", value1, value2, "col26");
            return (Criteria) this;
        }

        public Criteria andCol27IsNull() {
            addCriterion("col27 is null");
            return (Criteria) this;
        }

        public Criteria andCol27IsNotNull() {
            addCriterion("col27 is not null");
            return (Criteria) this;
        }

        public Criteria andCol27EqualTo(String value) {
            addCriterion("col27 =", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27NotEqualTo(String value) {
            addCriterion("col27 <>", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27GreaterThan(String value) {
            addCriterion("col27 >", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27GreaterThanOrEqualTo(String value) {
            addCriterion("col27 >=", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27LessThan(String value) {
            addCriterion("col27 <", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27LessThanOrEqualTo(String value) {
            addCriterion("col27 <=", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27Like(String value) {
            addCriterion("col27 like", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27NotLike(String value) {
            addCriterion("col27 not like", value, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27In(List<String> values) {
            addCriterion("col27 in", values, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27NotIn(List<String> values) {
            addCriterion("col27 not in", values, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27Between(String value1, String value2) {
            addCriterion("col27 between", value1, value2, "col27");
            return (Criteria) this;
        }

        public Criteria andCol27NotBetween(String value1, String value2) {
            addCriterion("col27 not between", value1, value2, "col27");
            return (Criteria) this;
        }

        public Criteria andCol28IsNull() {
            addCriterion("col28 is null");
            return (Criteria) this;
        }

        public Criteria andCol28IsNotNull() {
            addCriterion("col28 is not null");
            return (Criteria) this;
        }

        public Criteria andCol28EqualTo(String value) {
            addCriterion("col28 =", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28NotEqualTo(String value) {
            addCriterion("col28 <>", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28GreaterThan(String value) {
            addCriterion("col28 >", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28GreaterThanOrEqualTo(String value) {
            addCriterion("col28 >=", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28LessThan(String value) {
            addCriterion("col28 <", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28LessThanOrEqualTo(String value) {
            addCriterion("col28 <=", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28Like(String value) {
            addCriterion("col28 like", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28NotLike(String value) {
            addCriterion("col28 not like", value, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28In(List<String> values) {
            addCriterion("col28 in", values, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28NotIn(List<String> values) {
            addCriterion("col28 not in", values, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28Between(String value1, String value2) {
            addCriterion("col28 between", value1, value2, "col28");
            return (Criteria) this;
        }

        public Criteria andCol28NotBetween(String value1, String value2) {
            addCriterion("col28 not between", value1, value2, "col28");
            return (Criteria) this;
        }

        public Criteria andCol29IsNull() {
            addCriterion("col29 is null");
            return (Criteria) this;
        }

        public Criteria andCol29IsNotNull() {
            addCriterion("col29 is not null");
            return (Criteria) this;
        }

        public Criteria andCol29EqualTo(String value) {
            addCriterion("col29 =", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29NotEqualTo(String value) {
            addCriterion("col29 <>", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29GreaterThan(String value) {
            addCriterion("col29 >", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29GreaterThanOrEqualTo(String value) {
            addCriterion("col29 >=", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29LessThan(String value) {
            addCriterion("col29 <", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29LessThanOrEqualTo(String value) {
            addCriterion("col29 <=", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29Like(String value) {
            addCriterion("col29 like", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29NotLike(String value) {
            addCriterion("col29 not like", value, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29In(List<String> values) {
            addCriterion("col29 in", values, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29NotIn(List<String> values) {
            addCriterion("col29 not in", values, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29Between(String value1, String value2) {
            addCriterion("col29 between", value1, value2, "col29");
            return (Criteria) this;
        }

        public Criteria andCol29NotBetween(String value1, String value2) {
            addCriterion("col29 not between", value1, value2, "col29");
            return (Criteria) this;
        }

        public Criteria andCol30IsNull() {
            addCriterion("col30 is null");
            return (Criteria) this;
        }

        public Criteria andCol30IsNotNull() {
            addCriterion("col30 is not null");
            return (Criteria) this;
        }

        public Criteria andCol30EqualTo(String value) {
            addCriterion("col30 =", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30NotEqualTo(String value) {
            addCriterion("col30 <>", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30GreaterThan(String value) {
            addCriterion("col30 >", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30GreaterThanOrEqualTo(String value) {
            addCriterion("col30 >=", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30LessThan(String value) {
            addCriterion("col30 <", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30LessThanOrEqualTo(String value) {
            addCriterion("col30 <=", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30Like(String value) {
            addCriterion("col30 like", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30NotLike(String value) {
            addCriterion("col30 not like", value, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30In(List<String> values) {
            addCriterion("col30 in", values, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30NotIn(List<String> values) {
            addCriterion("col30 not in", values, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30Between(String value1, String value2) {
            addCriterion("col30 between", value1, value2, "col30");
            return (Criteria) this;
        }

        public Criteria andCol30NotBetween(String value1, String value2) {
            addCriterion("col30 not between", value1, value2, "col30");
            return (Criteria) this;
        }

        public Criteria andCol31IsNull() {
            addCriterion("col31 is null");
            return (Criteria) this;
        }

        public Criteria andCol31IsNotNull() {
            addCriterion("col31 is not null");
            return (Criteria) this;
        }

        public Criteria andCol31EqualTo(String value) {
            addCriterion("col31 =", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31NotEqualTo(String value) {
            addCriterion("col31 <>", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31GreaterThan(String value) {
            addCriterion("col31 >", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31GreaterThanOrEqualTo(String value) {
            addCriterion("col31 >=", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31LessThan(String value) {
            addCriterion("col31 <", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31LessThanOrEqualTo(String value) {
            addCriterion("col31 <=", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31Like(String value) {
            addCriterion("col31 like", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31NotLike(String value) {
            addCriterion("col31 not like", value, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31In(List<String> values) {
            addCriterion("col31 in", values, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31NotIn(List<String> values) {
            addCriterion("col31 not in", values, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31Between(String value1, String value2) {
            addCriterion("col31 between", value1, value2, "col31");
            return (Criteria) this;
        }

        public Criteria andCol31NotBetween(String value1, String value2) {
            addCriterion("col31 not between", value1, value2, "col31");
            return (Criteria) this;
        }

        public Criteria andCol32IsNull() {
            addCriterion("col32 is null");
            return (Criteria) this;
        }

        public Criteria andCol32IsNotNull() {
            addCriterion("col32 is not null");
            return (Criteria) this;
        }

        public Criteria andCol32EqualTo(String value) {
            addCriterion("col32 =", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32NotEqualTo(String value) {
            addCriterion("col32 <>", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32GreaterThan(String value) {
            addCriterion("col32 >", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32GreaterThanOrEqualTo(String value) {
            addCriterion("col32 >=", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32LessThan(String value) {
            addCriterion("col32 <", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32LessThanOrEqualTo(String value) {
            addCriterion("col32 <=", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32Like(String value) {
            addCriterion("col32 like", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32NotLike(String value) {
            addCriterion("col32 not like", value, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32In(List<String> values) {
            addCriterion("col32 in", values, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32NotIn(List<String> values) {
            addCriterion("col32 not in", values, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32Between(String value1, String value2) {
            addCriterion("col32 between", value1, value2, "col32");
            return (Criteria) this;
        }

        public Criteria andCol32NotBetween(String value1, String value2) {
            addCriterion("col32 not between", value1, value2, "col32");
            return (Criteria) this;
        }

        public Criteria andCol33IsNull() {
            addCriterion("col33 is null");
            return (Criteria) this;
        }

        public Criteria andCol33IsNotNull() {
            addCriterion("col33 is not null");
            return (Criteria) this;
        }

        public Criteria andCol33EqualTo(String value) {
            addCriterion("col33 =", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33NotEqualTo(String value) {
            addCriterion("col33 <>", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33GreaterThan(String value) {
            addCriterion("col33 >", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33GreaterThanOrEqualTo(String value) {
            addCriterion("col33 >=", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33LessThan(String value) {
            addCriterion("col33 <", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33LessThanOrEqualTo(String value) {
            addCriterion("col33 <=", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33Like(String value) {
            addCriterion("col33 like", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33NotLike(String value) {
            addCriterion("col33 not like", value, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33In(List<String> values) {
            addCriterion("col33 in", values, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33NotIn(List<String> values) {
            addCriterion("col33 not in", values, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33Between(String value1, String value2) {
            addCriterion("col33 between", value1, value2, "col33");
            return (Criteria) this;
        }

        public Criteria andCol33NotBetween(String value1, String value2) {
            addCriterion("col33 not between", value1, value2, "col33");
            return (Criteria) this;
        }

        public Criteria andCol34IsNull() {
            addCriterion("col34 is null");
            return (Criteria) this;
        }

        public Criteria andCol34IsNotNull() {
            addCriterion("col34 is not null");
            return (Criteria) this;
        }

        public Criteria andCol34EqualTo(String value) {
            addCriterion("col34 =", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34NotEqualTo(String value) {
            addCriterion("col34 <>", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34GreaterThan(String value) {
            addCriterion("col34 >", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34GreaterThanOrEqualTo(String value) {
            addCriterion("col34 >=", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34LessThan(String value) {
            addCriterion("col34 <", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34LessThanOrEqualTo(String value) {
            addCriterion("col34 <=", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34Like(String value) {
            addCriterion("col34 like", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34NotLike(String value) {
            addCriterion("col34 not like", value, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34In(List<String> values) {
            addCriterion("col34 in", values, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34NotIn(List<String> values) {
            addCriterion("col34 not in", values, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34Between(String value1, String value2) {
            addCriterion("col34 between", value1, value2, "col34");
            return (Criteria) this;
        }

        public Criteria andCol34NotBetween(String value1, String value2) {
            addCriterion("col34 not between", value1, value2, "col34");
            return (Criteria) this;
        }

        public Criteria andCol35IsNull() {
            addCriterion("col35 is null");
            return (Criteria) this;
        }

        public Criteria andCol35IsNotNull() {
            addCriterion("col35 is not null");
            return (Criteria) this;
        }

        public Criteria andCol35EqualTo(String value) {
            addCriterion("col35 =", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35NotEqualTo(String value) {
            addCriterion("col35 <>", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35GreaterThan(String value) {
            addCriterion("col35 >", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35GreaterThanOrEqualTo(String value) {
            addCriterion("col35 >=", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35LessThan(String value) {
            addCriterion("col35 <", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35LessThanOrEqualTo(String value) {
            addCriterion("col35 <=", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35Like(String value) {
            addCriterion("col35 like", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35NotLike(String value) {
            addCriterion("col35 not like", value, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35In(List<String> values) {
            addCriterion("col35 in", values, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35NotIn(List<String> values) {
            addCriterion("col35 not in", values, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35Between(String value1, String value2) {
            addCriterion("col35 between", value1, value2, "col35");
            return (Criteria) this;
        }

        public Criteria andCol35NotBetween(String value1, String value2) {
            addCriterion("col35 not between", value1, value2, "col35");
            return (Criteria) this;
        }

        public Criteria andCol36IsNull() {
            addCriterion("col36 is null");
            return (Criteria) this;
        }

        public Criteria andCol36IsNotNull() {
            addCriterion("col36 is not null");
            return (Criteria) this;
        }

        public Criteria andCol36EqualTo(String value) {
            addCriterion("col36 =", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36NotEqualTo(String value) {
            addCriterion("col36 <>", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36GreaterThan(String value) {
            addCriterion("col36 >", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36GreaterThanOrEqualTo(String value) {
            addCriterion("col36 >=", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36LessThan(String value) {
            addCriterion("col36 <", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36LessThanOrEqualTo(String value) {
            addCriterion("col36 <=", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36Like(String value) {
            addCriterion("col36 like", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36NotLike(String value) {
            addCriterion("col36 not like", value, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36In(List<String> values) {
            addCriterion("col36 in", values, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36NotIn(List<String> values) {
            addCriterion("col36 not in", values, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36Between(String value1, String value2) {
            addCriterion("col36 between", value1, value2, "col36");
            return (Criteria) this;
        }

        public Criteria andCol36NotBetween(String value1, String value2) {
            addCriterion("col36 not between", value1, value2, "col36");
            return (Criteria) this;
        }

        public Criteria andCol37IsNull() {
            addCriterion("col37 is null");
            return (Criteria) this;
        }

        public Criteria andCol37IsNotNull() {
            addCriterion("col37 is not null");
            return (Criteria) this;
        }

        public Criteria andCol37EqualTo(String value) {
            addCriterion("col37 =", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37NotEqualTo(String value) {
            addCriterion("col37 <>", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37GreaterThan(String value) {
            addCriterion("col37 >", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37GreaterThanOrEqualTo(String value) {
            addCriterion("col37 >=", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37LessThan(String value) {
            addCriterion("col37 <", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37LessThanOrEqualTo(String value) {
            addCriterion("col37 <=", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37Like(String value) {
            addCriterion("col37 like", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37NotLike(String value) {
            addCriterion("col37 not like", value, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37In(List<String> values) {
            addCriterion("col37 in", values, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37NotIn(List<String> values) {
            addCriterion("col37 not in", values, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37Between(String value1, String value2) {
            addCriterion("col37 between", value1, value2, "col37");
            return (Criteria) this;
        }

        public Criteria andCol37NotBetween(String value1, String value2) {
            addCriterion("col37 not between", value1, value2, "col37");
            return (Criteria) this;
        }

        public Criteria andCol38IsNull() {
            addCriterion("col38 is null");
            return (Criteria) this;
        }

        public Criteria andCol38IsNotNull() {
            addCriterion("col38 is not null");
            return (Criteria) this;
        }

        public Criteria andCol38EqualTo(String value) {
            addCriterion("col38 =", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38NotEqualTo(String value) {
            addCriterion("col38 <>", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38GreaterThan(String value) {
            addCriterion("col38 >", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38GreaterThanOrEqualTo(String value) {
            addCriterion("col38 >=", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38LessThan(String value) {
            addCriterion("col38 <", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38LessThanOrEqualTo(String value) {
            addCriterion("col38 <=", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38Like(String value) {
            addCriterion("col38 like", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38NotLike(String value) {
            addCriterion("col38 not like", value, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38In(List<String> values) {
            addCriterion("col38 in", values, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38NotIn(List<String> values) {
            addCriterion("col38 not in", values, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38Between(String value1, String value2) {
            addCriterion("col38 between", value1, value2, "col38");
            return (Criteria) this;
        }

        public Criteria andCol38NotBetween(String value1, String value2) {
            addCriterion("col38 not between", value1, value2, "col38");
            return (Criteria) this;
        }

        public Criteria andCol39IsNull() {
            addCriterion("col39 is null");
            return (Criteria) this;
        }

        public Criteria andCol39IsNotNull() {
            addCriterion("col39 is not null");
            return (Criteria) this;
        }

        public Criteria andCol39EqualTo(String value) {
            addCriterion("col39 =", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39NotEqualTo(String value) {
            addCriterion("col39 <>", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39GreaterThan(String value) {
            addCriterion("col39 >", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39GreaterThanOrEqualTo(String value) {
            addCriterion("col39 >=", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39LessThan(String value) {
            addCriterion("col39 <", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39LessThanOrEqualTo(String value) {
            addCriterion("col39 <=", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39Like(String value) {
            addCriterion("col39 like", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39NotLike(String value) {
            addCriterion("col39 not like", value, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39In(List<String> values) {
            addCriterion("col39 in", values, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39NotIn(List<String> values) {
            addCriterion("col39 not in", values, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39Between(String value1, String value2) {
            addCriterion("col39 between", value1, value2, "col39");
            return (Criteria) this;
        }

        public Criteria andCol39NotBetween(String value1, String value2) {
            addCriterion("col39 not between", value1, value2, "col39");
            return (Criteria) this;
        }

        public Criteria andCol40IsNull() {
            addCriterion("col40 is null");
            return (Criteria) this;
        }

        public Criteria andCol40IsNotNull() {
            addCriterion("col40 is not null");
            return (Criteria) this;
        }

        public Criteria andCol40EqualTo(String value) {
            addCriterion("col40 =", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40NotEqualTo(String value) {
            addCriterion("col40 <>", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40GreaterThan(String value) {
            addCriterion("col40 >", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40GreaterThanOrEqualTo(String value) {
            addCriterion("col40 >=", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40LessThan(String value) {
            addCriterion("col40 <", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40LessThanOrEqualTo(String value) {
            addCriterion("col40 <=", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40Like(String value) {
            addCriterion("col40 like", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40NotLike(String value) {
            addCriterion("col40 not like", value, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40In(List<String> values) {
            addCriterion("col40 in", values, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40NotIn(List<String> values) {
            addCriterion("col40 not in", values, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40Between(String value1, String value2) {
            addCriterion("col40 between", value1, value2, "col40");
            return (Criteria) this;
        }

        public Criteria andCol40NotBetween(String value1, String value2) {
            addCriterion("col40 not between", value1, value2, "col40");
            return (Criteria) this;
        }

        public Criteria andCol41IsNull() {
            addCriterion("col41 is null");
            return (Criteria) this;
        }

        public Criteria andCol41IsNotNull() {
            addCriterion("col41 is not null");
            return (Criteria) this;
        }

        public Criteria andCol41EqualTo(String value) {
            addCriterion("col41 =", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41NotEqualTo(String value) {
            addCriterion("col41 <>", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41GreaterThan(String value) {
            addCriterion("col41 >", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41GreaterThanOrEqualTo(String value) {
            addCriterion("col41 >=", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41LessThan(String value) {
            addCriterion("col41 <", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41LessThanOrEqualTo(String value) {
            addCriterion("col41 <=", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41Like(String value) {
            addCriterion("col41 like", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41NotLike(String value) {
            addCriterion("col41 not like", value, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41In(List<String> values) {
            addCriterion("col41 in", values, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41NotIn(List<String> values) {
            addCriterion("col41 not in", values, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41Between(String value1, String value2) {
            addCriterion("col41 between", value1, value2, "col41");
            return (Criteria) this;
        }

        public Criteria andCol41NotBetween(String value1, String value2) {
            addCriterion("col41 not between", value1, value2, "col41");
            return (Criteria) this;
        }

        public Criteria andCol42IsNull() {
            addCriterion("col42 is null");
            return (Criteria) this;
        }

        public Criteria andCol42IsNotNull() {
            addCriterion("col42 is not null");
            return (Criteria) this;
        }

        public Criteria andCol42EqualTo(String value) {
            addCriterion("col42 =", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42NotEqualTo(String value) {
            addCriterion("col42 <>", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42GreaterThan(String value) {
            addCriterion("col42 >", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42GreaterThanOrEqualTo(String value) {
            addCriterion("col42 >=", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42LessThan(String value) {
            addCriterion("col42 <", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42LessThanOrEqualTo(String value) {
            addCriterion("col42 <=", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42Like(String value) {
            addCriterion("col42 like", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42NotLike(String value) {
            addCriterion("col42 not like", value, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42In(List<String> values) {
            addCriterion("col42 in", values, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42NotIn(List<String> values) {
            addCriterion("col42 not in", values, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42Between(String value1, String value2) {
            addCriterion("col42 between", value1, value2, "col42");
            return (Criteria) this;
        }

        public Criteria andCol42NotBetween(String value1, String value2) {
            addCriterion("col42 not between", value1, value2, "col42");
            return (Criteria) this;
        }

        public Criteria andCol43IsNull() {
            addCriterion("col43 is null");
            return (Criteria) this;
        }

        public Criteria andCol43IsNotNull() {
            addCriterion("col43 is not null");
            return (Criteria) this;
        }

        public Criteria andCol43EqualTo(String value) {
            addCriterion("col43 =", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43NotEqualTo(String value) {
            addCriterion("col43 <>", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43GreaterThan(String value) {
            addCriterion("col43 >", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43GreaterThanOrEqualTo(String value) {
            addCriterion("col43 >=", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43LessThan(String value) {
            addCriterion("col43 <", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43LessThanOrEqualTo(String value) {
            addCriterion("col43 <=", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43Like(String value) {
            addCriterion("col43 like", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43NotLike(String value) {
            addCriterion("col43 not like", value, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43In(List<String> values) {
            addCriterion("col43 in", values, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43NotIn(List<String> values) {
            addCriterion("col43 not in", values, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43Between(String value1, String value2) {
            addCriterion("col43 between", value1, value2, "col43");
            return (Criteria) this;
        }

        public Criteria andCol43NotBetween(String value1, String value2) {
            addCriterion("col43 not between", value1, value2, "col43");
            return (Criteria) this;
        }

        public Criteria andCol44IsNull() {
            addCriterion("col44 is null");
            return (Criteria) this;
        }

        public Criteria andCol44IsNotNull() {
            addCriterion("col44 is not null");
            return (Criteria) this;
        }

        public Criteria andCol44EqualTo(String value) {
            addCriterion("col44 =", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44NotEqualTo(String value) {
            addCriterion("col44 <>", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44GreaterThan(String value) {
            addCriterion("col44 >", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44GreaterThanOrEqualTo(String value) {
            addCriterion("col44 >=", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44LessThan(String value) {
            addCriterion("col44 <", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44LessThanOrEqualTo(String value) {
            addCriterion("col44 <=", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44Like(String value) {
            addCriterion("col44 like", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44NotLike(String value) {
            addCriterion("col44 not like", value, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44In(List<String> values) {
            addCriterion("col44 in", values, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44NotIn(List<String> values) {
            addCriterion("col44 not in", values, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44Between(String value1, String value2) {
            addCriterion("col44 between", value1, value2, "col44");
            return (Criteria) this;
        }

        public Criteria andCol44NotBetween(String value1, String value2) {
            addCriterion("col44 not between", value1, value2, "col44");
            return (Criteria) this;
        }

        public Criteria andCol45IsNull() {
            addCriterion("col45 is null");
            return (Criteria) this;
        }

        public Criteria andCol45IsNotNull() {
            addCriterion("col45 is not null");
            return (Criteria) this;
        }

        public Criteria andCol45EqualTo(String value) {
            addCriterion("col45 =", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45NotEqualTo(String value) {
            addCriterion("col45 <>", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45GreaterThan(String value) {
            addCriterion("col45 >", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45GreaterThanOrEqualTo(String value) {
            addCriterion("col45 >=", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45LessThan(String value) {
            addCriterion("col45 <", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45LessThanOrEqualTo(String value) {
            addCriterion("col45 <=", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45Like(String value) {
            addCriterion("col45 like", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45NotLike(String value) {
            addCriterion("col45 not like", value, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45In(List<String> values) {
            addCriterion("col45 in", values, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45NotIn(List<String> values) {
            addCriterion("col45 not in", values, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45Between(String value1, String value2) {
            addCriterion("col45 between", value1, value2, "col45");
            return (Criteria) this;
        }

        public Criteria andCol45NotBetween(String value1, String value2) {
            addCriterion("col45 not between", value1, value2, "col45");
            return (Criteria) this;
        }

        public Criteria andCol46IsNull() {
            addCriterion("col46 is null");
            return (Criteria) this;
        }

        public Criteria andCol46IsNotNull() {
            addCriterion("col46 is not null");
            return (Criteria) this;
        }

        public Criteria andCol46EqualTo(String value) {
            addCriterion("col46 =", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46NotEqualTo(String value) {
            addCriterion("col46 <>", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46GreaterThan(String value) {
            addCriterion("col46 >", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46GreaterThanOrEqualTo(String value) {
            addCriterion("col46 >=", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46LessThan(String value) {
            addCriterion("col46 <", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46LessThanOrEqualTo(String value) {
            addCriterion("col46 <=", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46Like(String value) {
            addCriterion("col46 like", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46NotLike(String value) {
            addCriterion("col46 not like", value, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46In(List<String> values) {
            addCriterion("col46 in", values, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46NotIn(List<String> values) {
            addCriterion("col46 not in", values, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46Between(String value1, String value2) {
            addCriterion("col46 between", value1, value2, "col46");
            return (Criteria) this;
        }

        public Criteria andCol46NotBetween(String value1, String value2) {
            addCriterion("col46 not between", value1, value2, "col46");
            return (Criteria) this;
        }

        public Criteria andCol47IsNull() {
            addCriterion("col47 is null");
            return (Criteria) this;
        }

        public Criteria andCol47IsNotNull() {
            addCriterion("col47 is not null");
            return (Criteria) this;
        }

        public Criteria andCol47EqualTo(String value) {
            addCriterion("col47 =", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47NotEqualTo(String value) {
            addCriterion("col47 <>", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47GreaterThan(String value) {
            addCriterion("col47 >", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47GreaterThanOrEqualTo(String value) {
            addCriterion("col47 >=", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47LessThan(String value) {
            addCriterion("col47 <", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47LessThanOrEqualTo(String value) {
            addCriterion("col47 <=", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47Like(String value) {
            addCriterion("col47 like", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47NotLike(String value) {
            addCriterion("col47 not like", value, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47In(List<String> values) {
            addCriterion("col47 in", values, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47NotIn(List<String> values) {
            addCriterion("col47 not in", values, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47Between(String value1, String value2) {
            addCriterion("col47 between", value1, value2, "col47");
            return (Criteria) this;
        }

        public Criteria andCol47NotBetween(String value1, String value2) {
            addCriterion("col47 not between", value1, value2, "col47");
            return (Criteria) this;
        }

        public Criteria andCol48IsNull() {
            addCriterion("col48 is null");
            return (Criteria) this;
        }

        public Criteria andCol48IsNotNull() {
            addCriterion("col48 is not null");
            return (Criteria) this;
        }

        public Criteria andCol48EqualTo(String value) {
            addCriterion("col48 =", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48NotEqualTo(String value) {
            addCriterion("col48 <>", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48GreaterThan(String value) {
            addCriterion("col48 >", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48GreaterThanOrEqualTo(String value) {
            addCriterion("col48 >=", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48LessThan(String value) {
            addCriterion("col48 <", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48LessThanOrEqualTo(String value) {
            addCriterion("col48 <=", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48Like(String value) {
            addCriterion("col48 like", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48NotLike(String value) {
            addCriterion("col48 not like", value, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48In(List<String> values) {
            addCriterion("col48 in", values, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48NotIn(List<String> values) {
            addCriterion("col48 not in", values, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48Between(String value1, String value2) {
            addCriterion("col48 between", value1, value2, "col48");
            return (Criteria) this;
        }

        public Criteria andCol48NotBetween(String value1, String value2) {
            addCriterion("col48 not between", value1, value2, "col48");
            return (Criteria) this;
        }

        public Criteria andCol49IsNull() {
            addCriterion("col49 is null");
            return (Criteria) this;
        }

        public Criteria andCol49IsNotNull() {
            addCriterion("col49 is not null");
            return (Criteria) this;
        }

        public Criteria andCol49EqualTo(String value) {
            addCriterion("col49 =", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49NotEqualTo(String value) {
            addCriterion("col49 <>", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49GreaterThan(String value) {
            addCriterion("col49 >", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49GreaterThanOrEqualTo(String value) {
            addCriterion("col49 >=", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49LessThan(String value) {
            addCriterion("col49 <", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49LessThanOrEqualTo(String value) {
            addCriterion("col49 <=", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49Like(String value) {
            addCriterion("col49 like", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49NotLike(String value) {
            addCriterion("col49 not like", value, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49In(List<String> values) {
            addCriterion("col49 in", values, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49NotIn(List<String> values) {
            addCriterion("col49 not in", values, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49Between(String value1, String value2) {
            addCriterion("col49 between", value1, value2, "col49");
            return (Criteria) this;
        }

        public Criteria andCol49NotBetween(String value1, String value2) {
            addCriterion("col49 not between", value1, value2, "col49");
            return (Criteria) this;
        }

        public Criteria andCol50IsNull() {
            addCriterion("col50 is null");
            return (Criteria) this;
        }

        public Criteria andCol50IsNotNull() {
            addCriterion("col50 is not null");
            return (Criteria) this;
        }

        public Criteria andCol50EqualTo(String value) {
            addCriterion("col50 =", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50NotEqualTo(String value) {
            addCriterion("col50 <>", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50GreaterThan(String value) {
            addCriterion("col50 >", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50GreaterThanOrEqualTo(String value) {
            addCriterion("col50 >=", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50LessThan(String value) {
            addCriterion("col50 <", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50LessThanOrEqualTo(String value) {
            addCriterion("col50 <=", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50Like(String value) {
            addCriterion("col50 like", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50NotLike(String value) {
            addCriterion("col50 not like", value, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50In(List<String> values) {
            addCriterion("col50 in", values, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50NotIn(List<String> values) {
            addCriterion("col50 not in", values, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50Between(String value1, String value2) {
            addCriterion("col50 between", value1, value2, "col50");
            return (Criteria) this;
        }

        public Criteria andCol50NotBetween(String value1, String value2) {
            addCriterion("col50 not between", value1, value2, "col50");
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