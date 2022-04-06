package com.habay.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.habay.model.User;
import com.habay.service.UserService;
import com.habay.util.SecurityUtils;
@Service
public class CustomUserDetailsService implements UserDetailsService{
   
	@Autowired
	private UserService userservice;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userservice.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException
						("User not founf with username: " + username));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority
				(user.getRole().name()));
		
		// user details
		return UserPrincipal.builder()
				.user(user)
				.id(user.getId())
				.username(username)
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}

}
