package com.foodproject.food;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {
	
	@Autowired
	FoodService service;
	
	@GetMapping("/foods")
	Iterable<Food>getAllFoods() {
		return service.getAllFoods();
	}
	
	@PostMapping("/add/food")
	String addFood(@RequestBody Food food) {
		service.addFood(food);
		return food.getFoodName()+" was added successfully.";
	}
	
	@GetMapping("/foodById/{foodId}")
	Optional<Food> getFoodById(@PathVariable int foodId) {
		return service.getFoodById(foodId);
	}
	
	@PostMapping("/update/food")
	String updateFood(@RequestBody Food food) {
		service.updateFood(food);
		return food.getFoodName()+" was updated.";
	}
	@GetMapping("/remove/food/{foodId}") 
	String removeFood(@PathVariable int foodId) {
		service.removeFood(foodId);
		return "Food with ID " + foodId + " was removed.";
	}
	
	// Remaining food operations.
	@GetMapping("/food/getByName/{foodName}")
	Iterable<Food> searchByName(@PathVariable String foodName) {
		return service.searchByName(foodName);
	}
	
	@GetMapping("/food/getByOrigin/{foodOrigin}")
	Iterable<Food> searchByOrigin(@PathVariable String foodOrigin) {
		return service.searchByOrigin(foodOrigin);
	}
	
	@GetMapping("/food/{foodId}")
	Double getFoodId(@PathVariable int foodId) {
		return service.getFoodPrice(foodId);
	}
}
