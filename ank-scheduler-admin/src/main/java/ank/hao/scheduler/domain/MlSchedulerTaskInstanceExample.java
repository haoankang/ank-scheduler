package ank.hao.scheduler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlSchedulerTaskInstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlSchedulerTaskInstanceExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andTaskInstanceIdIsNull() {
            addCriterion("TASK_INSTANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdIsNotNull() {
            addCriterion("TASK_INSTANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_ID =", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdNotEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_ID <>", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdGreaterThan(Integer value) {
            addCriterion("TASK_INSTANCE_ID >", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_ID >=", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdLessThan(Integer value) {
            addCriterion("TASK_INSTANCE_ID <", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_ID <=", value, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdIn(List<Integer> values) {
            addCriterion("TASK_INSTANCE_ID in", values, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdNotIn(List<Integer> values) {
            addCriterion("TASK_INSTANCE_ID not in", values, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdBetween(Integer value1, Integer value2) {
            addCriterion("TASK_INSTANCE_ID between", value1, value2, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_INSTANCE_ID not between", value1, value2, "taskInstanceId");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNull() {
            addCriterion("JOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("JOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(Integer value) {
            addCriterion("JOB_ID =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(Integer value) {
            addCriterion("JOB_ID <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(Integer value) {
            addCriterion("JOB_ID >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_ID >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(Integer value) {
            addCriterion("JOB_ID <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_ID <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<Integer> values) {
            addCriterion("JOB_ID in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<Integer> values) {
            addCriterion("JOB_ID not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(Integer value1, Integer value2) {
            addCriterion("JOB_ID between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_ID not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdIsNull() {
            addCriterion("PRE_TASK_INSTANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdIsNotNull() {
            addCriterion("PRE_TASK_INSTANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdEqualTo(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID =", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdNotEqualTo(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID <>", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdGreaterThan(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID >", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID >=", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdLessThan(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID <", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID <=", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdLike(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID like", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdNotLike(String value) {
            addCriterion("PRE_TASK_INSTANCE_ID not like", value, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdIn(List<String> values) {
            addCriterion("PRE_TASK_INSTANCE_ID in", values, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdNotIn(List<String> values) {
            addCriterion("PRE_TASK_INSTANCE_ID not in", values, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdBetween(String value1, String value2) {
            addCriterion("PRE_TASK_INSTANCE_ID between", value1, value2, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andPreTaskInstanceIdNotBetween(String value1, String value2) {
            addCriterion("PRE_TASK_INSTANCE_ID not between", value1, value2, "preTaskInstanceId");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNull() {
            addCriterion("INPUT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("INPUT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(String value) {
            addCriterion("INPUT_TYPE =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(String value) {
            addCriterion("INPUT_TYPE <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(String value) {
            addCriterion("INPUT_TYPE >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(String value) {
            addCriterion("INPUT_TYPE <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLike(String value) {
            addCriterion("INPUT_TYPE like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotLike(String value) {
            addCriterion("INPUT_TYPE not like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<String> values) {
            addCriterion("INPUT_TYPE in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<String> values) {
            addCriterion("INPUT_TYPE not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE not between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andRouteStategyIsNull() {
            addCriterion("ROUTE_STATEGY is null");
            return (Criteria) this;
        }

        public Criteria andRouteStategyIsNotNull() {
            addCriterion("ROUTE_STATEGY is not null");
            return (Criteria) this;
        }

        public Criteria andRouteStategyEqualTo(Integer value) {
            addCriterion("ROUTE_STATEGY =", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyNotEqualTo(Integer value) {
            addCriterion("ROUTE_STATEGY <>", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyGreaterThan(Integer value) {
            addCriterion("ROUTE_STATEGY >", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROUTE_STATEGY >=", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyLessThan(Integer value) {
            addCriterion("ROUTE_STATEGY <", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyLessThanOrEqualTo(Integer value) {
            addCriterion("ROUTE_STATEGY <=", value, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyIn(List<Integer> values) {
            addCriterion("ROUTE_STATEGY in", values, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyNotIn(List<Integer> values) {
            addCriterion("ROUTE_STATEGY not in", values, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyBetween(Integer value1, Integer value2) {
            addCriterion("ROUTE_STATEGY between", value1, value2, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andRouteStategyNotBetween(Integer value1, Integer value2) {
            addCriterion("ROUTE_STATEGY not between", value1, value2, "routeStategy");
            return (Criteria) this;
        }

        public Criteria andFailoverIsNull() {
            addCriterion("FAILOVER is null");
            return (Criteria) this;
        }

        public Criteria andFailoverIsNotNull() {
            addCriterion("FAILOVER is not null");
            return (Criteria) this;
        }

        public Criteria andFailoverEqualTo(Integer value) {
            addCriterion("FAILOVER =", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverNotEqualTo(Integer value) {
            addCriterion("FAILOVER <>", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverGreaterThan(Integer value) {
            addCriterion("FAILOVER >", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAILOVER >=", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverLessThan(Integer value) {
            addCriterion("FAILOVER <", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverLessThanOrEqualTo(Integer value) {
            addCriterion("FAILOVER <=", value, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverIn(List<Integer> values) {
            addCriterion("FAILOVER in", values, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverNotIn(List<Integer> values) {
            addCriterion("FAILOVER not in", values, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverBetween(Integer value1, Integer value2) {
            addCriterion("FAILOVER between", value1, value2, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverNotBetween(Integer value1, Integer value2) {
            addCriterion("FAILOVER not between", value1, value2, "failover");
            return (Criteria) this;
        }

        public Criteria andFailoverValueIsNull() {
            addCriterion("FAILOVER_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andFailoverValueIsNotNull() {
            addCriterion("FAILOVER_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andFailoverValueEqualTo(String value) {
            addCriterion("FAILOVER_VALUE =", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueNotEqualTo(String value) {
            addCriterion("FAILOVER_VALUE <>", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueGreaterThan(String value) {
            addCriterion("FAILOVER_VALUE >", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueGreaterThanOrEqualTo(String value) {
            addCriterion("FAILOVER_VALUE >=", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueLessThan(String value) {
            addCriterion("FAILOVER_VALUE <", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueLessThanOrEqualTo(String value) {
            addCriterion("FAILOVER_VALUE <=", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueLike(String value) {
            addCriterion("FAILOVER_VALUE like", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueNotLike(String value) {
            addCriterion("FAILOVER_VALUE not like", value, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueIn(List<String> values) {
            addCriterion("FAILOVER_VALUE in", values, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueNotIn(List<String> values) {
            addCriterion("FAILOVER_VALUE not in", values, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueBetween(String value1, String value2) {
            addCriterion("FAILOVER_VALUE between", value1, value2, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andFailoverValueNotBetween(String value1, String value2) {
            addCriterion("FAILOVER_VALUE not between", value1, value2, "failoverValue");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutIsNull() {
            addCriterion("READ_TIMEOUT is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutIsNotNull() {
            addCriterion("READ_TIMEOUT is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutEqualTo(Integer value) {
            addCriterion("READ_TIMEOUT =", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutNotEqualTo(Integer value) {
            addCriterion("READ_TIMEOUT <>", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutGreaterThan(Integer value) {
            addCriterion("READ_TIMEOUT >", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("READ_TIMEOUT >=", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutLessThan(Integer value) {
            addCriterion("READ_TIMEOUT <", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("READ_TIMEOUT <=", value, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutIn(List<Integer> values) {
            addCriterion("READ_TIMEOUT in", values, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutNotIn(List<Integer> values) {
            addCriterion("READ_TIMEOUT not in", values, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("READ_TIMEOUT between", value1, value2, "readTimeout");
            return (Criteria) this;
        }

        public Criteria andReadTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("READ_TIMEOUT not between", value1, value2, "readTimeout");
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