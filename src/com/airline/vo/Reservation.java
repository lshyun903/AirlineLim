package com.airline.vo;

public class Reservation {
	private int reser_no;
	private int flight_no;
	private String user_id;
	private String reser_date;
	private int reser_people;
	private int price;
	
	public Reservation() {}
	
	public Reservation(String user_id) {
		this.user_id = user_id;
	}
	
	public Reservation(int flight_no, int reser_people, String user_id, int price) {
		this.flight_no = flight_no;
		this.reser_people = reser_people;
		this.user_id = user_id;
		this.price = price;
		
	}

	public Reservation(int reser_no, int flight_no, String user_id, String reser_date, int reser_people, int price) {
		super();
		this.reser_no = reser_no;
		this.flight_no = flight_no;
		this.user_id = user_id;
		this.reser_date = reser_date;
		this.reser_people = reser_people;
		this.price = price;
	}

	public int getReser_no() {
		return reser_no;
	}

	public void setReser_no(int reser_no) {
		this.reser_no = reser_no;
	}

	public int getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReser_date() {
		return reser_date;
	}

	public void setReser_date(String reser_date) {
		this.reser_date = reser_date;
	}

	public int getReser_people() {
		return reser_people;
	}

	public void setReser_people(int reser_people) {
		this.reser_people = reser_people;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return reser_no + "\t" + user_id + "\t" + reser_people + "\t" + price + "\t";
	}
}
