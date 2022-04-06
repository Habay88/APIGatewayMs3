package com.habay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habay.model.Role;
import com.habay.security.UserPrincipal;
import com.habay.service.UserService;

@RestController
@RequestMapping("api/user") //prepath
public class UserController {

	@Autowired
	private UserService userService;
	
	@PutMapping("change/{role}")
	public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,@PathVariable Role role){
				userService.changeRole(role, userPrincipal.getUsername());
		return ResponseEntity.ok(true);
	}
}
