package com.foodproject.orders;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.foodproject.menu.Menu;
import com.foodproject.users.Users;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Double orderAmount;

	@ManyToOne
	Users user;

	@ManyToOne
	Menu menu;

	public Orders() {

	}

	public Orders(Integer orderId, Double orderAmount, Integer userId, Integer foodId, Integer restaurantId,
			Integer menuId) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.user = new Users(userId, "", "", "", "", "", "", "");
		this.menu = new Menu(menuId, foodId, restaurantId);
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
