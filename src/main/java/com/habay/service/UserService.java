package com.habay.service;

import java.util.Optional;

import com.habay.model.Role;
import com.habay.model.User;

public interface UserService {

	User saveUser(User user);

	Optional<User> findByUsername(String username);

	void changeRole(Role newRole, String username);

}
