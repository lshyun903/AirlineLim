package com.airline.control;

import java.util.ArrayList;

import com.airline.dao.ReservationDAO;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class ReservationManager {
	ReservationDAO dao = new ReservationDAO();
	
	// 해당ID 예약리스트 검색
	public ArrayList<Reservation> selectReserListById(String user_id) {
		ArrayList<Reservation> reserList = dao.selectReserListById(user_id);
		return reserList;
	}

	// 비행번호로 비행일정 검색
	public Flight selectFlightByFlightNo(int flight_no) {
		Flight flight = dao.selectFlightByFlightNo(flight_no);
		return flight;
	}
	
	// 해당 출발지 도착지에 해당하는 비행일정 리스트 검색
	public ArrayList<Flight> getFlightListByPlace(String departure, String arrival) {
		Flight flight = new Flight(departure, arrival);
		ArrayList<Flight> flightList = dao.getFlightListByPlace(flight);
		return flightList;
	}
	
	// 비행예약
	public boolean reserFlight(int flight_no, int reser_people, String login_id) {
		Flight flight = dao.selectFlightByFlightNo(flight_no);
		Reservation reser = new Reservation(flight_no, reser_people, login_id, flight.getPrice() * reser_people);
		
		if(flight.getSeat() < reser_people || reser_people < 1) return false;
		if(dao.insertReservation(reser)) return true;
		return false;
	}
	
	// 비행예약삭제
	public boolean deleteReservation(int reser_no) {
		return dao.deleteReservation(reser_no);
	}
	
	//예약 수정
	public int UpdateReservation(Reservation reser, int reser_people) {
		Flight flight = selectFlightByFlightNo(reser.getFlight_no());
		reser.setPrice(flight.getPrice() * reser.getReser_people());
		int result = dao.UpdateReservation(reser, reser_people);
		return result;
	}
	
	// 예약번호로 예약조회
	public Reservation getReservationByReserNum(int resernum) {
		Reservation reser = dao.getReservationByReserNum(resernum);
		return reser;
	}


	
}
