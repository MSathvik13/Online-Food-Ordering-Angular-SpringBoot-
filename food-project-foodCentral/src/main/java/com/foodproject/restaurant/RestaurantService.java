package com.foodproject.restaurant;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository repo;

	Iterable<Restaurant> getAllRestaurants() {
		return repo.findAll();
	}

	void addRestaurant(Restaurant restaurant) {
		repo.save(restaurant);

	}

	Optional<Restaurant> getRestaurantById(int restaurantId) {
		return repo.findById(restaurantId);
	}

	void updateRestaurant(Restaurant restaurant) {
		repo.save(restaurant);

	}

	void removeRestaurant(Integer restaurantId) {
		repo.deleteById(restaurantId);
	}
	
	Iterable<Restaurant> searchByRestaurantName(String restaurantName) {
		return repo.findByRestaurantName(restaurantName);
	}
	
	Iterable<Restaurant> searchByLocality(String locality) {
		return repo.findByLocality(locality);
	}
	
	Iterable<Restaurant> searchByOwnerUserName(String ownerUserName) {
		return repo.findByOwnerUserName(ownerUserName);
	}
	
//	String getOwnerPassword(int restaurantId) {
//		return repo.fetchPassword(restaurantId);
//	}
}
