package ank.hao.scheduler.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlSchedulerJobLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MlSchedulerJobLogExample() {
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

        public Criteria andJobPidIsNull() {
            addCriterion("JOB_PID is null");
            return (Criteria) this;
        }

        public Criteria andJobPidIsNotNull() {
            addCriterion("JOB_PID is not null");
            return (Criteria) this;
        }

        public Criteria andJobPidEqualTo(Integer value) {
            addCriterion("JOB_PID =", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidNotEqualTo(Integer value) {
            addCriterion("JOB_PID <>", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidGreaterThan(Integer value) {
            addCriterion("JOB_PID >", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_PID >=", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidLessThan(Integer value) {
            addCriterion("JOB_PID <", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_PID <=", value, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidIn(List<Integer> values) {
            addCriterion("JOB_PID in", values, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidNotIn(List<Integer> values) {
            addCriterion("JOB_PID not in", values, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidBetween(Integer value1, Integer value2) {
            addCriterion("JOB_PID between", value1, value2, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobPidNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_PID not between", value1, value2, "jobPid");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeIsNull() {
            addCriterion("JOB_TRIGGER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeIsNotNull() {
            addCriterion("JOB_TRIGGER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeEqualTo(Date value) {
            addCriterion("JOB_TRIGGER_TIME =", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeNotEqualTo(Date value) {
            addCriterion("JOB_TRIGGER_TIME <>", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeGreaterThan(Date value) {
            addCriterion("JOB_TRIGGER_TIME >", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_TRIGGER_TIME >=", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeLessThan(Date value) {
            addCriterion("JOB_TRIGGER_TIME <", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_TRIGGER_TIME <=", value, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeIn(List<Date> values) {
            addCriterion("JOB_TRIGGER_TIME in", values, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeNotIn(List<Date> values) {
            addCriterion("JOB_TRIGGER_TIME not in", values, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_TRIGGER_TIME between", value1, value2, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobTriggerTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_TRIGGER_TIME not between", value1, value2, "jobTriggerTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateIsNull() {
            addCriterion("JOB_HANDLE_STATE is null");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateIsNotNull() {
            addCriterion("JOB_HANDLE_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateEqualTo(Integer value) {
            addCriterion("JOB_HANDLE_STATE =", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateNotEqualTo(Integer value) {
            addCriterion("JOB_HANDLE_STATE <>", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateGreaterThan(Integer value) {
            addCriterion("JOB_HANDLE_STATE >", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_HANDLE_STATE >=", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateLessThan(Integer value) {
            addCriterion("JOB_HANDLE_STATE <", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_HANDLE_STATE <=", value, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateIn(List<Integer> values) {
            addCriterion("JOB_HANDLE_STATE in", values, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateNotIn(List<Integer> values) {
            addCriterion("JOB_HANDLE_STATE not in", values, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateBetween(Integer value1, Integer value2) {
            addCriterion("JOB_HANDLE_STATE between", value1, value2, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_HANDLE_STATE not between", value1, value2, "jobHandleState");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgIsNull() {
            addCriterion("JOB_HANDLE_MSG is null");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgIsNotNull() {
            addCriterion("JOB_HANDLE_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgEqualTo(String value) {
            addCriterion("JOB_HANDLE_MSG =", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgNotEqualTo(String value) {
            addCriterion("JOB_HANDLE_MSG <>", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgGreaterThan(String value) {
            addCriterion("JOB_HANDLE_MSG >", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgGreaterThanOrEqualTo(String value) {
            addCriterion("JOB_HANDLE_MSG >=", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgLessThan(String value) {
            addCriterion("JOB_HANDLE_MSG <", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgLessThanOrEqualTo(String value) {
            addCriterion("JOB_HANDLE_MSG <=", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgLike(String value) {
            addCriterion("JOB_HANDLE_MSG like", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgNotLike(String value) {
            addCriterion("JOB_HANDLE_MSG not like", value, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgIn(List<String> values) {
            addCriterion("JOB_HANDLE_MSG in", values, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgNotIn(List<String> values) {
            addCriterion("JOB_HANDLE_MSG not in", values, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgBetween(String value1, String value2) {
            addCriterion("JOB_HANDLE_MSG between", value1, value2, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleMsgNotBetween(String value1, String value2) {
            addCriterion("JOB_HANDLE_MSG not between", value1, value2, "jobHandleMsg");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeIsNull() {
            addCriterion("JOB_HANDLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeIsNotNull() {
            addCriterion("JOB_HANDLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeEqualTo(Date value) {
            addCriterion("JOB_HANDLE_TIME =", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeNotEqualTo(Date value) {
            addCriterion("JOB_HANDLE_TIME <>", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeGreaterThan(Date value) {
            addCriterion("JOB_HANDLE_TIME >", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_HANDLE_TIME >=", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeLessThan(Date value) {
            addCriterion("JOB_HANDLE_TIME <", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_HANDLE_TIME <=", value, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeIn(List<Date> values) {
            addCriterion("JOB_HANDLE_TIME in", values, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeNotIn(List<Date> values) {
            addCriterion("JOB_HANDLE_TIME not in", values, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_HANDLE_TIME between", value1, value2, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_HANDLE_TIME not between", value1, value2, "jobHandleTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeIsNull() {
            addCriterion("JOB_HANDLE_FINISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeIsNotNull() {
            addCriterion("JOB_HANDLE_FINISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeEqualTo(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME =", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeNotEqualTo(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME <>", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeGreaterThan(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME >", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME >=", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeLessThan(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME <", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("JOB_HANDLE_FINISH_TIME <=", value, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeIn(List<Date> values) {
            addCriterion("JOB_HANDLE_FINISH_TIME in", values, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeNotIn(List<Date> values) {
            addCriterion("JOB_HANDLE_FINISH_TIME not in", values, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeBetween(Date value1, Date value2) {
            addCriterion("JOB_HANDLE_FINISH_TIME between", value1, value2, "jobHandleFinishTime");
            return (Criteria) this;
        }

        public Criteria andJobHandleFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("JOB_HANDLE_FINISH_TIME not between", value1, value2, "jobHandleFinishTime");
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