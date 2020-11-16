package com.rest.back.user.Service;

import org.springframework.stereotype.Service;

import com.rest.back.user.DTO.Users;

@Service
public interface UserService {
	
	public Users login (Users loginuser);
}
