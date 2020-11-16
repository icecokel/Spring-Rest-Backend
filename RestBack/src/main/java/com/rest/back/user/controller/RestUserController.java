package com.rest.back.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.back.user.DTO.Users;
import com.rest.back.user.Service.UserService;

@RestController
@CrossOrigin("*")
public class RestUserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/login")
	public Map<String, Object> login (@RequestBody Users loginuser){
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		
		Users user  = userService.login(loginuser);
		
		if(user != null) {
			map.put("result",1);
			map.put("user",user);
			
		}else {
			map.put("result",0);
		}


		System.out.println("BackEndServer : /user/login : POST");
		
		return map;
		
	}
	

}
