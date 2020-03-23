package com.rest.back.service;

import org.springframework.stereotype.Service;

import com.rest.back.domain.Users;

@Service
public interface UserService {
	
	public Users login (Users loginuser);
}
