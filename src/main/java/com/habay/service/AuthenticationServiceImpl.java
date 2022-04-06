package com.habay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.habay.model.User;
import com.habay.security.UserPrincipal;
import com.habay.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired	
	private AuthenticationManager authenticationManager;
    
   @Autowired
    private JwtProvider jwtProvider;
	
   @Override
	public User signInAndReturnJwt(User  signInRequest)
	{
		
	Authentication authentication = authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
	signInRequest.getPassword()));
	
	UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();	
	String jwt = jwtProvider.generateToken(userPrincipal);
	User signInUser = userPrincipal.getUser();
	signInUser.setToken(jwt);
	return signInUser;
	}
}
