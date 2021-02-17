package com.basic.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersDetailsRetrieval implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2493409882277867424L;
	
	String userN;
	String userP;
	
	public UsersDetailsRetrieval() {
		// TODO Auto-generated constructor stub
	}

	public UsersDetailsRetrieval(String userN, String userP) {
		// TODO Auto-generated constructor stub
		this.userN = userN;
		this.userP = userP;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userP;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userN;
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
