package com.master.template.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetail implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634635905082220747L;
	
	User user;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getActivated();
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof UserDetail) {
			return getUsername().equals(((UserDetail)o).user.getUserName());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return getUsername().hashCode();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}
}
