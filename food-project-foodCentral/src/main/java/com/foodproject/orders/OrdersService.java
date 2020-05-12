package com.foodproject.orders;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	OrdersRepository repo;
	
	Iterable<Orders> getAllOrders() {
		return repo.findAll();
	}

	List<Orders> getAllUserOrders(int id) {
		return repo.findByUserUserId(id);
	}
	
	Iterable<Orders> getMenuItemsById(int id) {
		return repo.findByMenuMenuId(id);
	}

	Optional<Orders> getOrdersById(int id) {
		return repo.findById(id);
	}

	void addOrder(Orders order) {
		repo.save(order);
	}

	void updateOrder(Orders order) {
		repo.save(order);
	}

	void removeOrder(int id) {
		repo.deleteById(id);
	}
	
	Double getUserTotalAmount(int userId) {
		return repo.fetchUserTotalAmount(userId);
	}
	
	Double getFoodPrice(int menuId) {
		return repo.getFoodPrice(menuId);
	}
	
	Integer getUserId(String email) {
		return repo.getUserId(email);
	}

	String getUserName(String email) {
		return repo.getUserName(email);
	}
}
