package cn.com.user.mapper;

import cn.com.user.pojo.TLessonProductInfo;
import cn.com.user.pojo.TLessonProductInfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TLessonProductInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int countByExample(TLessonProductInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int deleteByExample(TLessonProductInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int deleteByPrimaryKey(String lessonId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int insert(TLessonProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int insertSelective(TLessonProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    List<TLessonProductInfo> selectByExample(TLessonProductInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    TLessonProductInfo selectByPrimaryKey(String lessonId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") TLessonProductInfo record, @Param("example") TLessonProductInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByExample(@Param("record") TLessonProductInfo record, @Param("example") TLessonProductInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByPrimaryKeySelective(TLessonProductInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_LESSON_PRODUCT_INFO
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByPrimaryKey(TLessonProductInfo record);

	List<TLessonProductInfo> findBySearche(Map<String, String> map);

	int check(String lessonid);
}