package cn.com.user.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.com.user.mapper.UserInfoMapper;
import cn.com.user.pojo.RoleList;
import cn.com.user.pojo.UserInfoCustom;
@Service
public class AuthUserInfoService implements UserDetailsService {

	@Resource
	private UserInfoMapper userInfoMapper ; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfoCustom userInfo = this.userInfoMapper.findUserInfoByName(username);
		String userid=userInfo.getId();
		if(userInfo.getPassword()!=null){
			//根据用户名查询到了用户 
			//需要根据id来查询权限
			List<RoleList> list = userInfoMapper.findUserRoleListByUserId(userid);
			userInfo.setRolelist(list);
			for(RoleList role : list){
				System.out.println(role.getRolecode());
				
			}
		}
		return userInfo;
	}
	
}
