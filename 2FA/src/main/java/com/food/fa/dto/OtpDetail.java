package com.food.fa.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OtpDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer otpid;
	String otpGen;
	
	String name;
	String password;
	String email;
//	 edit below..-------------------------------
	String door_no;
	String locality;
	String city;
	String userPhone;
//	edit above..--------------------------------
	long timestamp;

	public OtpDetail(Integer otpid, String name, String password, String email, String door_no, String locality, String city, 
			String userPhone, long timestamp) {
		super();
		this.otpid = otpid;
		this.name = name;
		this.password = password;
		this.email = email;
//		edit below..----------------------------
		this.door_no = door_no;
		this.locality = locality;
		this.city = city;
		this.userPhone = userPhone;
//		edit above..----------------------------
		this.timestamp = timestamp;
	}

	public OtpDetail() {

	}

	public String getOtpGen() {
		return otpGen;
	}

	public void setOtpGen(String otpGen) {
		this.otpGen = otpGen;
	}

	public Integer getOtpid() {
		return otpid;
	}

	public void setOtpid(Integer otpid) {
		this.otpid = otpid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
//	edit below..---------------------------------------
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
//	edit above..-------------------------------------- 
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
