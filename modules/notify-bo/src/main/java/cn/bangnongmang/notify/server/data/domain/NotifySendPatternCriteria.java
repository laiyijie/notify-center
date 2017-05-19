package cn.bangnongmang.notify.server.data.domain;

import java.util.ArrayList;
import java.util.List;

public class NotifySendPatternCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotifySendPatternCriteria() {
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

        public Criteria andHook_nameIsNull() {
            addCriterion("hook_name is null");
            return (Criteria) this;
        }

        public Criteria andHook_nameIsNotNull() {
            addCriterion("hook_name is not null");
            return (Criteria) this;
        }

        public Criteria andHook_nameEqualTo(String value) {
            addCriterion("hook_name =", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameNotEqualTo(String value) {
            addCriterion("hook_name <>", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameGreaterThan(String value) {
            addCriterion("hook_name >", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameGreaterThanOrEqualTo(String value) {
            addCriterion("hook_name >=", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameLessThan(String value) {
            addCriterion("hook_name <", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameLessThanOrEqualTo(String value) {
            addCriterion("hook_name <=", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameLike(String value) {
            addCriterion("hook_name like", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameNotLike(String value) {
            addCriterion("hook_name not like", value, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameIn(List<String> values) {
            addCriterion("hook_name in", values, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameNotIn(List<String> values) {
            addCriterion("hook_name not in", values, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameBetween(String value1, String value2) {
            addCriterion("hook_name between", value1, value2, "hook_name");
            return (Criteria) this;
        }

        public Criteria andHook_nameNotBetween(String value1, String value2) {
            addCriterion("hook_name not between", value1, value2, "hook_name");
            return (Criteria) this;
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

        public Criteria andPatternIsNull() {
            addCriterion("pattern is null");
            return (Criteria) this;
        }

        public Criteria andPatternIsNotNull() {
            addCriterion("pattern is not null");
            return (Criteria) this;
        }

        public Criteria andPatternEqualTo(String value) {
            addCriterion("pattern =", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotEqualTo(String value) {
            addCriterion("pattern <>", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThan(String value) {
            addCriterion("pattern >", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternGreaterThanOrEqualTo(String value) {
            addCriterion("pattern >=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThan(String value) {
            addCriterion("pattern <", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLessThanOrEqualTo(String value) {
            addCriterion("pattern <=", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternLike(String value) {
            addCriterion("pattern like", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotLike(String value) {
            addCriterion("pattern not like", value, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternIn(List<String> values) {
            addCriterion("pattern in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotIn(List<String> values) {
            addCriterion("pattern not in", values, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternBetween(String value1, String value2) {
            addCriterion("pattern between", value1, value2, "pattern");
            return (Criteria) this;
        }

        public Criteria andPatternNotBetween(String value1, String value2) {
            addCriterion("pattern not between", value1, value2, "pattern");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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