package cn.com.user.mapper;


import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmRoleAuthority;
public interface PUmRoleAuthorityMapper {
	int deleteByPrimaryKey(String roleid);
	void deleteByAuthorityid(String authorityid);
    PUmRoleAuthority selectByPrimaryKey(String roleid);
    int updateByPrimaryKeySelective(PUmRoleAuthority record);
    List<PUmRoleAuthority> findBySearch(Map<String,String> map);
    int insertList(List<PUmRoleAuthority> list);
	int insertOne(PUmRoleAuthority relation);
}