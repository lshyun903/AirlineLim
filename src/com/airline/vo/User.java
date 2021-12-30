package com.airline.vo;

public class User {

	private String user_id;
	private String passwd;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public User(String user_id, String passwd, String name, String email, String phone, String address) {
		this.user_id = user_id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public User(String user_id,String passwd, String email, String phone, String address) {
		this.user_id = user_id;
		this.passwd = passwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return  user_id + "\t" + name + "\t" + email + "\t" + phone + "\t" + address;
	}
}
