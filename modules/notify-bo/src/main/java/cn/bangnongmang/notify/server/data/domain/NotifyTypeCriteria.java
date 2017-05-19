package cn.bangnongmang.notify.server.data.domain;

import java.util.ArrayList;
import java.util.List;

public class NotifyTypeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotifyTypeCriteria() {
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

        public Criteria andType_nameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andType_nameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andType_nameEqualTo(String value) {
            addCriterion("type_name =", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameGreaterThan(String value) {
            addCriterion("type_name >", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLessThan(String value) {
            addCriterion("type_name <", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLike(String value) {
            addCriterion("type_name like", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotLike(String value) {
            addCriterion("type_name not like", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameIn(List<String> values) {
            addCriterion("type_name in", values, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "type_name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintIsNull() {
            addCriterion("patternConstraint is null");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintIsNotNull() {
            addCriterion("patternConstraint is not null");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintEqualTo(String value) {
            addCriterion("patternConstraint =", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintNotEqualTo(String value) {
            addCriterion("patternConstraint <>", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintGreaterThan(String value) {
            addCriterion("patternConstraint >", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintGreaterThanOrEqualTo(String value) {
            addCriterion("patternConstraint >=", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintLessThan(String value) {
            addCriterion("patternConstraint <", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintLessThanOrEqualTo(String value) {
            addCriterion("patternConstraint <=", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintLike(String value) {
            addCriterion("patternConstraint like", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintNotLike(String value) {
            addCriterion("patternConstraint not like", value, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintIn(List<String> values) {
            addCriterion("patternConstraint in", values, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintNotIn(List<String> values) {
            addCriterion("patternConstraint not in", values, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintBetween(String value1, String value2) {
            addCriterion("patternConstraint between", value1, value2, "patternConstraint");
            return (Criteria) this;
        }

        public Criteria andPatternConstraintNotBetween(String value1, String value2) {
            addCriterion("patternConstraint not between", value1, value2, "patternConstraint");
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