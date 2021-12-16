package com.airline.dao;

import java.util.ArrayList;

import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public interface AdminMapper {
	
	// 비행번호 중복확인
	public int countFlightNo(String flight_no);
	
	// 비행일정 추가하기
	public boolean insertFlight(Flight flight);
	
	// 모든 비행일정 리스트로 받아오기
	public ArrayList<Flight> getFlightList();
}
