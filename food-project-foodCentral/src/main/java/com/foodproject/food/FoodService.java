package com.foodproject.food;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

	@Autowired
	FoodRepository repo;

	void addFood(Food food) {
		repo.save(food);
	}
	
	Iterable<Food> getAllFoods() {
		return repo.findAll();
	}

	Optional<Food> getFoodById(int foodId) {
		return repo.findById(foodId);
	}

	void updateFood(Food food) {
		repo.save(food);

	}

	void removeFood(Integer foodId) {
		repo.deleteById(foodId);
	}
	
	Iterable<Food> searchByName(String foodName) {
		return repo.findByFoodName(foodName);
	}
	
	Iterable<Food> searchByOrigin(String foodOrigin) {
		return repo.findByFoodOrigin(foodOrigin);
	}
	
	Double getFoodPrice(Integer foodId) {
		return repo.getFoodPrice(foodId);
	}
	
}
