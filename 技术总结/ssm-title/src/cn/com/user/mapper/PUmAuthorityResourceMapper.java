package cn.com.user.mapper;


import java.util.List;
import java.util.Map;

import cn.com.user.pojo.PUmAuthorityResource;


public interface PUmAuthorityResourceMapper {
   
    int deleteByPrimaryKey(String ResourceId);    
    int insertSelective(PUmAuthorityResource record); 
    PUmAuthorityResource selectByPrimaryKey(String ResourceId); 
    int updateByPrimaryKeySelective(PUmAuthorityResource record);
    List<PUmAuthorityResource> findBySearch(Map<String,String> map);
	int deleteByAuthorityid(String authorityid);
	int insertList(List<PUmAuthorityResource> list);
}