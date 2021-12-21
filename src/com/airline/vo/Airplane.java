package com.airline.vo;

public class Airplane {
	private String airplane_id;
	private int airplane_seat;
	
	public Airplane() {}

	public Airplane(String airplane_id, int airplane_seat) {
		super();
		this.airplane_id = airplane_id;
		this.airplane_seat = airplane_seat;
	}

	public String getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(String airplane_id) {
		this.airplane_id = airplane_id;
	}

	public int getAirplane_seat() {
		return airplane_seat;
	}

	public void setAirplane_seat(int airplane_seat) {
		this.airplane_seat = airplane_seat;
	}	
	
	
}
