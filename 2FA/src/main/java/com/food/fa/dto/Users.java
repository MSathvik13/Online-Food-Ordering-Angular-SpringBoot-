package com.food.fa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private Integer userId;
	private String userName;
	private String userPassword;
	private String door_no;
	private String locality;
	private String city;
	private String userPhone;
	private String email;

	public Users() {

	}

	public Users(Integer userId, String userName, String userPassword, String door_no, String locality, String city,
			String userPhone, String email) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.door_no = door_no;
		this.locality = locality;
		this.city = city;
		this.userPhone = userPhone;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getDoor_no() {
		return door_no;
	}

	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
