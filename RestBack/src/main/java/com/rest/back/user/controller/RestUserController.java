package com.rest.back.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.back.user.DTO.Users;
import com.rest.back.user.Service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin("*")
public class RestUserController {
	
	@Autowired
	private UserService userService;
	
	
	@ApiOperation(value="로그인", notes="성공시 {result:1} 과 유저 정보를 반환합니다.")
	@ApiParam(example="설명")
	@PostMapping("/user/login")
	public Map<String, Object> login (@RequestBody Users loginuser){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//Users user  = userService.login(loginuser);
		
		Users user = loginuser;
		
		
		if(user != null) {
			map.put("result",1);
			map.put("user",user);
			map.put("info","현재 DB 연결이 되지 않아. 해당 서비스를 이용 할 수 없습니다. 정상적인 데이터가 넘어왔다면 1을 반환합니다.");
			
		}else {
			map.put("result",0);
		}

		System.out.println("BackEndServer : /user/login : POST");
		
		return map;
		
	}
	@ApiOperation(value="로그인", notes="성공시 {result:1}을 반환합니다.")
	@ApiParam(example="설명")
	@GetMapping("/idCheck")
	public Map<String, Object> idCheck (HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		
		String checkId = request.getParameter("id");
		System.out.println(checkId);
		
		if(checkId.length() > 0) {
			result.put("result",1);
		}else {
			result.put("result",0);
		}
		
		return result;
	}
	

}
