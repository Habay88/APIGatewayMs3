package com.habay.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.habay.model.User;

import lombok.Builder;

@Builder
public class UserPrincipal implements UserDetails {
	
	private long id;
	private String username;
	transient private String password;// dont show up on serialized places
	transient private User user; // user for only login operation, dont use in JWT
	private Set<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
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

	public UserPrincipal(long id, String username, String password, User user, Set<GrantedAuthority> authorities) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
	}

	public UserPrincipal() {
	
	}

	public long getId() {
		return id;
	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public User getUser() {
		return user;
	}

//	public void setUser(User user) {
//		this.user = user;
//	}

//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public void setAuthorities(Set<GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//	

	

}
