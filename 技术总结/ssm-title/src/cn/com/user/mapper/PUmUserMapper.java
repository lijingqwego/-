package cn.com.user.mapper;

import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmUser;


public interface PUmUserMapper {
    
    int deleteByPrimaryKey(String userid);
    int insertSelective(PUmUser record); 
    PUmUser selectByLoginid(String loginid);
    PUmUser findByUserid(String userid);
    int updateByPrimaryKeySelective(PUmUser record);
	List<PUmUser> findBySearch(Map<String,String> map);
	int updateLogin(String loginid);
	int check(Map<String, String> map);
	int checkByLoginid(String loginid);
	void updatePassword(Map<String, String> map);
	void updateUsername(Map<String, String> map);
}