package cn.com.user.mapper;


import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmUserRole;


public interface PUmUserRoleMapper {
    
	int deleteByPrimaryKey(String userid);
    int insertSelective(PUmUserRole record);
    List<PUmUserRole> findBySearch(Map<String,String> map);
    int insertList(List<PUmUserRole> list);
    int deleteList(List<PUmUserRole> list);
	void deleteByRoleid(String roleid);
}