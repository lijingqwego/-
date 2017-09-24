package cn.com.user.pojo;

import java.math.BigDecimal;

public class UserAndRole extends PUmRole{
//	标志用户存储用户id
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public UserAndRole(String roleid, String rolename, String descn, String code, String flaginfo, BigDecimal sort,
			String userid) {
		super(roleid, rolename, descn, code, flaginfo, sort);
		this.userid = userid;
	}

	public UserAndRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAndRole(String roleid, String rolename, String descn, String code, String flaginfo, BigDecimal sort) {
		super(roleid, rolename, descn, code, flaginfo, sort);
		// TODO Auto-generated constructor stub
	}
	
	
}
