package com.foodproject.menu;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

	@Autowired
	MenuRepository repo;

	Iterable<Menu> getAllMenuItems() {
		return repo.findAll();
	}

	Optional<Menu> getMenuById(int menuId) {
		return repo.findById(menuId);
	}
	
	Iterable<Menu> getMenuByFoodId(int foodId) {
		return repo.findByFoodFoodId(foodId);
	}
	
	Iterable<Menu> getMenuByRestaurantId(int restaurantId) {
		return repo.findByRestaurantRestaurantId(restaurantId);
	}

	void addMenu(Menu menu) {
		repo.save(menu);
	}


	void deleteMenu(int menuId) {
		repo.deleteById(menuId);
	}


	void updateMenu(Menu menu) {
		repo.save(menu); // save() is used for both adding and updating records of a database.
							// adds record into database if the referring id doesn't exist.
	}
	

}
