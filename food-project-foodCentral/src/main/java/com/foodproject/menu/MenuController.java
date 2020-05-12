package com.foodproject.menu;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

	@Autowired
	MenuService service;

	@GetMapping("/menu")
	Iterable<Menu> getAllUsers() {
		return service.getAllMenuItems();
	}

	@PostMapping("/add/menu")
	String addMenu(@RequestBody Menu menu) {
		service.addMenu(menu);
		return "New menu item was added.";
	}

	@PostMapping("/menu/{Id}")
	Optional<Menu> getMenuById(@PathVariable int Id) {
		return service.getMenuById(Id);
	}

	@PutMapping("/update/menu/{Id}")
	String updateMenu(@RequestBody Menu menu) {
		service.updateMenu(menu);
		return "Menu item was updated";
	}

	@PostMapping("/user/byFoodId/{foodId}")
	Iterable<Menu> getMenuByFoodId(@PathVariable int foodId) {
		return service.getMenuByFoodId(foodId);
	}

	@DeleteMapping("/menu/delete/{Id}")
	String deleteMenu(@PathVariable int Id) {
		service.deleteMenu(Id);
		return "Menu with ID " + Id + " was deleted";
	}

}
