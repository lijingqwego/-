package cn.com.user.mapper;

import cn.com.user.pojo.TUPRelation;
import cn.com.user.pojo.TUPRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUPRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int countByExample(TUPRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int deleteByExample(TUPRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int deleteByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int insert(TUPRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int insertSelective(TUPRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    List<TUPRelation> selectByExample(TUPRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    TUPRelation selectByPrimaryKey(String userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") TUPRelation record, @Param("example") TUPRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByExample(@Param("record") TUPRelation record, @Param("example") TUPRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByPrimaryKeySelective(TUPRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_U_P_RELATION
     *
     * @mbggenerated Mon Aug 14 15:21:26 CST 2017
     */
    int updateByPrimaryKey(TUPRelation record);
}