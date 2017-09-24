package cn.com.user.service.security;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.PUmRoleAuthorityMapper;
import cn.com.user.mapper.PUmRoleMapper;
import cn.com.user.mapper.PUmUserRoleMapper;
import cn.com.user.pojo.PUmRole;
import cn.com.user.pojo.PUmRoleAuthority;
import cn.com.user.pojo.UserAndRole;
import cn.com.user.util.StateUtil;

@Service
public class RoleService {
	@Resource
	PUmRoleMapper rolemapper;
	@Resource
	PUmUserRoleMapper userrolemapper;
	@Resource
	PUmRoleAuthorityMapper roleauthoritymapper;
	
	public List<UserAndRole> findRoleRelevanceUser(String userid){
		return rolemapper.userAndRole(userid);
	}
	public List<PUmRole> findBySearche(Map<String, String> map) {
		return rolemapper.findBySearch(map);
	}
	public PUmRole findByRoleid(String roleid){
		return rolemapper.selectByPrimaryKey(roleid);
	}
	public void removeRole(String roleid){
//		先删除关联信息
		roleauthoritymapper.deleteByPrimaryKey(roleid);
		userrolemapper.deleteByRoleid(roleid);
		rolemapper.deleteByPrimaryKey(roleid);
	}
	public int insertRole(PUmRole record){
//		获取当前角色数已确定下一个及角色的id
//		只适用于逻辑删除后的表
		int result=rolemapper.findCount()+1;
		String roleid="100"+result;
		record.setRoleid(roleid);
//		给角色赋予初始权限
		PUmRoleAuthority relation=new PUmRoleAuthority();
		relation.setRoleid(roleid);
		relation.setAuthorityid("10001");
		relation.setFlaginfo("1");
		rolemapper.insertSelective(record);
		return roleauthoritymapper.insertOne(relation);
	}
	public int updateRole(PUmRole record){
		if(record.getRoleid() == null || record.getRoleid() == ""){
			return StateUtil.DATAEXCEPTION;
		}else{
			return rolemapper.updateByPrimaryKeySelective(record);
		}
		
	}
	
}
