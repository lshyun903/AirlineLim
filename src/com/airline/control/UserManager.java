package com.airline.control;

import com.airline.dao.UserDAO;
import com.airline.vo.User;

public class UserManager {
	private UserDAO dao = new UserDAO();
	private String login_id;
	private boolean isLogin; 

	// 로그인
	public boolean login(String user_id, String passwd) {
		if(dao.login(user_id, passwd)) {
			login_id = user_id;
			isLogin = true;
			return true;
		}
		return false;
	}
	
	// 회원가입
	public boolean joinUser(User user) {
		if(!dao.check_duplicate_id(user.getUser_id())) {			
			return dao.joinUser(user);
		};
		return false;
	}

	
	// 아이디반환
	public String getLogin_id() {
		return login_id;
	}

	// 로그인 상태 확인
	public boolean isLogin() {
		if(isLogin) return true;
		return false;
	}
	
	// 로그아웃
	public void logout() {
		isLogin = false;
		login_id = null;
	}

	public boolean updateUser(User user) {		
		return dao.updateUser(user);
	}

	public User userInfo(String login_id) {
		User user = dao.userInfo(login_id);
		return user;
	}

}
