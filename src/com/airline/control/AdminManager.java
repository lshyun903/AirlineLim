package com.airline.control;

import java.util.ArrayList;

import com.airline.dao.AdminDAO;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class AdminManager {
	
	AdminDAO dao = new AdminDAO();
	private final String admin_passwd = "abc123";
	
	// 관리자로그인
	public boolean admin_login(String passwd) {
		if(admin_passwd.equals(passwd)) return true;
		return false;
	}
	
	// 비행일정추가
	public boolean insertFlight(Flight flight) {
		return dao.insertFlight(flight);
	}
	
	// 전체비행리스트
	public ArrayList<Flight> getFlightList() {
		ArrayList<Flight> flightList = dao.getFlightList();
		return flightList;
	}

}
