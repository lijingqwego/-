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
			//�����û�����ѯ�����û� 
			//��Ҫ����id����ѯȨ��
			List<RoleList> list = userInfoMapper.findUserRoleListByUserId(userid);
			userInfo.setRolelist(list);
			for(RoleList role : list){
				System.out.println(role.getRolecode());
				
			}
		}
		return userInfo;
	}
	
}
