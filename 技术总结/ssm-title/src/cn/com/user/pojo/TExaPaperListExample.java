package cn.com.user.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TExaPaperListExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public TExaPaperListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
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
     * This method corresponds to the database table T_EXA_PAPER_LIST
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
     * This method corresponds to the database table T_EXA_PAPER_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXA_PAPER_LIST
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
     * This class corresponds to the database table T_EXA_PAPER_LIST
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

        public Criteria andExaminatiListIdIsNull() {
            addCriterion("EXAMINATI_LIST_ID is null");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdIsNotNull() {
            addCriterion("EXAMINATI_LIST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdEqualTo(String value) {
            addCriterion("EXAMINATI_LIST_ID =", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdNotEqualTo(String value) {
            addCriterion("EXAMINATI_LIST_ID <>", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdGreaterThan(String value) {
            addCriterion("EXAMINATI_LIST_ID >", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINATI_LIST_ID >=", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdLessThan(String value) {
            addCriterion("EXAMINATI_LIST_ID <", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdLessThanOrEqualTo(String value) {
            addCriterion("EXAMINATI_LIST_ID <=", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdLike(String value) {
            addCriterion("EXAMINATI_LIST_ID like", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdNotLike(String value) {
            addCriterion("EXAMINATI_LIST_ID not like", value, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdIn(List<String> values) {
            addCriterion("EXAMINATI_LIST_ID in", values, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdNotIn(List<String> values) {
            addCriterion("EXAMINATI_LIST_ID not in", values, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdBetween(String value1, String value2) {
            addCriterion("EXAMINATI_LIST_ID between", value1, value2, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminatiListIdNotBetween(String value1, String value2) {
            addCriterion("EXAMINATI_LIST_ID not between", value1, value2, "examinatiListId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIsNull() {
            addCriterion("EXAMINATION_ID is null");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIsNotNull() {
            addCriterion("EXAMINATION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationIdEqualTo(String value) {
            addCriterion("EXAMINATION_ID =", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotEqualTo(String value) {
            addCriterion("EXAMINATION_ID <>", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdGreaterThan(String value) {
            addCriterion("EXAMINATION_ID >", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_ID >=", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdLessThan(String value) {
            addCriterion("EXAMINATION_ID <", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdLessThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_ID <=", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdLike(String value) {
            addCriterion("EXAMINATION_ID like", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotLike(String value) {
            addCriterion("EXAMINATION_ID not like", value, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdIn(List<String> values) {
            addCriterion("EXAMINATION_ID in", values, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotIn(List<String> values) {
            addCriterion("EXAMINATION_ID not in", values, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdBetween(String value1, String value2) {
            addCriterion("EXAMINATION_ID between", value1, value2, "examinationId");
            return (Criteria) this;
        }

        public Criteria andExaminationIdNotBetween(String value1, String value2) {
            addCriterion("EXAMINATION_ID not between", value1, value2, "examinationId");
            return (Criteria) this;
        }

        public Criteria andQuestionNumIsNull() {
            addCriterion("QUESTION_NUM is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumIsNotNull() {
            addCriterion("QUESTION_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNumEqualTo(BigDecimal value) {
            addCriterion("QUESTION_NUM =", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumNotEqualTo(BigDecimal value) {
            addCriterion("QUESTION_NUM <>", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumGreaterThan(BigDecimal value) {
            addCriterion("QUESTION_NUM >", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUESTION_NUM >=", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumLessThan(BigDecimal value) {
            addCriterion("QUESTION_NUM <", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUESTION_NUM <=", value, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumIn(List<BigDecimal> values) {
            addCriterion("QUESTION_NUM in", values, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumNotIn(List<BigDecimal> values) {
            addCriterion("QUESTION_NUM not in", values, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUESTION_NUM between", value1, value2, "questionNum");
            return (Criteria) this;
        }

        public Criteria andQuestionNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUESTION_NUM not between", value1, value2, "questionNum");
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

        public Criteria andAnswerContentIsNull() {
            addCriterion("ANSWER_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNotNull() {
            addCriterion("ANSWER_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentEqualTo(String value) {
            addCriterion("ANSWER_CONTENT =", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <>", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThan(String value) {
            addCriterion("ANSWER_CONTENT >", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT >=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThan(String value) {
            addCriterion("ANSWER_CONTENT <", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLike(String value) {
            addCriterion("ANSWER_CONTENT like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotLike(String value) {
            addCriterion("ANSWER_CONTENT not like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIn(List<String> values) {
            addCriterion("ANSWER_CONTENT in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotIn(List<String> values) {
            addCriterion("ANSWER_CONTENT not in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT not between", value1, value2, "answerContent");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_EXA_PAPER_LIST
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
     * This class corresponds to the database table T_EXA_PAPER_LIST
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