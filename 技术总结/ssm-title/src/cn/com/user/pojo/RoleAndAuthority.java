package cn.com.user.pojo;

public class RoleAndAuthority extends PUmAuthority{
	private String roleid;

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public RoleAndAuthority(String authorityid, String authorityname, String descn, String function, String code,
			String functionname, String functionresource, String flaginfo, String roleid) {
		super(authorityid, authorityname, descn, function, code, functionname, functionresource, flaginfo);
		this.roleid = roleid;
	}

	public RoleAndAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleAndAuthority(String authorityid, String authorityname, String descn, String function, String code,
			String functionname, String functionresource, String flaginfo) {
		super(authorityid, authorityname, descn, function, code, functionname, functionresource, flaginfo);
		// TODO Auto-generated constructor stub
	}
	
}
