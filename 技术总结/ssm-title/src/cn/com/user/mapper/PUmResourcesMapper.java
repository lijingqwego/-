package cn.com.user.mapper;

import java.util.List;
import java.util.Map;

import cn.com.user.pojo.AuthorityAndResource;
import cn.com.user.pojo.PUmResources;

public interface PUmResourcesMapper {
	 int deleteByPrimaryKey(String ResourceId);    
	 int insertSelective(PUmResources record);
     PUmResources selectByPrimaryKey(String ResourceId); 
     int updateByPrimaryKeySelective(PUmResources record);
//     通过搜索条件搜索
     List<PUmResources> findBysearch(Map<String, String> map);
     List<AuthorityAndResource> authorityAndResource(String authorityid);
     PUmResources findByRessourceid(String resourceid);
}
