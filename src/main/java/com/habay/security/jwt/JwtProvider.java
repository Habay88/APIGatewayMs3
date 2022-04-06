package com.habay.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.habay.security.UserPrincipal;

public interface JwtProvider {

	String generateToken(UserPrincipal auth);

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

}
