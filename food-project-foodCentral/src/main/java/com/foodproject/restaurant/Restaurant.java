package com.foodproject.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;

	private String restaurantName;

	private String ownerUserName;

	private String ownerPassword;

	private String restaurantPhone;

	private String locality;

	public Restaurant() {

	}
	
	public Restaurant(String restaurantName, String ownerUserName, String ownerPassword,
		   String restaurantPhone, String locality) {
		this.restaurantName = restaurantName;
		this.ownerUserName = ownerUserName;
		this.ownerPassword = ownerPassword;
		this.restaurantPhone = restaurantPhone;
		this.locality = locality;
	}

	public Restaurant(Integer restaurantId, String restaurantName, 
			String ownerUserName, String ownerPassword,
			String restaurantPhone, String locality) {
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.ownerUserName = ownerUserName;
		this.ownerPassword = ownerPassword;
		this.restaurantPhone = restaurantPhone;
		this.locality = locality;
	}

	public String getRestaurantPhone() {
		return restaurantPhone;
	}

	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

	public String getOwnerUserName() {
		return ownerUserName;
	}

	public void setOwnerUserName(String ownerUserName) {
		this.ownerUserName = ownerUserName;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

}
