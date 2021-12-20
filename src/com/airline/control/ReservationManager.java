package com.airline.control;

import java.util.ArrayList;
import java.util.HashMap;

import com.airline.dao.ReservationDAO;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class ReservationManager {
	ReservationDAO dao = new ReservationDAO();
	
	// 비행예약
	public boolean reserFlight(Flight flight, int reser_people, String login_id) {

		Reservation reser = new Reservation(flight.getFlight_no(), reser_people, login_id, flight.getPrice() * reser_people);
		if(dao.insertReservation(reser)) return true;
		return false;
	}
	
	// 아이디로 예약조회
	public ArrayList<Reservation> selectReserListById(String user_id) {
		ArrayList<Reservation> reserList = dao.selectReserListById(user_id);
		return reserList;
	}
	
	// 비행번호로 비행정보조회
	public Flight selectFlightByFlightNo(String flight_no) {
		Flight flight = dao.selectFlightByFlightNo(flight_no);
		return flight;
	}
	
	// 예약취소
	public boolean deleteReservation(int reser_no) {
		return dao.deleteReservation(reser_no);
	}
	
	// 출발지와 도착지에 맞는 비행정보
	public ArrayList<Flight> getFlightListByPlace(String departure, String arrival) {
		Flight flight = new Flight(departure, arrival);
		ArrayList<Flight> flightList = dao.getFlightListByPlace(flight);
		return flightList;
	}
}
