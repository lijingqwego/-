package cn.com.user.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TExaminationListExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public TExaminationListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
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
     * This method corresponds to the database table T_EXAMINATION_LIST
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
     * This method corresponds to the database table T_EXAMINATION_LIST
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_EXAMINATION_LIST
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
     * This class corresponds to the database table T_EXAMINATION_LIST
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoIsNull() {
            addCriterion("EXAMINATION_INFO_NO is null");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoIsNotNull() {
            addCriterion("EXAMINATION_INFO_NO is not null");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoEqualTo(String value) {
            addCriterion("EXAMINATION_INFO_NO =", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoNotEqualTo(String value) {
            addCriterion("EXAMINATION_INFO_NO <>", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoGreaterThan(String value) {
            addCriterion("EXAMINATION_INFO_NO >", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoGreaterThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_INFO_NO >=", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoLessThan(String value) {
            addCriterion("EXAMINATION_INFO_NO <", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoLessThanOrEqualTo(String value) {
            addCriterion("EXAMINATION_INFO_NO <=", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoLike(String value) {
            addCriterion("EXAMINATION_INFO_NO like", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoNotLike(String value) {
            addCriterion("EXAMINATION_INFO_NO not like", value, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoIn(List<String> values) {
            addCriterion("EXAMINATION_INFO_NO in", values, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoNotIn(List<String> values) {
            addCriterion("EXAMINATION_INFO_NO not in", values, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoBetween(String value1, String value2) {
            addCriterion("EXAMINATION_INFO_NO between", value1, value2, "examinationInfoNo");
            return (Criteria) this;
        }

        public Criteria andExaminationInfoNoNotBetween(String value1, String value2) {
            addCriterion("EXAMINATION_INFO_NO not between", value1, value2, "examinationInfoNo");
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

        public Criteria andQuestionTypeIsNull() {
            addCriterion("QUESTION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("QUESTION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(BigDecimal value) {
            addCriterion("QUESTION_TYPE =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(BigDecimal value) {
            addCriterion("QUESTION_TYPE <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(BigDecimal value) {
            addCriterion("QUESTION_TYPE >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUESTION_TYPE >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(BigDecimal value) {
            addCriterion("QUESTION_TYPE <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUESTION_TYPE <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<BigDecimal> values) {
            addCriterion("QUESTION_TYPE in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<BigDecimal> values) {
            addCriterion("QUESTION_TYPE not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUESTION_TYPE between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUESTION_TYPE not between", value1, value2, "questionType");
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

        public Criteria andChooseKeyIsNull() {
            addCriterion("CHOOSE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andChooseKeyIsNotNull() {
            addCriterion("CHOOSE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andChooseKeyEqualTo(String value) {
            addCriterion("CHOOSE_KEY =", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyNotEqualTo(String value) {
            addCriterion("CHOOSE_KEY <>", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyGreaterThan(String value) {
            addCriterion("CHOOSE_KEY >", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyGreaterThanOrEqualTo(String value) {
            addCriterion("CHOOSE_KEY >=", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyLessThan(String value) {
            addCriterion("CHOOSE_KEY <", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyLessThanOrEqualTo(String value) {
            addCriterion("CHOOSE_KEY <=", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyLike(String value) {
            addCriterion("CHOOSE_KEY like", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyNotLike(String value) {
            addCriterion("CHOOSE_KEY not like", value, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyIn(List<String> values) {
            addCriterion("CHOOSE_KEY in", values, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyNotIn(List<String> values) {
            addCriterion("CHOOSE_KEY not in", values, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyBetween(String value1, String value2) {
            addCriterion("CHOOSE_KEY between", value1, value2, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andChooseKeyNotBetween(String value1, String value2) {
            addCriterion("CHOOSE_KEY not between", value1, value2, "chooseKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyIsNull() {
            addCriterion("RIGHT_KEY is null");
            return (Criteria) this;
        }

        public Criteria andRightKeyIsNotNull() {
            addCriterion("RIGHT_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andRightKeyEqualTo(String value) {
            addCriterion("RIGHT_KEY =", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotEqualTo(String value) {
            addCriterion("RIGHT_KEY <>", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyGreaterThan(String value) {
            addCriterion("RIGHT_KEY >", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHT_KEY >=", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLessThan(String value) {
            addCriterion("RIGHT_KEY <", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLessThanOrEqualTo(String value) {
            addCriterion("RIGHT_KEY <=", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyLike(String value) {
            addCriterion("RIGHT_KEY like", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotLike(String value) {
            addCriterion("RIGHT_KEY not like", value, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyIn(List<String> values) {
            addCriterion("RIGHT_KEY in", values, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotIn(List<String> values) {
            addCriterion("RIGHT_KEY not in", values, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyBetween(String value1, String value2) {
            addCriterion("RIGHT_KEY between", value1, value2, "rightKey");
            return (Criteria) this;
        }

        public Criteria andRightKeyNotBetween(String value1, String value2) {
            addCriterion("RIGHT_KEY not between", value1, value2, "rightKey");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_EXAMINATION_LIST
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
     * This class corresponds to the database table T_EXAMINATION_LIST
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