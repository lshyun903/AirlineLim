package com.airline.vo;

public class Flight {
	private int flight_no;
	private String airplane_id;
	private String departure;
	private String arrival;
	private int price;
	private String departure_date;
	private String arrival_date;
	private String flight_time;
	private int seat;
	
	public Flight() {}
	public Flight(String departure, String arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public Flight(int flight_no, String airplane_id, String departure, String arrival, int price, String departure_date,
			String arrival_date, String flight_time, int seat) {
		super();
		this.flight_no = flight_no;
		this.airplane_id = airplane_id;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.flight_time = flight_time;
		this.seat = seat;
	}
	
	public Flight(String airplane_id, String departure, String arrival, int price, String departure_date,
			String arrival_date, String flight_time, int seat) {
		this.airplane_id = airplane_id;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.flight_time = flight_time;
		this.seat = seat;
	}
	
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public String getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(String airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(String arrival_date) {
		this.arrival_date = arrival_date;
	}
	public String getFlight_time() {
		return flight_time;
	}
	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
		return flight_no + "\t" + departure + "\t" + arrival + "\t"
				+ price + "\t" + departure_date + "\t" + arrival_date + "\t"
				+ flight_time + "\t" + seat + "\t";
	}

}
