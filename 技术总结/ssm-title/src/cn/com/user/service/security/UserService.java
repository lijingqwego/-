package cn.com.user.service.security;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.user.mapper.PUmUserMapper;
import cn.com.user.mapper.PUmUserRoleMapper;
import cn.com.user.pojo.PUmUser;
import cn.com.user.pojo.PUmUserRole;
import cn.com.user.util.DateUtil;
import cn.com.user.util.MD5Util;
import cn.com.user.util.StateUtil;

@Service("UserService")
public class UserService {
	@Resource
	private PUmUserMapper usermapper;
	@Resource
	private PUmUserRoleMapper userrolemapper;
	public PUmUser findByLoginid(String loginid){
		return usermapper.selectByLoginid(loginid);
	}
	public int updateLogin(String loginid){
		return usermapper.updateLogin(loginid);
	}
	public List<PUmUser> findBySearche(Map<String, String> map){
		return usermapper.findBySearch(map);
	}
	public PUmUser findByUserid(String userid){
		return usermapper.findByUserid(userid);
	}
	public int removeUser(String userid){
//		ɾ���û�����Ҫ��ɾ���������Ľ�ɫ�����ݿ�����Լ���Ų��ᱨ��
		userrolemapper.deleteByPrimaryKey(userid);
		return usermapper.deleteByPrimaryKey(userid);
	}
	public int updateUser(PUmUser record){
		return usermapper.updateByPrimaryKeySelective(record);
	}
	public int insertUser(PUmUser recode){
		Map<String, String> map= new HashMap<>();
		String password=recode.getPassword();
		String loginid=recode.getLoginid();
		if(loginid==null || loginid==""){
			return StateUtil.DATAEXCEPTION;
		}
		if(password==null || password==""){
			return StateUtil.DATAEXCEPTION;
		}
		password=MD5Util.md5_SystemWideSaltSource(password,loginid);
		if(password==null || password==""){
			return StateUtil.DATAEXCEPTION;
		}
		recode.setPassword(password);
		String userid=DateUtil.dateToStr((new Date()), DateUtil.DATETYPESTRING);
		recode.setUserid(userid);
//		��ѯ�Ƿ���ڸ�����
		map.put("userid", userid);
		map.put("loginid", loginid);
		int check=usermapper.check(map);
		if(check>0){
			return StateUtil.CHECKEXIST;
		}
//		ע���û�ʱͬ�¸���������Ľ�ɫ
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
		String loginid=map.get("loginid");
		String newpassword=map.get("newpassword");
		PUmUser user=usermapper.selectByLoginid(loginid);
//		���û������ԭ��������������
		oldpassword=MD5Util.md5_SystemWideSaltSource(oldpassword,loginid);
		if(oldpassword.equals(user.getPassword())){
			newpassword=MD5Util.md5_SystemWideSaltSource(newpassword,loginid);
			map.clear();
			map.put("loginid", loginid);
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
	public void updateUsername(Map<String, String> map) {
		// TODO Auto-generated method stub
		usermapper.updateUsername(map);
	}
	
}
