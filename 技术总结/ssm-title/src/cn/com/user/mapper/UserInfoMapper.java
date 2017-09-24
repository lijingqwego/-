package cn.com.user.mapper;

import java.util.List;

import cn.com.user.pojo.RoleList;
import cn.com.user.pojo.UserInfoCustom;

public interface UserInfoMapper {
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param username
	 * @return
	 */
	UserInfoCustom findUserInfoByName(String username) ;
	
	/**
	 * �����û���ţ���ѯ��������Ľ�ɫ�б�
	 * @param userid
	 * @return
	 */
	List<RoleList> findUserRoleListByUserId(String userid);
}
