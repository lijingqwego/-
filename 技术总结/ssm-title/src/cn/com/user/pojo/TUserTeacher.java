package cn.com.user.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TUserTeacher {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.TEACHER_ID
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private String teacherId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.TEACHER_NAME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private String teacherName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.TEACHING_TYPES
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private BigDecimal teachingTypes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.INTRODUCTION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private String introduction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.WORKYEAR
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private BigDecimal workyear;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.PHOTO_ADDRESS
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private String photoAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_USER_TEACHER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.TEACHER_ID
     *
     * @return the value of T_USER_TEACHER.TEACHER_ID
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.TEACHER_ID
     *
     * @param teacherId the value for T_USER_TEACHER.TEACHER_ID
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.TEACHER_NAME
     *
     * @return the value of T_USER_TEACHER.TEACHER_NAME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.TEACHER_NAME
     *
     * @param teacherName the value for T_USER_TEACHER.TEACHER_NAME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.TEACHING_TYPES
     *
     * @return the value of T_USER_TEACHER.TEACHING_TYPES
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public BigDecimal getTeachingTypes() {
        return teachingTypes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.TEACHING_TYPES
     *
     * @param teachingTypes the value for T_USER_TEACHER.TEACHING_TYPES
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setTeachingTypes(BigDecimal teachingTypes) {
        this.teachingTypes = teachingTypes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.INTRODUCTION
     *
     * @return the value of T_USER_TEACHER.INTRODUCTION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.INTRODUCTION
     *
     * @param introduction the value for T_USER_TEACHER.INTRODUCTION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.WORKYEAR
     *
     * @return the value of T_USER_TEACHER.WORKYEAR
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public BigDecimal getWorkyear() {
        return workyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.WORKYEAR
     *
     * @param workyear the value for T_USER_TEACHER.WORKYEAR
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setWorkyear(BigDecimal workyear) {
        this.workyear = workyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.PHOTO_ADDRESS
     *
     * @return the value of T_USER_TEACHER.PHOTO_ADDRESS
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public String getPhotoAddress() {
        return photoAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.PHOTO_ADDRESS
     *
     * @param photoAddress the value for T_USER_TEACHER.PHOTO_ADDRESS
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress == null ? null : photoAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.CREATE_TIME
     *
     * @return the value of T_USER_TEACHER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.CREATE_TIME
     *
     * @param createTime the value for T_USER_TEACHER.CREATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_USER_TEACHER.UPDATE_TIME
     *
     * @return the value of T_USER_TEACHER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_USER_TEACHER.UPDATE_TIME
     *
     * @param updateTime the value for T_USER_TEACHER.UPDATE_TIME
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}