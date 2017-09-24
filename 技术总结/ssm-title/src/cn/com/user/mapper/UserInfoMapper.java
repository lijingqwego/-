package cn.com.user.mapper;

import java.util.List;

import cn.com.user.pojo.RoleList;
import cn.com.user.pojo.UserInfoCustom;

public interface UserInfoMapper {
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	UserInfoCustom findUserInfoByName(String username) ;
	
	/**
	 * 根据用户编号，查询出来具体的角色列表
	 * @param userid
	 * @return
	 */
	List<RoleList> findUserRoleListByUserId(String userid);
}
