package com.airline.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public interface ReservationMapper {
	
	// 전달받은 정보로 비행예약
	public void insertReservation(Reservation reser);

	// 예약번호로 비행예약 삭제
	public void deleteReservation(int reser_no);
	
	// 회원 예약내역 검색
	public ArrayList<Reservation> selectReserListById(String user_id);

	// 비행번호로 비행일정 검색
	public Flight selectFlightByFlightNo(String flight_no);

	// 전달받은 출발지, 목적지와 일치하는 비행일정 리스트 검색
	public ArrayList<Flight> getFlightListByPlace(Flight flight);


}
