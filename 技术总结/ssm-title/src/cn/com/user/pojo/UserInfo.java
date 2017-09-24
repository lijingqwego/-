package cn.com.user.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {
	private String id ; 
	private String username ; 
	private String password; 
	private int state ;
	private String roleCode ;//该用户的权限（用于，用户和角色一对一的时候）
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
	/**
	 * 获取用户所具有的权限。
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//创建一个集合
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		//应该向集合中添加数据
		GrantedAuthority ga = new SimpleGrantedAuthority(this.roleCode);
		list.add(ga);
		return list;
	}
	
	
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	} 
	
}
