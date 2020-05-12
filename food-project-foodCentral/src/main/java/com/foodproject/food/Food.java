package com.foodproject.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer foodId;
	private String foodName;
	private String foodOrigin;
	private String vegNonveg;
	private float foodPrice;

	public Food() {

	}
	public Food(String foodName, String foodOrigin, String vegNonveg, float foodPrice) {
		this.foodName = foodName;
		this.foodOrigin = foodOrigin;
		this.vegNonveg = vegNonveg;
		this.foodPrice = foodPrice;
	}
	public Food(Integer foodId, String foodName, String foodOrigin, String vegNonveg, float foodPrice) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodOrigin = foodOrigin;
		this.vegNonveg = vegNonveg;
		this.foodPrice = foodPrice;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodOrigin() {
		return foodOrigin;
	}

	public void setFoodOrigin(String foodOrigin) {
		this.foodOrigin = foodOrigin;
	}

	public String getVegNonveg() {
		return vegNonveg;
	}

	public void setVegNonveg(String vegNonveg) {
		this.vegNonveg = vegNonveg;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

}
