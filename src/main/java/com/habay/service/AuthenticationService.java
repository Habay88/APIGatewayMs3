package com.habay.service;

import com.habay.model.User;

public interface AuthenticationService {

	User signInAndReturnJwt(User signInRequest);

}
