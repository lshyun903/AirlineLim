package com.airline.dao;

import java.util.ArrayList;

import com.airline.vo.Airplane;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public interface AdminMapper {
	
	// 비행일정 추가
	public boolean insertFlight(Flight flight);
	
	// 모든 비행일정 리스트 검색
	public ArrayList<Flight> getFlightList();
	
	// 비행기ID 로 비행기 검색
	public Airplane getAirPlane(String airplaen_id);
	
	// 비행기 일정 삭제
	public int deleteFlight(int flight_no);
}
