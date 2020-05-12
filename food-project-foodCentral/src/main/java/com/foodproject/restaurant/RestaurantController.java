package com.foodproject.restaurant;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Restaurant API", description= "Info about Restaurant entity")
public class RestaurantController {
	
	@Autowired
	RestaurantService service;
	
	@ApiOperation(value="Display all restaurants",
				  notes="Click here to get all restaurants from DB")
	@GetMapping("/restaurants")
	Iterable<Restaurant> getAllRestaurants() {
		return service.getAllRestaurants();
	}
	
//	
	@ApiOperation(value="Add a new restaurant",
			  notes="Click here to add restaurant to DB")
	@PostMapping("/add/restaurant")
	String addRestaurant(@RequestBody Restaurant restaurant) {
		service.addRestaurant(restaurant);
		return restaurant.getRestaurantName()+" was added successfully.";
	}
	
//	
	@ApiOperation(value="Retrieve restaurant by ID",
			  notes="Click here to get that restaurant details")
	@GetMapping("/get/restaurantById/{restaurantId}")
	Optional<Restaurant> getRestaurantById(@PathVariable int restaurantId) {
		return service.getRestaurantById(restaurantId);
	}
	
//	
	@ApiOperation(value="Update restaurant",
			  notes="Click here to update restaurant details")
	@PostMapping("/update/restaurant")
	String updateRestaurant(@RequestBody Restaurant restaurant) {
		service.updateRestaurant(restaurant);
		return restaurant.getRestaurantName()+" was updated.";
	}
	
//	
	@ApiOperation(value="Remove restaurant",
			  notes="Click here to remove restaurant details")
	@GetMapping("/remove/restaurant/{restaurantId}") 
	String removeRestaurant(@PathVariable int restaurantId) {
		service.removeRestaurant(restaurantId);
		return "Restaurant with ID " + restaurantId + " was removed.";
	}
	
//	
	@ApiOperation(value="Search restaurant by Owner UserName",
			  notes="Click here to get that restaurant details")
	@GetMapping("/search/ownerByUserName/{ownerUserName}")
	Iterable<Restaurant> searchByOwnerUserName(@PathVariable String ownerUserName){
		return service.searchByOwnerUserName(ownerUserName);
	}
	
//	
//	@ApiOperation(value="Retrieve Owner Password",
//			  notes="Click here to get owner's password")
//	@GetMapping("/fetch/ownerPassword/{restaurantId}")
//	String getOwnerPassword(@PathVariable int restaurantId) {
//		return service.getOwnerPassword(restaurantId);
//	}
	
//	
	@ApiOperation(value="Retrieve restaurants by locality", 
			 notes="Click here to view restaurants by locality")
	@GetMapping("/fetch/restaurant/locality/{locality}")
	Iterable<Restaurant> getRestaurantByLocation(@PathVariable String locality) {
		return service.searchByLocality(locality);
	}
}
