package com.foodproject.food;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository extends  CrudRepository<Food, Integer>{

	List<Food> findByFoodName(String foodName);
	List<Food> findByFoodOrigin(String foodOrigin);
	@Query(value = "select food_price from food food_id = ?", nativeQuery = true)
	Double getFoodPrice(Integer foodId);
}
