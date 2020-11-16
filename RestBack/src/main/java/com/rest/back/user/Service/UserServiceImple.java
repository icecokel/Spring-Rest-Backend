package com.rest.back.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.back.user.DAO.UserDao;
import com.rest.back.user.DTO.Users;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Users login(Users loginuser) {
		
		Users user = userDao.login(loginuser.getEmail());
		
		if(user.getPasswd().equals(loginuser.getPasswd())) {
			user.setPasswd(null);
			
		}else {
			user=null;
		}

		return user;
	}

}
