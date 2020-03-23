package com.rest.back.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.back.domain.Users;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public Users login(String email) {
		return sqlSession.selectOne("userMapper.login", email);
	}
	
}
