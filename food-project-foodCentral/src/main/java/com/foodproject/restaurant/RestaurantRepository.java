package com.foodproject.restaurant;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

	List<Restaurant> findByRestaurantName(String restaurantName);

	List<Restaurant> findByLocality(String locality);

	List<Restaurant> findByOwnerUserName(String ownerUserName);

	/*
	 * @Query(value = "select owner_password from users where restaurant_id = ?1",
	 * nativeQuery = true) String fetchPassword(Integer restaurantId);
	 */
}
