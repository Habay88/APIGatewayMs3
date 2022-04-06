package com.habay.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.habay.model.Role;
import com.habay.model.User;
import com.habay.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
	private UserRepository userrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
public User saveUser(User user) {

	
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	user.setRole(Role.USER);
	user.setCreateTime(LocalDateTime.now());
	 return userrepo.save(user);
	
	
}
    @Override
    public Optional<User> findByUsername(String username){
    	return userrepo.findByUsername(username);
    }
    
    @Override
    @Transactional // required when executing update and delete query
    public void changeRole(Role newRole, String username) {
    	userrepo.updateUserRole(username, newRole);
    }
}
