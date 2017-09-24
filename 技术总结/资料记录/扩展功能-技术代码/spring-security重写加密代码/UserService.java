package cn.com.user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.PUmUserMapper;
import cn.com.user.mapper.PUmUserRoleMapper;
import cn.com.user.pojo.PUmUser;
import cn.com.user.pojo.PUmUserRole;
import cn.com.user.util.MD5Util;
import cn.com.user.util.StateUtil;

@Service("UserService")
public class UserService {
	@Resource
	private PUmUserMapper usermapper;
	@Resource
	private PUmUserRoleMapper userrolemapper;
	public int insertUser(PUmUser recode){
		String password=recode.getPassword();
		String loginid=recode.getLoginid();
		if(loginid==null || loginid==""){
			return StateUtil.DATAEXCEPTION;
		}
		if(recode.getUserid()==null || recode.getUserid()==""){
			return StateUtil.DATAEXCEPTION;
		}
		if(password==null || password==""){
			return StateUtil.DATAEXCEPTION;
		}
		//������ܣ����ܷ�ʽͨ������õļ��ܷ�ʽҪһ�£�
		password=MD5Util.md5_SystemWideSaltSource(password,loginid);
		if(password==null || password==""){
			return StateUtil.DATAEXCEPTION;
		}
		recode.setPassword(password);
//		��ѯ�Ƿ���ڸ�����
		int check=usermapper.check(recode.getUserid());
		if(check>0){
			return StateUtil.CHECKEXIST;
		}
		PUmUserRole code= new PUmUserRole();
		code.setUserid(recode.getUserid());
		code.setRoleid("10001");
		code.setFlaginfo("1");
		try {
			usermapper.insertSelective(recode);
//			ע�������û�ʱ��Ĭ�ϸ�һ���û���ɫ
			userrolemapper.insertSelective(code);
		} catch (Exception e) {
			e.printStackTrace();
			return StateUtil.FAILSTATE;
		}
		return StateUtil.SUCCESSSTATE;
	}
	public int changepassword(Map<String, String> map) {
		// TODO Auto-generated method stub
		String oldpassword=map.get("oldpassword");
		String username=map.get("username");
		String newpassword=map.get("newpassword");
		PUmUser user=usermapper.selectByLoginid(username);
//		���û������ԭ��������������
		oldpassword=MD5Util.md5_SystemWideSaltSource(oldpassword,username);
		if(oldpassword.equals(user.getPassword())){
			newpassword=MD5Util.md5_SystemWideSaltSource(newpassword,username);
			map.clear();
			map.put("username", username);
			map.put("newpassword", newpassword);
			try {
				usermapper.updatePassword(map);
			} catch (Exception e) {
				e.printStackTrace();
				return StateUtil.FAILSTATE;
			}
		}else{
			return StateUtil.DATAEXCEPTION;
		}
		
		return StateUtil.SUCCESSSTATE;
	}
	public int check(String userid) {
		// TODO Auto-generated method stub
		int result=usermapper.checkByLoginid(userid);
		return result;
	}
	
}
