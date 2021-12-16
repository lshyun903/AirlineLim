package com.airline.vo;

public class Flight {
	private String flight_no;
	private String departure;
	private String arrival;
	private int price;
	private String departure_date;
	private String arrival_date;
	private String flight_time;
	
	public Flight() {}
	public Flight(String departure, String arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}
	public Flight(String flight_no, String departure, String arrival, int price, String departure_date,
			String arrival_date, String flight_time) {
		super();
		this.flight_no = flight_no;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.flight_time = flight_time;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
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
	public String getFight_time() {
		return flight_time;
	}
	public void setFight_time(String fight_time) {
		this.flight_time = fight_time;
	}
	
	@Override
	public String toString() {
		return flight_no + "\t" + departure + "\t" + arrival + "\t"
				+ price + "\t" + departure_date + "\t" + arrival_date + "\t"
				+ flight_time + "\t";
	}
	
	
}
