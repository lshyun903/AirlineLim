package com.airline.dao;

import java.util.HashMap;

import com.airline.vo.User;

public interface UserMapper {

	// 로그인
	public int login(HashMap<String, String> loginMap);
	
	// 아이디 중복 체크
	public int check_duplicate_id(String id);
	
	// 회원가입 처리
	public int joinUser(User user);

	// 회원정보 수정
	public int updateUser(User user);

	// 회원정보 검색
	public User userInfo(String login_id);
	
}
