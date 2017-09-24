package cn.com.user.service.security;


import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.com.user.mapper.PUmUserRoleMapper;
import cn.com.user.pojo.PUmUserRole;
import cn.com.user.util.StateUtil;

@Service
public class UserAndRoleService {
	@Resource
	private PUmUserRoleMapper userrolemapper;
	public int insertList(PUmUserRole userrole){
		try {
			userrolemapper.deleteByPrimaryKey(userrole.getUserid());
			userrolemapper.insertSelective(userrole);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int delete(String userid){
		return userrolemapper.deleteByPrimaryKey(userid);
	}
	public int deleteList(List<PUmUserRole> list){
		return userrolemapper.deleteList(list);
	}
}
