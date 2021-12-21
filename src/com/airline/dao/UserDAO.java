package com.airline.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.airline.vo.User;

public class UserDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	// 로그인
	public boolean login(String user_id, String passwd) {
		try(SqlSession session = factory.openSession()){
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			HashMap<String, String> loginMap = new HashMap<String, String>();
			loginMap.put("user_id", user_id);
			loginMap.put("passwd", passwd);
			
			if(mapper.login(loginMap) > 0) return true;

		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	// 아이디 중복체크
	public boolean check_duplicate_id(String user_id) {
		try(SqlSession session = factory.openSession()){
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			if(mapper.check_duplicate_id(user_id) > 0) return true;

		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}
	
	// 회원가입
	public boolean joinUser(User user) {
		try(SqlSession session = factory.openSession()){
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			mapper.joinUser(user);
			session.commit();
			return true;
		}catch(Exception e) {
		e.printStackTrace();
		}
		return false;
	}
}
