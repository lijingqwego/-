package cn.com.user.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserInfoCustom extends UserInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RoleList> rolelist ;

	public List<RoleList> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<RoleList> rolelist) {
		this.rolelist = rolelist;
	} 
	
	/**
	 * 重写父类的方法
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		//向list中添加权限。
		for (int i = 0; i < rolelist.size(); i++) {
			GrantedAuthority ga = new SimpleGrantedAuthority(rolelist.get(i).getRolecode());
			list.add(ga);
			
		}
		return list ; 
	}
	
}	
