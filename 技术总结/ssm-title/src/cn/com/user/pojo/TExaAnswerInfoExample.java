package cn.com.user.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TExaAnswerInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public TExaAnswerInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAnswerIdIsNull() {
            addCriterion("ANSWER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("ANSWER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(String value) {
            addCriterion("ANSWER_ID =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(String value) {
            addCriterion("ANSWER_ID <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(String value) {
            addCriterion("ANSWER_ID >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(String value) {
            addCriterion("ANSWER_ID <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLike(String value) {
            addCriterion("ANSWER_ID like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotLike(String value) {
            addCriterion("ANSWER_ID not like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<String> values) {
            addCriterion("ANSWER_ID in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<String> values) {
            addCriterion("ANSWER_ID not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(String value1, String value2) {
            addCriterion("ANSWER_ID between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(String value1, String value2) {
            addCriterion("ANSWER_ID not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIsNull() {
            addCriterion("QUESTION_NO is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIsNotNull() {
            addCriterion("QUESTION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNoEqualTo(String value) {
            addCriterion("QUESTION_NO =", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotEqualTo(String value) {
            addCriterion("QUESTION_NO <>", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoGreaterThan(String value) {
            addCriterion("QUESTION_NO >", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_NO >=", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoLessThan(String value) {
            addCriterion("QUESTION_NO <", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_NO <=", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoLike(String value) {
            addCriterion("QUESTION_NO like", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotLike(String value) {
            addCriterion("QUESTION_NO not like", value, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoIn(List<String> values) {
            addCriterion("QUESTION_NO in", values, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotIn(List<String> values) {
            addCriterion("QUESTION_NO not in", values, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoBetween(String value1, String value2) {
            addCriterion("QUESTION_NO between", value1, value2, "questionNo");
            return (Criteria) this;
        }

        public Criteria andQuestionNoNotBetween(String value1, String value2) {
            addCriterion("QUESTION_NO not between", value1, value2, "questionNo");
            return (Criteria) this;
        }

        public Criteria andAnswerNumIsNull() {
            addCriterion("ANSWER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNumIsNotNull() {
            addCriterion("ANSWER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNumEqualTo(BigDecimal value) {
            addCriterion("ANSWER_NUM =", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotEqualTo(BigDecimal value) {
            addCriterion("ANSWER_NUM <>", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumGreaterThan(BigDecimal value) {
            addCriterion("ANSWER_NUM >", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANSWER_NUM >=", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumLessThan(BigDecimal value) {
            addCriterion("ANSWER_NUM <", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANSWER_NUM <=", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumIn(List<BigDecimal> values) {
            addCriterion("ANSWER_NUM in", values, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotIn(List<BigDecimal> values) {
            addCriterion("ANSWER_NUM not in", values, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANSWER_NUM between", value1, value2, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANSWER_NUM not between", value1, value2, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNull() {
            addCriterion("ANSWER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNotNull() {
            addCriterion("ANSWER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameEqualTo(String value) {
            addCriterion("ANSWER_NAME =", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotEqualTo(String value) {
            addCriterion("ANSWER_NAME <>", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThan(String value) {
            addCriterion("ANSWER_NAME >", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_NAME >=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThan(String value) {
            addCriterion("ANSWER_NAME <", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_NAME <=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLike(String value) {
            addCriterion("ANSWER_NAME like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotLike(String value) {
            addCriterion("ANSWER_NAME not like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIn(List<String> values) {
            addCriterion("ANSWER_NAME in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotIn(List<String> values) {
            addCriterion("ANSWER_NAME not in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameBetween(String value1, String value2) {
            addCriterion("ANSWER_NAME between", value1, value2, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotBetween(String value1, String value2) {
            addCriterion("ANSWER_NAME not between", value1, value2, "answerName");
            return (Criteria) this;
        }

        public Criteria andIstrueIsNull() {
            addCriterion("ISTRUE is null");
            return (Criteria) this;
        }

        public Criteria andIstrueIsNotNull() {
            addCriterion("ISTRUE is not null");
            return (Criteria) this;
        }

        public Criteria andIstrueEqualTo(BigDecimal value) {
            addCriterion("ISTRUE =", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotEqualTo(BigDecimal value) {
            addCriterion("ISTRUE <>", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueGreaterThan(BigDecimal value) {
            addCriterion("ISTRUE >", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ISTRUE >=", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueLessThan(BigDecimal value) {
            addCriterion("ISTRUE <", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ISTRUE <=", value, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueIn(List<BigDecimal> values) {
            addCriterion("ISTRUE in", values, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotIn(List<BigDecimal> values) {
            addCriterion("ISTRUE not in", values, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISTRUE between", value1, value2, "istrue");
            return (Criteria) this;
        }

        public Criteria andIstrueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISTRUE not between", value1, value2, "istrue");
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
            addCriterionForJDBCDate("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeIsNull() {
            addCriterion("UPPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeIsNotNull() {
            addCriterion("UPPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME =", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME <>", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME >", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME >=", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME <", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPPDATE_TIME <=", value, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPPDATE_TIME in", values, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPPDATE_TIME not in", values, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPPDATE_TIME between", value1, value2, "uppdateTime");
            return (Criteria) this;
        }

        public Criteria andUppdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPPDATE_TIME not between", value1, value2, "uppdateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 14 15:21:26 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_EXA_ANSWER_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
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