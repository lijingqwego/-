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
//		删除用户，需要先删除与其管理的角色，数据库的外键约束才不会报错
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
//		查询是否存在该数据
		map.put("userid", userid);
		map.put("loginid", loginid);
		int check=usermapper.check(map);
		if(check>0){
			return StateUtil.CHECKEXIST;
		}
//		注册用户时同事赋予最基础的角色
		PUmUserRole code= new PUmUserRole();
		code.setUserid(recode.getUserid());
		code.setRoleid("10001");
		code.setFlaginfo("1");
		try {
			usermapper.insertSelective(recode);
//			注册或添加用户时，默认给一个用户角色
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
//		对用户输入的原密码进行特殊加密
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
