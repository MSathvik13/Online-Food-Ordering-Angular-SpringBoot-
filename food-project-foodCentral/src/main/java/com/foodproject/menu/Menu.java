package com.foodproject.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.foodproject.food.Food;
import com.foodproject.restaurant.Restaurant;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;
	@ManyToOne
	Food food;

	@ManyToOne
	Restaurant restaurant;

	public Menu() {

	}

	public Menu(int menuId, int foodId, int restaurantId) {
		this.menuId = menuId;
		this.food = new Food(foodId, "", "", "", 0);
		this.restaurant = new Restaurant(restaurantId, "", "", "", "", "");
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
