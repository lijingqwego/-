package cn.com.user.service.security;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.PUmAuthorityMapper;
import cn.com.user.mapper.PUmAuthorityResourceMapper;
import cn.com.user.mapper.PUmRoleAuthorityMapper;
import cn.com.user.pojo.PUmAuthority;
import cn.com.user.pojo.PUmRoleAuthority;
import cn.com.user.pojo.RoleAndAuthority;
import cn.com.user.util.StateUtil;
@Service
public class AuthorityService {
	@Resource
	private PUmRoleAuthorityMapper roleauthoritymapper;
	@Resource
	private PUmAuthorityMapper authoritymapper;
	@Resource
	private PUmAuthorityResourceMapper authorityresourcemapper;
	public int insertList(List<PUmRoleAuthority> list, String roleid){
		try {
			roleauthoritymapper.deleteByPrimaryKey(roleid);
			if(list.size()>0){
				roleauthoritymapper.insertList(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return StateUtil.FAILSTATE;
			// TODO: handle exception
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int deleteByRoleid(String roleid){
		return roleauthoritymapper.deleteByPrimaryKey(roleid);
	}
	public List<RoleAndAuthority> findRoleRelevanceAuthority(String roleid){
		return authoritymapper.roleAndAuthority(roleid);
	}
	public int updateAuthority(PUmAuthority record){
		return authoritymapper.updateByPrimaryKeySelective(record);
	}
	public int insertAuthority(PUmAuthority record){
		return authoritymapper.insertSelective(record);
	}
	public int removeAuthority(String authorityid){
		authorityresourcemapper.deleteByAuthorityid(authorityid);
		roleauthoritymapper.deleteByAuthorityid(authorityid);
		return authoritymapper.deleteByPrimaryKey(authorityid);
	}
	public List<PUmAuthority> findBySearch(Map<String, String> map){
		return authoritymapper.findBySearch(map);
	}
	public PUmAuthority findByAuthorityid(String authorityid) {
		// TODO Auto-generated method stub
		return authoritymapper.selectByPrimaryKey(authorityid);
	}
	
}
