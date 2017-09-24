package cn.com.user.pojo;

import java.io.Serializable;

public class RoleList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4783057019361600331L;
	private String roleid;
	private String rolecode;//权限，这个实体主要用于用户和权限是一对多的时候

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRoleid() {
		return roleid;
	}

	public RoleList(String roleid, String rolecode) {
		super();
		this.roleid = roleid;
		this.rolecode = rolecode;
	}

	public RoleList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
