package cn.com.user.service.security;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.PUmAuthorityResourceMapper;
import cn.com.user.mapper.PUmResourcesMapper;
import cn.com.user.pojo.AuthorityAndResource;
import cn.com.user.pojo.PUmAuthorityResource;
import cn.com.user.pojo.PUmResources;
import cn.com.user.util.StateUtil;
@Service
public class ResourceService {
	@Resource
	private PUmResourcesMapper resourcesmapper;
	@Resource
	private PUmAuthorityResourceMapper authorityresourcemapper;
	public List<AuthorityAndResource> findAuthorityRelevanceResource(String authorityid){
		return resourcesmapper.authorityAndResource(authorityid);
	}
	public int insertList(List<PUmAuthorityResource> list, String authorityid){
		try {
			authorityresourcemapper.deleteByAuthorityid(authorityid);
			if(list.size()>0){
				authorityresourcemapper.insertList(list);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int deleteByAuthorityid(String anthorityid){
		return authorityresourcemapper.deleteByAuthorityid(anthorityid);
	}
	public List<PUmResources> findBySearche(Map<String, String> map) {
		return resourcesmapper.findBysearch(map);
	}
	public PUmResources findByRessourceid(String resourceid){
		return resourcesmapper.findByRessourceid(resourceid);
	}
	public int updateResources(PUmResources record){
		return resourcesmapper.updateByPrimaryKeySelective(record);
	}
	public int insertResources(PUmResources record){
		return resourcesmapper.insertSelective(record);
	}
	public int removeResources(String resourceid){
		authorityresourcemapper.deleteByPrimaryKey(resourceid);
		return resourcesmapper.deleteByPrimaryKey(resourceid);
	}
}
