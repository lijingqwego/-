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
//		��ɾ��������Ϣ
		roleauthoritymapper.deleteByPrimaryKey(roleid);
		userrolemapper.deleteByRoleid(roleid);
		rolemapper.deleteByPrimaryKey(roleid);
	}
	public int insertRole(PUmRole record){
//		��ȡ��ǰ��ɫ����ȷ����һ������ɫ��id
//		ֻ�������߼�ɾ����ı�
		int result=rolemapper.findCount()+1;
		String roleid="100"+result;
		record.setRoleid(roleid);
//		����ɫ�����ʼȨ��
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
