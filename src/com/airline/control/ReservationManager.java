package com.airline.control;

import java.util.ArrayList;
import java.util.HashMap;

import com.airline.dao.ReservationDAO;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class ReservationManager {
	ReservationDAO dao = new ReservationDAO();
	

	public boolean reserFlight(String flight_no, int reser_people, String login_id) {
		Flight flight = dao.selectFlightByFlightNo(flight_no);
		Reservation reser = new Reservation(flight_no, reser_people, login_id, flight.getPrice() * reser_people);
		if(dao.insertReservation(reser)) return true;
		return false;
	}

	public ArrayList<Reservation> selectReserListById(String user_id) {
		ArrayList<Reservation> reserList = dao.selectReserListById(user_id);
		return reserList;
	}

	public Flight selectFlightByFlightNo(String flight_no) {
		Flight flight = dao.selectFlightByFlightNo(flight_no);
		return flight;
	}
	

	public boolean deleteReservation(int reser_no) {
		return dao.deleteReservation(reser_no);
	}

	public ArrayList<Flight> getFlightListByPlace(String departure, String arrival) {
		Flight flight = new Flight(departure, arrival);
		ArrayList<Flight> flightList = dao.getFlightListByPlace(flight);
		return flightList;
	}
}
