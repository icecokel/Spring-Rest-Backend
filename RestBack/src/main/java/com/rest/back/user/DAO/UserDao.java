package com.rest.back.user.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.back.user.DTO.Users;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Users login(String email) {
		return sqlSession.selectOne("userMapper.login", email);
	}
	
}
