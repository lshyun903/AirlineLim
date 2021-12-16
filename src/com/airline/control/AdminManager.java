package com.airline.control;

import java.util.ArrayList;

import com.airline.dao.AdminDAO;
import com.airline.vo.Flight;
import com.airline.vo.Reservation;

public class AdminManager {
	
	AdminDAO dao = new AdminDAO();
	private final String admin_passwd = "abc123";

	public boolean admin_login(String passwd) {
		if(admin_passwd.equals(passwd)) return true;
		return false;
	}

	public boolean insertFlight(Flight flight) {
		return dao.insertFlight(flight);
	}
	
	public ArrayList<Flight> getFlightList() {
		ArrayList<Flight> flightList = dao.getFlightList();
		return flightList;
	}

	
	

}
