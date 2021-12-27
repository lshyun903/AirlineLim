package com.airline.control;

import java.util.ArrayList;

import com.airline.dao.AdminDAO;
import com.airline.vo.Airplane;
import com.airline.vo.Flight;

public class AdminManager {
	
	AdminDAO dao = new AdminDAO();
	private final String admin_passwd = "abc123";

	// 관리자 로그인
	public boolean admin_login(String passwd) {
		if(admin_passwd.equals(passwd)) return true;
		return false;
	}
	
	// 비행일정 추가
	public boolean insertFlight(Flight flight) {
		return dao.insertFlight(flight);
	}
	
	// 모든 비행일정 리스트 검색
	public ArrayList<Flight> getFlightList() {
		ArrayList<Flight> flightList = dao.getFlightList();
		return flightList;
	}
	
	// 비행기ID 로 비행기 검색
	public Airplane getAirplane(String airplaen_id) {
		Airplane airplane= dao.getAirplane(airplaen_id);
		return airplane;
	}

	public int deleteFlight(int flight_no) {
		//String airplane_id = dao.findAirplaneId(flight_no).getAirplane_id();
		dao.deleteReservation(flight_no);
		return dao.deleteFlight(flight_no);
	}
	
	

}
