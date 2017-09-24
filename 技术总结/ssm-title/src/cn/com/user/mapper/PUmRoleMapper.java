package cn.com.user.mapper;


import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmRole;
import cn.com.user.pojo.UserAndRole;


public interface PUmRoleMapper {
    
	int deleteByPrimaryKey(String roleid);    
    int insertSelective(PUmRole record);   
    PUmRole selectByPrimaryKey(String roleid);
    int updateByPrimaryKeySelective(PUmRole record);
    List<PUmRole> findBySearch(Map<String,String> map);
    List<UserAndRole> userAndRole(String userid);
	int findCount();
}