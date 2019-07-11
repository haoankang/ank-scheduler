package ank.hao.scheduler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlSchedulerTaskInstanceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlSchedulerTaskInstanceLogExample() {
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

        public Criteria andTaskInstanceLogIdIsNull() {
            addCriterion("TASK_INSTANCE_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdIsNotNull() {
            addCriterion("TASK_INSTANCE_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID =", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdNotEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID <>", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdGreaterThan(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID >", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID >=", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdLessThan(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID <", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_INSTANCE_LOG_ID <=", value, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdIn(List<Integer> values) {
            addCriterion("TASK_INSTANCE_LOG_ID in", values, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdNotIn(List<Integer> values) {
            addCriterion("TASK_INSTANCE_LOG_ID not in", values, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdBetween(Integer value1, Integer value2) {
            addCriterion("TASK_INSTANCE_LOG_ID between", value1, value2, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andTaskInstanceLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_INSTANCE_LOG_ID not between", value1, value2, "taskInstanceLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdIsNull() {
            addCriterion("JOB_LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobLogIdIsNotNull() {
            addCriterion("JOB_LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobLogIdEqualTo(Integer value) {
            addCriterion("JOB_LOG_ID =", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotEqualTo(Integer value) {
            addCriterion("JOB_LOG_ID <>", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdGreaterThan(Integer value) {
            addCriterion("JOB_LOG_ID >", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_LOG_ID >=", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdLessThan(Integer value) {
            addCriterion("JOB_LOG_ID <", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_LOG_ID <=", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdIn(List<Integer> values) {
            addCriterion("JOB_LOG_ID in", values, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotIn(List<Integer> values) {
            addCriterion("JOB_LOG_ID not in", values, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdBetween(Integer value1, Integer value2) {
            addCriterion("JOB_LOG_ID between", value1, value2, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_LOG_ID not between", value1, value2, "jobLogId");
            return (Criteria) this;
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

        public Criteria andDependIdIsNull() {
            addCriterion("DEPEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andDependIdIsNotNull() {
            addCriterion("DEPEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDependIdEqualTo(Integer value) {
            addCriterion("DEPEND_ID =", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdNotEqualTo(Integer value) {
            addCriterion("DEPEND_ID <>", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdGreaterThan(Integer value) {
            addCriterion("DEPEND_ID >", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPEND_ID >=", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdLessThan(Integer value) {
            addCriterion("DEPEND_ID <", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPEND_ID <=", value, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdIn(List<Integer> values) {
            addCriterion("DEPEND_ID in", values, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdNotIn(List<Integer> values) {
            addCriterion("DEPEND_ID not in", values, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPEND_ID between", value1, value2, "dependId");
            return (Criteria) this;
        }

        public Criteria andDependIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPEND_ID not between", value1, value2, "dependId");
            return (Criteria) this;
        }

        public Criteria andTaskMsgIsNull() {
            addCriterion("TASK_MSG is null");
            return (Criteria) this;
        }

        public Criteria andTaskMsgIsNotNull() {
            addCriterion("TASK_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andTaskMsgEqualTo(String value) {
            addCriterion("TASK_MSG =", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgNotEqualTo(String value) {
            addCriterion("TASK_MSG <>", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgGreaterThan(String value) {
            addCriterion("TASK_MSG >", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_MSG >=", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgLessThan(String value) {
            addCriterion("TASK_MSG <", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgLessThanOrEqualTo(String value) {
            addCriterion("TASK_MSG <=", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgLike(String value) {
            addCriterion("TASK_MSG like", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgNotLike(String value) {
            addCriterion("TASK_MSG not like", value, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgIn(List<String> values) {
            addCriterion("TASK_MSG in", values, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgNotIn(List<String> values) {
            addCriterion("TASK_MSG not in", values, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgBetween(String value1, String value2) {
            addCriterion("TASK_MSG between", value1, value2, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskMsgNotBetween(String value1, String value2) {
            addCriterion("TASK_MSG not between", value1, value2, "taskMsg");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("TASK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("TASK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(Integer value) {
            addCriterion("TASK_STATE =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(Integer value) {
            addCriterion("TASK_STATE <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(Integer value) {
            addCriterion("TASK_STATE >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATE >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(Integer value) {
            addCriterion("TASK_STATE <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_STATE <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<Integer> values) {
            addCriterion("TASK_STATE in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<Integer> values) {
            addCriterion("TASK_STATE not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATE between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_STATE not between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeIsNull() {
            addCriterion("TASK_HANDLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeIsNotNull() {
            addCriterion("TASK_HANDLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeEqualTo(Date value) {
            addCriterion("TASK_HANDLE_TIME =", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeNotEqualTo(Date value) {
            addCriterion("TASK_HANDLE_TIME <>", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeGreaterThan(Date value) {
            addCriterion("TASK_HANDLE_TIME >", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_HANDLE_TIME >=", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeLessThan(Date value) {
            addCriterion("TASK_HANDLE_TIME <", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_HANDLE_TIME <=", value, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeIn(List<Date> values) {
            addCriterion("TASK_HANDLE_TIME in", values, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeNotIn(List<Date> values) {
            addCriterion("TASK_HANDLE_TIME not in", values, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeBetween(Date value1, Date value2) {
            addCriterion("TASK_HANDLE_TIME between", value1, value2, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_HANDLE_TIME not between", value1, value2, "taskHandleTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeIsNull() {
            addCriterion("TASK_FINISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeIsNotNull() {
            addCriterion("TASK_FINISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeEqualTo(Date value) {
            addCriterion("TASK_FINISH_TIME =", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeNotEqualTo(Date value) {
            addCriterion("TASK_FINISH_TIME <>", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeGreaterThan(Date value) {
            addCriterion("TASK_FINISH_TIME >", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TASK_FINISH_TIME >=", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeLessThan(Date value) {
            addCriterion("TASK_FINISH_TIME <", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("TASK_FINISH_TIME <=", value, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeIn(List<Date> values) {
            addCriterion("TASK_FINISH_TIME in", values, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeNotIn(List<Date> values) {
            addCriterion("TASK_FINISH_TIME not in", values, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeBetween(Date value1, Date value2) {
            addCriterion("TASK_FINISH_TIME between", value1, value2, "taskFinishTime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("TASK_FINISH_TIME not between", value1, value2, "taskFinishTime");
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

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
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